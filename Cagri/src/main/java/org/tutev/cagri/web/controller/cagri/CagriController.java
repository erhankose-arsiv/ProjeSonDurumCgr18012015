package org.tutev.cagri.web.controller.cagri;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.hibernate.cache.spi.QueryResultsRegion;
import org.primefaces.component.column.Column;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.Submenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.dto.genel.Il;
import org.tutev.cagri.web.dto.genel.Ilce;
import org.tutev.cagri.web.service.CagriService;
import org.tutev.cagri.web.service.GenericService;

@Controller("cagriController")
@Scope(value = "view")
public class CagriController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2354524395435334338L;

	Date date;

	@Autowired
	private transient CagriService cagriService;
	@Autowired
	private transient GenericService genericService;

	Cagri cagri;
	List<Cagri> cagriList;
	Ilce ilce;
	List<Ilce> ilceList;

	@PostConstruct
	private void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		listele();
		ilce = new Ilce();
		cagri = new Cagri();
	}

	private void listele() {
		cagriList = cagriService.getAll();
	}

	private LazyDataModel<Cagri> lazyModel;
	public LazyDataModel<Cagri> getLazyModel() {
		return lazyModel;
	}
//
//	public void listele() {
//		this.lazyModel = new LazyDataModel<Cagri>() {
//
//			private static final long serialVersionUID = 7152924823060002874L;
//			private List<Cagri> liste;
//			@SuppressWarnings("unchecked")
//			@Override
//			public List<Cagri> load(int firstRecord, int pageSize, String sortField,SortOrder sortOrder, Map<String, String> filters) {
//				
//				OrderData orderData = null;
//				if (sortField != null) {
//					orderData = new OrderData(sortField, sortOrder.equals(SortOrder.ASCENDING) ? OrderType.ASC : OrderType.DESC);
//				}
//				else {
//					orderData = new OrderData("id", OrderType.ASC);
//				}
//				
//				QueryResults qr = cagriService.getCagriListesi(filters, orderData, firstRecord, pageSize);
//				lazyModel.setRowCount(qr.getCount());
//				liste = qr.getList();
//				return liste;
//			}
//
//			@Override
//			public Object getRowKey(Cagri cagri) {
//				return cagri.getId();
//			}
//			
//		   @Override
//		    public Cagri getRowData(String rowKey) {
//			   Long id = new Long(rowKey);
//		        for(Cagri cagri: liste) {
//		            if (cagri.getId().equals(id)){
//		            	return cagri;
//		            }
//		        }
//		        return null;
//		    }
//		};
//	}   
//	
	
	public void save() {
		if(cagri.getId()==null){
			cagriService.save(cagri);
			cagri = new Cagri();
			listele();
		}else{
			cagriService.update(cagri);
			cagri = new Cagri();
			listele();
		}
	}
	
	public void ilChanged() {
		if(getCagri()!=null && getCagri().getIl()!=null){
			ilceList=genericService.getIlceByIlId(getCagri().getIl().getId());
		}
	}

	public void delete() {
		cagriService.delete(cagri);
		listele();

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Cagri> getCagriList() {
		return cagriList;
	}

	public void setCagriList(List<Cagri> cagriList) {
		this.cagriList = cagriList;
	}

	public Cagri getCagri() {
		if(this.cagri==null){
			this.cagri=new Cagri();
			
		}
		return cagri;
	}

	public void setCagri(Cagri cagri) {
		this.cagri = cagri;
	}

	public Ilce getIlce() {
		return ilce;
	}
	public void setIlce(Ilce ilce) {
		this.ilce = ilce;
	}

	public List<Ilce> getIlceList() {
		return ilceList;
	}
	public void setIlceList(List<Ilce> ilceList) {
		this.ilceList = ilceList;
	}
}

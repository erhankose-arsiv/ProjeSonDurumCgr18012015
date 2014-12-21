package org.tutev.cagri.web.controller.cagri;

import java.io.Serializable;
import java.nio.file.DirectoryStream.Filter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.base.OrderData;
import org.tutev.cagri.web.base.OrderType;
import org.tutev.cagri.web.base.QueryResults;
import org.tutev.cagri.web.controller.MessageController;
import org.tutev.cagri.web.dto.Sabit;
import org.tutev.cagri.web.dto.cagri.Cagri;
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


	@Autowired
	private transient CagriService cagriService;
	@Autowired
	private transient GenericService genericService;
	@Autowired
	private transient MessageController messageController;

	Cagri cagri;
	List<Cagri> cagriList;
	List<Ilce> ilceList;
	Date gelisTarihiBitis;
	Date gelisTarihiBaslama;

	@PostConstruct
	private void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		listele();
		cagri = new Cagri();
	}

//	private void listele() {
//		cagriList = cagriService.getAll();
//	}

	private LazyDataModel<Cagri> lazyModel;
	public LazyDataModel<Cagri> getLazyModel() {
		return lazyModel;
	}

	
	public void listele() {
		this.lazyModel = new LazyDataModel<Cagri>() {

			private static final long serialVersionUID = 7152924823060002874L;
			
			private List<Cagri> liste;
			@SuppressWarnings("unchecked")
			@Override
			public List<Cagri> load(int firstRecord, int pageSize, String sortField,SortOrder sortOrder, Map<String, String> filters) {
				
				OrderData orderData = null;
				if (sortField != null) {
					orderData = new OrderData(sortField, sortOrder.equals(SortOrder.ASCENDING) ? OrderType.ASC : OrderType.DESC);
				}
				else {
					orderData = new OrderData("id", OrderType.ASC);
				}
				
				
				if(gelisTarihiBitis!=null){
					filters.put("gelisTarihiBitis", Sabit.dateToStringDDMMYYY(gelisTarihiBitis));
				}
				if(gelisTarihiBaslama!=null){
					filters.put("gelisTarihiBaslama", Sabit.dateToStringDDMMYYY(gelisTarihiBaslama));
				}
				
				QueryResults qr = cagriService.getCagriListesi(filters, orderData, firstRecord, pageSize);
				lazyModel.setRowCount(qr.getRowCount());
				liste = qr.getListe();
				return liste;
			}

			@Override
			public Object getRowKey(Cagri cagri) {
				return cagri.getId();
			}
			
		   @Override
		    public Cagri getRowData(String rowKey) {
			   Long id = new Long(rowKey);
		        for(Cagri cagri: liste) {
		            if (cagri.getId().equals(id)){
		            	return cagri;
		            }
		        }
		        return null;
		    }
		};
	}   
	
	
	public void clearFilters() {
		gelisTarihiBaslama=null;
		gelisTarihiBitis=null;

	}
	
	public void save() {
		if(cagri.getId()==null){
			cagriService.save(cagri);
			messageController.kaydetmeBasarili();
		}else{
			cagriService.update(cagri);
			messageController.guncellemeBasarili();
		}
	
		cagri = null;
		listele();
		ilceList=null;
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
	
	public void yeni() {
		cagri=null;
		ilceList=genericService.getIlceByIlId(1L);
		RequestContext.getCurrentInstance().update(":cagriForm:dlgCagri");

	}
	
	
	public void filter() {

		if(gelisTarihiBitis!=null){
			listele();
		}
		if(gelisTarihiBaslama!=null){
			listele();
		}
	}
	
	public void onRowSelect() {
		ilceList=genericService.getIlceByIlId(getCagri().getIl().getId());
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

	public List<Ilce> getIlceList() {
		return ilceList;
	}
	public void setIlceList(List<Ilce> ilceList) {
		this.ilceList = ilceList;
	}
	
	public Date getGelisTarihiBaslama() {
		return gelisTarihiBaslama;
	}
	
	public void setGelisTarihiBaslama(Date gelisTarihiBaslama) {
		this.gelisTarihiBaslama = gelisTarihiBaslama;
	}
	
	public Date getGelisTarihiBitis() {
		return gelisTarihiBitis;
	}
	
	public void setGelisTarihiBitis(Date gelisTarihiBitis) {
		this.gelisTarihiBitis = gelisTarihiBitis;
	}
}

package org.tutev.cagri.web.controller.personel;

import java.io.Serializable;
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
import org.tutev.cagri.web.dto.personel.Personel;
import org.tutev.cagri.web.service.GenericService;
import org.tutev.cagri.web.service.personelService.PersonelService;

@Controller("personelController")
@Scope(value="session")
public class PersonelController implements Serializable {
	private static final long serialVersionUID = 1L;

	Long tc;
	
	@Autowired
	private transient PersonelService personelService;
	@Autowired
	private transient GenericService genericService;
	@Autowired
	private transient MessageController messageController;

	
	public Personel getPersonel() {
		if(this.personel==null){
			this.personel=new Personel();
			
		}
		return personel;
	}
	public void setPersonel(Personel personel) {
		this.personel = personel;
	}

	Personel  personel;
	List<Personel> personelList;
	
	@PostConstruct
	public void init() {		
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		listele();
		personel = new Personel();
	}
	
	private LazyDataModel<Personel> lazyModel;
	public LazyDataModel<Personel> getLazyModel() {
		return lazyModel;
	}
	public void listele() {
		this.lazyModel= new  LazyDataModel<Personel>() {
			private static final long serialVersionUID = 1L;
			
			private List<Personel> liste;
			@SuppressWarnings("unchecked")
			@Override
			public List<Personel> load(int firstRecord, int pageSize, String sortField,SortOrder sortOrder, Map<String, String> filters) {
				
				OrderData orderData = null;
				if (sortField != null) {
					orderData = new OrderData(sortField, sortOrder.equals(SortOrder.ASCENDING) ? OrderType.ASC : OrderType.DESC);
				}
				else {
					orderData = new OrderData("id", OrderType.ASC);
				}
				
				QueryResults qr = personelService.getPersonelListesi(filters, orderData, firstRecord, pageSize);
				lazyModel.setRowCount(qr.getRowCount());
				liste = qr.getListe();
				return liste;

			}

		
		};
	}

	public Long getTc() {
		return tc;
	}


	public void setTc(Long tc) {
		this.tc = tc;
	}


	public List<Personel> getPersonelList() {
		return personelList;
	}


	public void setPersonelList(List<Personel> personelList) {
		this.personelList = personelList;
	}
	
	public void onRowSelect() {
		
	}
	
	public void yeni() {
		personel=null;
		RequestContext.getCurrentInstance().update(":personelForm:dlgPersonel");
	}
	
	public void clearFilters() {
		
	}
	
	public void save() {
		if(personel.getId()==null){
			personelService.save(personel);
			messageController.kaydetmeBasarili();
		}else{
			personelService.update(personel);
			messageController.guncellemeBasarili();
		}
	
		personel = null;
		listele();
	
	}
	
	public void delete() {
		personelService.delete(personel);
		listele();
	}
}

	

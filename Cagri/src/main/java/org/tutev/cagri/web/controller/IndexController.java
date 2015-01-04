package org.tutev.cagri.web.controller;

import java.io.Serializable;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.DirectoryStream.Filter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;

import net.webservicex.GetWeather;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

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
import org.tutev.cagri.web.dto.genel.Il;
import org.tutev.cagri.web.dto.genel.Ilce;
import org.tutev.cagri.web.service.CagriService;
import org.tutev.cagri.web.service.GenericService;

@Controller("indexController")
@Scope(value = "view")
public class IndexController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2354524395435334338L;

	@Autowired
	GenericService genericService;

	Il il;
	CurrentWeather curWeather;


	@PostConstruct
	private void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

	public void havaDurumuVer() {
		GlobalWeather gw;
		try {
			
			
			gw = new GlobalWeather(new URL("http://www.webservicex.net/globalweather.asmx?wsdl"));
			GlobalWeatherSoap soap=gw.getGlobalWeatherSoap();
			String donenMesaj=soap.getWeather(il.getTanim(), "TURKEY");
			System.out.println(donenMesaj);
			
//			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
//			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//			StringReader reader = new StringReader("xml string here");
//			Person person = (Person) unmarshaller.unmarshal(reader);
			
			this.curWeather = JAXB.unmarshal(new StringReader(donenMesaj), CurrentWeather.class);

//			String cityNames=soap.getCitiesByCountry("TURKEY");
//			System.out.println(cityNames);
			RequestContext.getCurrentInstance().update(":frmAnaSayfa:pnlHavaDurumDetay");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}



	}
	
	public List<Il> ilComplete(String name) {
		List<Il> illist= genericService.getIlByName(name);
		return illist;
	}
	
	public Il getIl() {
		return il;
	}
	public void setIl(Il il) {
		this.il = il;
	}
	
	public CurrentWeather getCurWeather() {
		return curWeather;
	}
	public void setCurWeather(CurrentWeather curWeather) {
		this.curWeather = curWeather;
	}
}

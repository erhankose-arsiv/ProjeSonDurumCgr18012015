package org.tutev.cagri.ws;

import java.io.Serializable;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@WebService(name="CagriWebService", portName="CagriWebService",
serviceName="CagriWebService",targetNamespace="incident.tutev.org")
public class CagriWebService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private transient CagriWsService cagriWsService;
	
	@WebMethod(operationName="getIncidentByNo")
	public CagriServiceResponse getCagriByNo(@WebParam(name="incidentNo") String cagriNo,
			@WebParam(name="username") String kullaniciAdi,
			@WebParam(name="password") String password) {
		
		return cagriWsService.cagriSorgula(cagriNo,kullaniciAdi,password);
	}
	

	
}

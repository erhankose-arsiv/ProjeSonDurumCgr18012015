package org.tutev.cagri.web.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

	@Controller("messagesController")
	@Scope("request")
	public class MessageController implements Serializable {
		
		@Autowired
		private MessageProvider messageProvider;

		public void addInfo(String summary, String detail) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
		}
		
		public void addInfo(String id, String summary, String detail) {
			FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
		}
		
		public void addWarn(String summary, String detail) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
		}

		public void addWarn(String id, String summary, String detail) {
			FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
		}
		
		public void addError(String summary, String detail) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
		}
		
		public void addError(String id, String summary, String detail) {
			FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
		}
		
		public void addFatal(String summary, String detail) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail));
		}
		
		public boolean isMesajVar() {
			return FacesContext.getCurrentInstance().getMessageList() != null && FacesContext.getCurrentInstance().getMessageList().size() > 0; 
		}
		
		public void kaydetmeBasarili()  {
			addInfo(messageProvider.getValue("labels.tr.message.kaydetme.basarili"), ""); 
		}
		public void silmeBasarili()  {
			addInfo(messageProvider.getValue("labels.tr.message.silme.basarili"), "");
		}
		public void guncellemeBasarili()  {
			addInfo(messageProvider.getValue("labels.tr.message.guncelleme.basarili"), "");
		}


	}


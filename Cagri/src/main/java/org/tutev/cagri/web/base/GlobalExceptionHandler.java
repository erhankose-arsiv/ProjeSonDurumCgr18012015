package org.tutev.cagri.web.base;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.service.GenericService;

public  class GlobalExceptionHandler  extends ExceptionHandlerWrapper  {
	
	private ExceptionHandler exceptionHandler;
	
//	@Autowired
//	private transient GenericService genericService;
	

	public GlobalExceptionHandler(ExceptionHandler exceptionHandler) {	
		this.exceptionHandler = exceptionHandler;
	}
	
	
	@Override
	public ExceptionHandler getWrapped() {
		return this.exceptionHandler;
	}
	
	@Override
	public void handle() throws FacesException {
		for(Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext(); ) {
			ExceptionQueuedEvent exceptionQueuedEvent = i.next();
			ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) exceptionQueuedEvent.getSource();
			Throwable throwable = exceptionQueuedEventContext.getException();

			if (throwable instanceof Throwable) {
				Throwable t = (Throwable)throwable;
				t.printStackTrace();
		
//				genericService.addException(new Exception(t.toString()));
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
				
				try{
					UIViewRoot viewRoot = facesContext.getViewRoot();
					if (viewRoot != null) {
						Map<String, Object> viewMap = viewRoot.getViewMap(); 
						if (viewMap != null)
							viewMap.clear();
					}

					navigationHandler.handleNavigation(facesContext, null, "/hata.xhtml?faces-redirect=true");
					facesContext.renderResponse();
				} finally {
					i.remove();
				}
			}
		}
	}


	
}


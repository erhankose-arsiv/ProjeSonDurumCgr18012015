package org.tutev.cagri.web.base;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class GlobalException extends ExceptionHandlerFactory {
	
	private ExceptionHandlerFactory exceptionHandlerFactory;
	
	public GlobalException(ExceptionHandlerFactory exceptionHandlerFactory) {	
		this.exceptionHandlerFactory = exceptionHandlerFactory;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler result = exceptionHandlerFactory.getExceptionHandler();
		result = new GlobalExceptionHandler(result);
		return result;
	}
}
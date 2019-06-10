package com.satya.springSecurity.exception;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.FORBIDDEN)
public class UnauthorisedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4420736475855917642L;

	protected static MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();
	
	public UnauthorisedException() {
		super(message.getMessage("AbstractAcessDecisionManager.acessDenied","Acess is Denied"));
	}
	
	public UnauthorisedException(String message) {
		super(message);
	}
}

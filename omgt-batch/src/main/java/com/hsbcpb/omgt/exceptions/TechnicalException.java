package com.hsbcpb.omgt.exceptions;

public class TechnicalException extends RuntimeException {

	private static final long serialVersionUID = 6115324290688968492L;

	private String message;
	
	public TechnicalException(String message) {
		this.message = message;
	}
	
    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
    	return message;
    }
}

package com.superm.easy.cloud.commons.exception;

/** 
 * @author hu.sheng
 * @since 20190425
 */
public class UnexpectedException extends BaseException {

	private static final long serialVersionUID = -5412560509408928461L;

	public UnexpectedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UnexpectedException(String msg) {
		super(msg);
	}

}

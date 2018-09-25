package com.springboot.exception;

/**
 * 全局统一异常类
 * <p>
 * Title: GeneralException
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: xxx
 * </p>
 * 
 * @author Mr.yang
 * @date 2018年9月25日 下午9:10:15
 */
public class GeneralException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1610229798623639107L;

	/**
	 * 异常错误码
	 */
	private final String errorCode;

	public GeneralException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public GeneralException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public GeneralException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public GeneralException(String errorCode, Throwable cause) {
		this(errorCode);
	}

	public String getErrorCode() {
		return errorCode;
	}

}

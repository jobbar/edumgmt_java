package net.shinc.common;

/**
 * 错误提示信息枚
 * @author wang_hw
 */
public enum ErrorMessage {

	SUCCESS("SUCCESS"),
	ERROR_DEFAULT("ERROR_DEFAULT"),
	RESULT_EMPTY("RESULT_EMPTY"),
	LOGIN_FAILED("LOGIN_FAILED"),
	NEED_LOGIN("NEED_LOGIN"),
	LOGIN_SUCCESS("LOGIN_SUCCESS"),
	PASSWORD_WRONG("PASSWORD_WRONG"),
	NEWPASSWORD_WRONG("NEWPASSWORD_WRONG"),
	NICKNAME_EXIST("NICKNAME_EXIST"),

	USER_NONE("USER_NONE"),
	USER_UNABLE("USER_UNABLE");
	
	private String code;
	ErrorMessage(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
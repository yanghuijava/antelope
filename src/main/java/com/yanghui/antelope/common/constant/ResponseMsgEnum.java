package com.yanghui.antelope.common.constant;

public enum ResponseMsgEnum {
	
	SUCCESS(110200,"操作成功"),
	ERROR(110500,"系统异常"),
	FIAL(110201,"操作失败"),
	ROLEIDNOTNULL(110202,"角色ID不能为空"),
	NOAUTH(110203,"您无权访问,请联系管理员！"),
	;
	
	private int code;
	private String message;
	
	private ResponseMsgEnum(int code, String message){
		this.code = code;
        this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

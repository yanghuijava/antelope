package com.yanghui.antelope.common.exception;

import com.yanghui.antelope.common.constant.ResponseMsgEnum;

import lombok.Data;
@Data
public class BusinessExcption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int code;
	
	
	
	public BusinessExcption(ResponseMsgEnum responseMsgEnum){
		super(responseMsgEnum.getMessage());
		this.code = responseMsgEnum.getCode();
	}
	
	public BusinessExcption(String message, Throwable e){
        super(message, e);
    }

    public BusinessExcption(int code, String message, Throwable e){
        super(message, e);
        this.code = code;
    }
    
    public BusinessExcption(String message){
        super(message);
    }
}

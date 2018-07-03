package com.yanghui.antelope.web.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yanghui.antelope.common.constant.ResponseMsgEnum;

import lombok.Data;

@Data
public class Wrapper<T> {
	
	private Integer code;
	private String message;
	private T data;
	private boolean success;
	@JsonProperty("isError")
	private boolean isError = false;
	private Date systemTime = new Date();
	
	public static <E> Wrapper<E> wrap(String message,boolean success){
		Wrapper<E> resutl = new Wrapper<E>();
		resutl.setSuccess(success);
		resutl.setMessage(message);
		return resutl;
	}
	
	public static <E> Wrapper<E> wrap(int code, String message, E data){
		Wrapper<E> resutl = new Wrapper<E>();
		resutl.setCode(code);
		resutl.setMessage(message);
		resutl.setData(data);
		return resutl;
	}
	
	public static <E> Wrapper<E> wrap(ResponseMsgEnum rme, E data){
		Wrapper<E> resutl = new Wrapper<E>();
		resutl.setCode(rme.getCode());
		resutl.setMessage(rme.getMessage());
		resutl.setData(data);
		return resutl;
	}
	
	public static <E> Wrapper<E> wrap(ResponseMsgEnum rme){
		Wrapper<E> resutl = new Wrapper<E>();
		resutl.setCode(rme.getCode());
		resutl.setMessage(rme.getMessage());
		return resutl;
	}
	
	public Wrapper<T> setData(T t){
		this.data = t;
		return this;
	}
}

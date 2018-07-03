package com.yanghui.antelope.web.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CustomerVO implements Serializable {
	private static final long serialVersionUID = 3003121861549196078L;
	
	private Long id;
	private String name;
	private String identityCard;
	private String phoneNumber;
	private Long accountManager;
	private String accountManagerName;
	private String source;
	private String homeAddress;
	private String nativePlace;
	private String address;
	private Integer marriageStatus;
	private String marriageStatusName;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date comeShenzhenDate;
	private String comeShenzhenDateStr;
	private Integer type;
	private String typeName;
	private String creditReport;
	private String flowFile;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;
	
	private String createByName;
	private String updateByName;

}

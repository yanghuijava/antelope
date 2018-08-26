package com.yanghui.antelope.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PolicyVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Long customerId;
	private String insuranceCompany;
	private String insuranceName;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date buyTime;
	private BigDecimal buyPrice;
}

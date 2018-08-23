package com.yanghui.antelope.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BusinessVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long customerId;
	private String companyName;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date setupDate;
	private Integer corporation;
	private String corporationName;
	private BigDecimal shareStock;
	private String industryType;
	private BigDecimal halfYearTicket;
	private BigDecimal taxes;
	private String personalWater;
}

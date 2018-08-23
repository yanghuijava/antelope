package com.yanghui.antelope.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EstateVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private BigDecimal area;
	private Date purchaseTime;
	private String pledgeBank;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date pledgeTime;
	private Integer loanTerm;
	private BigDecimal loanLimit;
	private BigDecimal monthlySupply;
	private String proofDataFile;
	private String remark;
}

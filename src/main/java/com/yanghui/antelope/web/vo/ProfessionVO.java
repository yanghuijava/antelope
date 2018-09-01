package com.yanghui.antelope.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProfessionVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long customerId;
	private String companyName;
	private String industry;
	private String companySize;
	private String deptName;
	private String position;
	private Integer wageModel;
	private String wageModelName;
	private BigDecimal monthIncome;
	private Integer socialSecurityYears;
	private BigDecimal socialSecurityBase;
}

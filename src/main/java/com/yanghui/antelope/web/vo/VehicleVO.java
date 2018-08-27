package com.yanghui.antelope.web.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.io.Serializable;

@Data
public class VehicleVO implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long id;
	private Long customerId;
	private String brand;
	private String carNumber;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date buyTime;
	private BigDecimal buyPrice;
	private String buyMothod;
	private String pledgeBank;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date pledgeTime;
	private BigDecimal monthlySupply;
	private String vehicleRegistration;
	private String remark;
}

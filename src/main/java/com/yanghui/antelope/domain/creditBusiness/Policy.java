package com.yanghui.antelope.domain.creditBusiness;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.yanghui.antelope.domain.common.BaseMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨辉
 * @since 2018-08-23
 */
@TableName("td_policy")
@Data
@EqualsAndHashCode(callSuper=false)
public class Policy extends BaseMode<Policy> {

    private static final long serialVersionUID = 1L;

	private Long id;
	@TableField("customer_id")
	private Long customerId;
    /**
     * 保险公司
     */
	@TableField("insurance_company")
	private String insuranceCompany;
    /**
     * 保险名称
     */
	@TableField("insurance_name")
	private String insuranceName;
    /**
     * 购买时间
     */
	@TableField("buy_time")
	private Date buyTime;
    /**
     * 购买价格
     */
	@TableField("buy_price")
	private BigDecimal buyPrice;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

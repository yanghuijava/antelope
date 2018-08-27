package com.yanghui.antelope.domain.creditBusiness;

import com.baomidou.mybatisplus.enums.IdType;
import com.yanghui.antelope.domain.common.BaseMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨辉
 * @since 2018-08-27
 */
@TableName("td_demand")
@Data
@EqualsAndHashCode(callSuper=false)
public class Demand extends BaseMode<Demand> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("customer_id")
	private Long customerId;
    /**
     * 实际额度
     */
	private BigDecimal amount;
    /**
     * 利息
     */
	private BigDecimal interest;
    /**
     * 贷款方式（1：信贷 2：抵押 3：转按）
     */
	@TableField("loan_method")
	private Integer loanMethod;
    /**
     * 其他需求
     */
	private String other;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

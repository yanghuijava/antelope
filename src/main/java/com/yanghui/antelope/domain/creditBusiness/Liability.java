package com.yanghui.antelope.domain.creditBusiness;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.yanghui.antelope.domain.common.BaseMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 负债
 * </p>
 *
 * @author 杨辉
 * @since 2018-08-27
 */
@TableName("td_liability")
@Data
@EqualsAndHashCode(callSuper=false)
public class Liability extends BaseMode<Liability> {

    private static final long serialVersionUID = 1L;

	private Long id;
	@TableField("customer_id")
	private Long customerId;
    /**
     * 银行或者金融公司信用贷款
     */
	@TableField("credit_loan")
	private String creditLoan;
    /**
     * 信用卡张数
     */
	@TableField("credit_card_number")
	private Integer creditCardNumber;
    /**
     * 信用卡总额度
     */
	@TableField("credit_card_amount")
	private BigDecimal creditCardAmount;
    /**
     * 信用卡近半年使用额度
     */
	@TableField("credit_card_half_use")
	private BigDecimal creditCardHalfUse;
    /**
     * 信用卡当前使用额度
     */
	@TableField("credit_card_current_use")
	private BigDecimal creditCardCurrentUse;
    /**
     * 未结清小额贷款
     */
	@TableField("not_small_loan")
	private BigDecimal notSmallLoan;
    /**
     * 近2个月查询次数简单说明（贷款，信用卡，个人查询）
     */
	@TableField("query_times_text")
	private String queryTimesText;
    /**
     * 征信
     */
	@TableField("credit_investigation")
	private String creditInvestigation;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

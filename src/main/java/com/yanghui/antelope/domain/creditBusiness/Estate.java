package com.yanghui.antelope.domain.creditBusiness;

import com.baomidou.mybatisplus.enums.IdType;
import com.yanghui.antelope.domain.common.BaseMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
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
 * @since 2018-08-20
 */
@TableName("td_estate")
@Data
@EqualsAndHashCode(callSuper=false)
public class Estate extends BaseMode<Estate> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	
	@TableField("customer_id")
	private Long customerId;
    /**
     * 地址
     */
	private String address;
    /**
     * 面积
     */
	private BigDecimal area;
    /**
     * 购买时间
     */
	@TableField("purchase_time")
	private Date purchaseTime;
    /**
     * 质押银行
     */
	@TableField("pledge_bank")
	private String pledgeBank;
    /**
     * 质押时间
     */
	@TableField("pledge_time")
	private Date pledgeTime;
    /**
     * 贷款年限
     */
	@TableField("loan_term")
	private Integer loanTerm;
    /**
     * 贷款额度
     */
	@TableField("loan_limit")
	private BigDecimal loanLimit;
    /**
     * 月供
     */
	@TableField("monthly_supply")
	private BigDecimal monthlySupply;
    /**
     * 证明资料原件
     */
	@TableField("proof_data_file")
	private String proofDataFile;
	private String remark;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

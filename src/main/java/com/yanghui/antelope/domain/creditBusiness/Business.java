package com.yanghui.antelope.domain.creditBusiness;

import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.yanghui.antelope.domain.common.BaseMode;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 生意资料
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-30
 */
@TableName("td_business")
@Data
@EqualsAndHashCode(callSuper=false)
public class Business extends BaseMode<Business> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 客户id
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 公司名称
     */
	@TableField("company_name")
	private String companyName;
    /**
     * 成立时间
     */
	@TableField("setup_date")
	private Date setupDate;
	/**
     * 是否公司法人 1：是 2：不是
     */
	private Integer corporation;
    /**
     * 占股
     */
	@TableField("share_stock")
	private BigDecimal shareStock;
    /**
     * 行业类别
     */
	@TableField("industry_type")
	private String industryType;
    /**
     * 近半年开票额
     */
	@TableField("half_year_ticket")
	private BigDecimal halfYearTicket;
    /**
     * 年纳税额
     */
	private BigDecimal taxes;
    /**
     * 个人流水
     */
	@TableField("personal_water")
	private String personalWater;
    /**
     * 员工人数
     */
	@TableField("employees_num")
	private Integer employeesNum;
    /**
     * 公司地址
     */
	@TableField("compa_address")
	private String compaAddress;
    /**
     * 公司面积
     */
	private String area;
    /**
     * 营业额
     */
	private BigDecimal turnover;
    /**
     * 固定设备
     */
	@TableField("fixed_equipment")
	private String fixedEquipment;
    /**
     * 租金
     */
	private BigDecimal rent;
    /**
     * 租赁合同
     */
	@TableField("lease_contract")
	private String leaseContract;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

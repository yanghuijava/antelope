package com.yanghui.antelope.domain.creditBusiness;

import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yanghui.antelope.domain.common.BaseMode;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 * 客户职业资料
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-26
 */
@TableName("td_profession")
@Data
public class Profession extends BaseMode<Profession> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 客户id
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 单位名称
     */
	@TableField("company_name")
	private String companyName;
    /**
     * 单位性质
     */
	@TableField("company_nature")
	private String companyNature;
    /**
     * 单位电话
     */
	private String telephone;
    /**
     * 单位地址
     */
	@TableField("company_address")
	private String companyAddress;
    /**
     * 部门
     */
	@TableField("dept_name")
	private String deptName;
    /**
     * 职位
     */
	private String position;
    /**
     * 工作年限
     */
	@TableField("working_life")
	private Integer workingLife;
    /**
     * 月收入
     */
	@TableField("month_income")
	private BigDecimal monthIncome;
    /**
     * 发薪日
     */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date payday;
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

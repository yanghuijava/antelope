package com.yanghui.antelope.domain.creditBusiness;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.yanghui.antelope.domain.common.BaseMode;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 * 客户资料表
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
@TableName("td_customer")
@Data
public class Customer extends BaseMode<Customer> {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 姓名
     */
	private String name;
    /**
     * 身份证号
     */
	@TableField("identity_card")
	private String identityCard;
    /**
     * 手机号码
     */
	@TableField("phone_number")
	private String phoneNumber;
    /**
     * 客户经理
     */
	@TableField("account_manager")
	private Long accountManager;
	@TableField(exist=false)
	private String accountManagerName;
    /**
     * 客户来源
     */
	private String source;
    /**
     * 家庭住址
     */
	@TableField("home_address")
	private String homeAddress;
    /**
     * 籍贯
     */
	@TableField("native_place")
	private String nativePlace;
    /**
     * 住址
     */
	private String address;
    /**
     * 婚姻状况(1:未婚,2:已婚,3:离异)
     */
	@TableField("marriage_status")
	private Integer marriageStatus;
    /**
     * 来深时间
     */
	@TableField("come_shenzhen_date")
	private Date comeShenzhenDate;
    /**
     * 客户类别
     */
	private Integer type;
    /**
     * 征信报告
     */
	@TableField("credit_report")
	private String creditReport;
    /**
     * 流水附件
     */
	@TableField("flow_file")
	private String flowFile;
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

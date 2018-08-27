package com.yanghui.antelope.domain.creditBusiness;

import com.baomidou.mybatisplus.enums.IdType;
import com.yanghui.antelope.domain.common.BaseMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 车辆
 * </p>
 *
 * @author 杨辉
 * @since 2018-08-27
 */
@TableName("td_vehicle")
@Data
@EqualsAndHashCode(callSuper=false)
public class Vehicle extends BaseMode<Vehicle> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 客户ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 品牌
     */
	private String brand;
    /**
     * 车牌号
     */
	@TableField("car_number")
	private String carNumber;
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
    /**
     * 购买方式
     */
	@TableField("buy_mothod")
	private String buyMothod;
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
     * 月供
     */
	@TableField("monthly_supply")
	private BigDecimal monthlySupply;
    /**
     * 车辆登记证
     */
	@TableField("vehicle_registration")
	private String vehicleRegistration;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

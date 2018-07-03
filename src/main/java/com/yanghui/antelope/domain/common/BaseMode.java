package com.yanghui.antelope.domain.common;

import java.util.Date;

import lombok.Data;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("rawtypes")
@Data
public abstract class BaseMode<T extends Model> extends Model<T>{
	
	private static final long serialVersionUID = -1339414159525706337L;
	private String remark;
    /**
     * 创建人
     */
	@TableField("create_by")
	private Long createBy;
	@TableField("create_time")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date createTime = new Date();
    /**
     * 更新人
     */
	@TableField("update_by")
	private Long updateBy;
	@TableField("update_time")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date updateTime = new Date();
	
	private Integer yn = 1;
	@TableField(exist=false)
	private String createByName;
	@TableField(exist=false)
	private String updateByName;
}

package com.yanghui.antelope.domain.system;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.yanghui.antelope.domain.common.BaseMode;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
@Data
public class Role extends BaseMode<Role> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private String code;
	private String name;
	private String description;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

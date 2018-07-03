package com.yanghui.antelope.domain.system;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
public class User extends BaseMode<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("dept_id")
	private Integer deptId;
	private String account;
	private String password;
	private String name;
	private String telephone;
	private String mobile;
	private String email;
	private Integer type;
	private Integer status = 1;
	
	@TableField(exist=false)
	private List<Resource> resourceList;
	
	@TableField(exist=false)
	private String roleIds;
	@TableField(exist=false)
	private String roleNames;
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

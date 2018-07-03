package com.yanghui.antelope.domain.system;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

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
@TableName("role_resource")
@Data
public class RoleResource extends Model<RoleResource> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("role_id")
	private Integer roleId;
	@TableField("res_id")
	private Integer resId;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

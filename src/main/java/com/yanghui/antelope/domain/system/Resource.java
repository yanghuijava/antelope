package com.yanghui.antelope.domain.system;


import com.baomidou.mybatisplus.enums.IdType;
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
public class Resource extends BaseMode<Resource> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private Integer pid;
	private Integer type;
	private String name;
	private String code;
	@TableField("index_")
	private Integer index;
	private String action;
	private String url;
	private String icon;
	

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

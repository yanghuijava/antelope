package com.yanghui.antelope.domain.system;

import com.baomidou.mybatisplus.enums.IdType;


import com.baomidou.mybatisplus.annotations.TableId;
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
public class Dept extends BaseMode<Dept> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private Integer num;
	private Integer pid;
	private String simplename;
	private String fullname;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

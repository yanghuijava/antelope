package com.yanghui.antelope.web.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

import com.yanghui.antelope.common.constant.Constant;

@Data
public class TreeDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer pid;
	private String text;
	private String value;
	private String iconCls;
	private String state = Constant.TREE_STATE_CLOSE;
	private Boolean checked = false;
	private Map<String, Object> attributes;
	private List<TreeDto> children;

}

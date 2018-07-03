package com.yanghui.antelope.web.vo;

import java.util.List;

import lombok.Data;

@Data
public class PageResult<T> {
	
	private List<T> rows;
	private Integer total;

}

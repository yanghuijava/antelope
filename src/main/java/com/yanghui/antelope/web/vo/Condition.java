package com.yanghui.antelope.web.vo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;

@Data
public class Condition {
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	private Pagination pagination;

}

package com.yanghui.antelope.web.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.common.constant.CustomerTypeEnum;
import com.yanghui.antelope.common.constant.MarriageStatusEnum;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.web.vo.CustomerVO;
import com.yanghui.antelope.web.vo.PageResult;

public class CustomerWrapper {
	
	public static PageResult<CustomerVO> createPage(Pagination pagination,List<Customer> data){
		PageResult<CustomerVO> page = new PageResult<CustomerVO>();
		List<CustomerVO> klist = new ArrayList<CustomerVO>();
		for(Customer c : data){
			CustomerVO cv = new CustomerVO();
			BeanUtils.copyProperties(c, cv);
			cv.setMarriageStatusName(MarriageStatusEnum.get(c.getMarriageStatus()).getName());
			cv.setTypeName(CustomerTypeEnum.get(c.getType()).getName());
			
			klist.add(cv);
		}
		page.setTotal(pagination.getTotal());
		page.setRows(klist);
		return page;
	}
}

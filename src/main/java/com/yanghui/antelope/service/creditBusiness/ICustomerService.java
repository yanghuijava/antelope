package com.yanghui.antelope.service.creditBusiness;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.system.User;

public interface ICustomerService {
	
	/**
	 * 删除客户信息连带其他信息一起删除
	 * @param id
	 */
	void deleteCustomer(Long id);
	
	List<Customer> getPage(Pagination pagination,Map<String, Object> params,User user);

	/**
	 * 提交客户
	 * @param id
	 */
	void submitCustomer(Long id);

}

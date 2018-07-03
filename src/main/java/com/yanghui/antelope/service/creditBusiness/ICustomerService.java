package com.yanghui.antelope.service.creditBusiness;

public interface ICustomerService {
	
	/**
	 * 删除客户信息连带其他信息一起删除
	 * @param id
	 */
	void deleteCustomer(Long id);

}

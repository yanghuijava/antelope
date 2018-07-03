package com.yanghui.antelope.service.creditBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanghui.antelope.dao.creditBusiness.BusinessMapper;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.ProfessionMapper;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private BusinessMapper businessMapper;
	@Autowired
	private ProfessionMapper professionMapper;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteCustomer(Long id) {
		this.customerMapper.deleteById(id);
		this.businessMapper.deleteByCustomerId(id);
		this.professionMapper.deleteByCustomerId(id);
	}
}

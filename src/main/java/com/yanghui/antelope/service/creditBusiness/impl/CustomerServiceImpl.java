package com.yanghui.antelope.service.creditBusiness.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.common.constant.CustomerStatusEnum;
import com.yanghui.antelope.common.constant.RoleEnum;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.creditBusiness.BusinessMapper;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.DemandMapper;
import com.yanghui.antelope.dao.creditBusiness.EstateMapper;
import com.yanghui.antelope.dao.creditBusiness.LiabilityMapper;
import com.yanghui.antelope.dao.creditBusiness.PolicyMapper;
import com.yanghui.antelope.dao.creditBusiness.ProfessionMapper;
import com.yanghui.antelope.dao.creditBusiness.ProgrammeMapper;
import com.yanghui.antelope.dao.creditBusiness.VehicleMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.creditBusiness.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private BusinessMapper businessMapper;
	@Autowired
	private ProfessionMapper professionMapper;
	@Autowired
	private DemandMapper demandMapper;
	@Autowired
	private EstateMapper estateMapper;
	@Autowired
	private LiabilityMapper liabilityMapper;
	@Autowired
	private PolicyMapper policyMapper;
	@Autowired
	private ProgrammeMapper programmeMapper;
	@Autowired
	private VehicleMapper vehicleMapper;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteCustomer(Long id) {
		Customer find = this.customerMapper.selectById(id);
		if(find == null) {
			throw new BusinessExcption("客户不存在！");
		}
		if(find.getStatus() != CustomerStatusEnum.UN_SUBMITTED.getStatus()) {
			throw new BusinessExcption("当前状态为：" + CustomerStatusEnum.getStatus(find.getStatus()).getName() + 
					",不能删除！");
		}
		this.customerMapper.deleteById(id);
		this.businessMapper.deleteByCustomerId(id);
		this.professionMapper.deleteByCustomerId(id);
		
		this.demandMapper.deleteByCustomerId(id);
		this.estateMapper.deleteByCustomerId(id);
		this.liabilityMapper.deleteByCustomerId(id);
		this.policyMapper.deleteByCustomerId(id);
		this.programmeMapper.deleteByCustomerId(id);
		this.vehicleMapper.deleteByCustomerId(id);
	}

	@Override
	public List<Customer> getPage(Pagination pagination, Map<String, Object> params, User user) {
		if(RoleEnum.isKehujingli(user.getRoleCodes())) {
			params.put("accountManager", user.getId());
		}else if(RoleEnum.isZhuguan(user.getRoleCodes())) {
			params.put("status", CustomerStatusEnum.UN_AUDITED.getStatus());
		}else if(RoleEnum.isZongjingli(user.getRoleCodes())) {
			params.put("status", CustomerStatusEnum.UN_APPROPRIATION.getStatus());
		}else {
			if(!RoleEnum.isAdministrator(user.getRoleCodes())) {
				return new ArrayList<>();
			}
		}
		List<Customer> data = this.customerMapper.getPage(pagination,params);
		return data;
	}

	@Override
	public void submitCustomer(Long id) {
		Customer find = this.customerMapper.selectById(id);
		if(find == null) {
			throw new BusinessExcption("客户不存在！");
		}
		if(find.getStatus() != CustomerStatusEnum.UN_SUBMITTED.getStatus()) {
			throw new BusinessExcption("已经提交过了！");
		}
		find.setStatus(CustomerStatusEnum.UN_AUDITED.getStatus());
		this.customerMapper.updateById(find);
	}
}

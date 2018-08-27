package com.yanghui.antelope.web.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.common.constant.CustomerStatusEnum;
import com.yanghui.antelope.common.constant.CustomerTypeEnum;
import com.yanghui.antelope.common.constant.MarriageStatusEnum;
import com.yanghui.antelope.common.constant.SexEnum;
import com.yanghui.antelope.domain.creditBusiness.Business;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Estate;
import com.yanghui.antelope.domain.creditBusiness.Policy;
import com.yanghui.antelope.domain.creditBusiness.Vehicle;
import com.yanghui.antelope.web.vo.BusinessVO;
import com.yanghui.antelope.web.vo.CustomerVO;
import com.yanghui.antelope.web.vo.EstateVO;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.PolicyVO;
import com.yanghui.antelope.web.vo.VehicleVO;

public class CommonWrapper {
	
	public static PageResult<CustomerVO> createCustomerPage(Pagination pagination,List<Customer> data){
		PageResult<CustomerVO> page = new PageResult<CustomerVO>();
		List<CustomerVO> klist = new ArrayList<CustomerVO>();
		for(Customer c : data){
			CustomerVO cv = new CustomerVO();
			BeanUtils.copyProperties(c, cv);
			cv.setMarriageStatusName(MarriageStatusEnum.get(c.getMarriageStatus()).getName());
			cv.setTypeName(CustomerTypeEnum.get(c.getType()).getName());
			cv.setSexName(SexEnum.getSex(cv.getSex()).getName());
			cv.setStatusName(CustomerStatusEnum.getStatus(cv.getStatus()).getName());
			klist.add(cv);
		}
		page.setTotal(pagination.getTotal());
		page.setRows(klist);
		return page;
	}

	public static PageResult<BusinessVO> createBusinessPage(Pagination pagination, List<Business> data) {
		PageResult<BusinessVO> page = new PageResult<>();
		List<BusinessVO> list = new ArrayList<>();
		for(Business b : data) {
			BusinessVO bv = new BusinessVO();
			BeanUtils.copyProperties(b, bv);
			bv.setCorporationName(b.getCorporation() == 1 ? "是" : "否");
			list.add(bv);
		}
		page.setTotal(pagination.getTotal());
		page.setRows(list);
		return page;
	}

	public static PageResult<EstateVO> createEstatePage(Pagination pagination, List<Estate> data) {
		PageResult<EstateVO> page = new PageResult<>();
		List<EstateVO> list = new ArrayList<>();
		for(Estate e : data) {
			EstateVO ev = new EstateVO();
			BeanUtils.copyProperties(e, ev);
			list.add(ev);
		}
		page.setTotal(pagination.getTotal());
		page.setRows(list);
		return page;
	}

	public static PageResult<PolicyVO> createPolicyPage(Pagination pagination, List<Policy> data) {
		PageResult<PolicyVO> page = new PageResult<>();
		List<PolicyVO> list = new ArrayList<>();
		for(Policy p : data) {
			PolicyVO pv = new PolicyVO();
			BeanUtils.copyProperties(p, pv);
			list.add(pv);
		}
		page.setTotal(pagination.getTotal());
		page.setRows(list);
		return page;
	}

	public static PageResult<VehicleVO> createVehiclePage(Pagination pagination, List<Vehicle> data) {
		PageResult<VehicleVO> page = new PageResult<>();
		List<VehicleVO> list = new ArrayList<>();
		for(Vehicle v : data) {
			VehicleVO vv = new VehicleVO();
			BeanUtils.copyProperties(v, vv);
			list.add(vv);
		}
		page.setTotal(pagination.getTotal());
		page.setRows(list);
		return page;
	}
}

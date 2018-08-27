package com.yanghui.antelope.web.controller.creditBusiness;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.VehicleMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Vehicle;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.VehicleVO;
import com.yanghui.antelope.web.vo.Wrapper;
import com.yanghui.antelope.web.wrapper.CommonWrapper;
/**
 * 车辆
 * @author think
 *
 */
@Controller
@RequestMapping("/vehicle")
public class VehicleController extends BaseComtroller{
	
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private VehicleMapper vehicleMapper;
	
	@RequestMapping("/vehicleUI.html")
	public String vehicleUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
		}
		return PRIX + "vehicleUI";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResult<VehicleVO> list(Condition condition) throws Exception{
		List<Vehicle> data = this.vehicleMapper.getPage(condition.getPagination(),condition.getMap());
		return CommonWrapper.createVehiclePage(condition.getPagination(), data);
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public VehicleVO load(Condition condition){
		Vehicle v = this.vehicleMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		VehicleVO vv = new VehicleVO();
		BeanUtils.copyProperties(v, vv);
		return vv;
	}
	
	@RequestMapping("/save.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition) throws Exception{
		Vehicle vehicle = super.saveGet(condition.getMap(), Vehicle.class);
		if(vehicle.getCustomerId() == null) {
			throw new BusinessExcption("没有客户信息，无法保存企业信息！");
		}
		this.vehicleMapper.insert(vehicle);
		return successWrapper().setData(vehicle.getCustomerId().toString());
	}
	
	@RequestMapping("/update.json")
	@ResponseBody
	public Wrapper<String> update(Condition condition) throws Exception{
		Vehicle vehicle = super.updateGet(condition.getMap(), Vehicle.class);
		this.vehicleMapper.updateById(vehicle);
		return successWrapper().setData(vehicle.getCustomerId().toString());
	}
	
	@RequestMapping("/delete.json")
	@ResponseBody
	public Wrapper<?> delete(@RequestParam("id") Long id){
		this.vehicleMapper.deleteById(id);
		return successWrapper();
	}
	
	/**
	 * 上一个页面：保单资料（车辆资料------>保单资料）
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		return "redirect:/policy/policyUI.html?customerId=" + customerId;
	}
	
	/**
	 * 下一个页面：负债情况（车辆资料------>负债情况）
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/nextUI.html")
	public String nextUI(Model model,@RequestParam(value="customerId")Long customerId) {
		return "redirect:/liability/liabilityUI.html?customerId=" + customerId;
	}
}

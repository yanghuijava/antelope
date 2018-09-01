package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.common.utils.HttpKit;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.ProgrammeMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Programme;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.creditBusiness.IProgrammeService;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.ProgrammeVO;
import com.yanghui.antelope.web.vo.Wrapper;

/**
 * <p>
 * 客户方案资料 前端控制器
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-26
 */
@Controller
@RequestMapping("/programme")
public class ProgrammeController extends BaseComtroller{
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private ProgrammeMapper programmeMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private IProgrammeService programmeService;
	
	@RequestMapping("/programmeUI.html")
	public String programmeUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId,
			@RequestParam(value="programmeId",required=false)Long programmeId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
			if(programmeId != null) {
				Programme findP = this.programmeMapper.selectById(programmeId);
				model.addAttribute("programme", findP);
			}else {
				Programme findP = this.programmeMapper.getByCustomerId(findC.getId());
				model.addAttribute("programme", findP);
			}
		}
		return PRIX + "programmeUI";
	}
	
	@RequestMapping("/plan.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition) throws Exception{
		Programme programme = super.saveGet(condition.getMap(), Programme.class);
		if(programme.getCustomerId() == null) {
			throw new BusinessExcption("没有客户信息，无法保存客户方案信息！");
		}
		User user = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		this.programmeService.save(programme, user);
		return successWrapper().setData(programme.getCustomerId().toString());
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public ProgrammeVO load(Condition condition){
		Programme p = this.programmeMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		ProgrammeVO pv = new ProgrammeVO();
		BeanUtils.copyProperties(p, pv);
		return pv;
	}
	
	/**
	 * 上一页面：跳转到客户资料页面
	 * @param customerId
	 * @param request
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		return "redirect:/demand/demandUI.html?customerId=" + customerId;
	}
}

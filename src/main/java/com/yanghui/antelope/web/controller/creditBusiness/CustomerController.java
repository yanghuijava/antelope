package com.yanghui.antelope.web.controller.creditBusiness;
import java.io.File;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.common.utils.HttpKit;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.creditBusiness.ICustomerService;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.CustomerVO;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.Wrapper;
import com.yanghui.antelope.web.wrapper.CustomerWrapper;

/**
 * <p>
 * 客户资料表 前端控制器
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseComtroller{
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping("/listUI.html")
	public String listUI(){
		return "creditBusiness/customer/customer_listUI";
	}
	
	@RequestMapping("/fileUI.html")
	public String fileUI(Model mode,Condition condition){
		Customer find = this.customerMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		if(!StringUtils.isEmpty(find.getCreditReport())){
			String fileName = super.getFileNameFromPath(find.getCreditReport());
			mode.addAttribute("creditReportPath", "customer/download.html?fileName=" + fileName + "&id=" + find.getId());
			mode.addAttribute("creditReportName","点击下载征信报告：" + fileName);
		}
		if(!StringUtils.isEmpty(find.getFlowFile())){
			String fileName = super.getFileNameFromPath(find.getFlowFile());
			mode.addAttribute("flowFilePath", "customer/download.html?fileName=" + fileName + "&id=" + find.getId());
			mode.addAttribute("flowFileName","点击下载流水附件：" + fileName);
		}
		return "creditBusiness/customer/customer_fileUI";
	}
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResult<CustomerVO> list(Condition condition) throws Exception{
		List<Customer> data = this.customerMapper.getPage(condition.getPagination(),condition.getMap());
		return CustomerWrapper.createPage(condition.getPagination(), data);
	}
	/**
	 * 客户资料保存
	 * @param condition
	 * @param creditReport
	 * @param flowFile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition,
			@RequestParam(value="creditReport")MultipartFile creditReport,
			@RequestParam(value="flowFile")MultipartFile flowFile) throws Exception{
		User user = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		Customer customer = super.saveGet(condition.getMap(), Customer.class);
		Customer find  = this.customerMapper.queryByIdentityCard(customer.getIdentityCard());
		if(find != null){
			throw new BusinessExcption("身份证号重复！");
		}
		find = this.customerMapper.queryByPhone(customer.getPhoneNumber());
		if(find != null){
			throw new BusinessExcption("手机号重复！");
		}
		if(customer.getAccountManager() == null){
			customer.setAccountManager(user.getId());
		}
		if(creditReport != null && !creditReport.isEmpty()){
			String creditReportPath= super.upload(creditReport);
			customer.setCreditReport(creditReportPath);
		}
		if(flowFile != null && !flowFile.isEmpty()){
			String flowFilePath= super.upload(flowFile);
			customer.setFlowFile(flowFilePath);
		}
		this.customerMapper.insert(customer);
		return successWrapper().setData(customer.getId().toString());
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public CustomerVO load(Condition condition){
		Customer c = this.customerMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		CustomerVO cv = new CustomerVO();
		BeanUtils.copyProperties(c, cv);
		return cv;
	}
	
	@RequestMapping("/update.json")
	@ResponseBody
	public Wrapper<String> update(Condition condition,
			@RequestParam(value="creditReport")MultipartFile creditReport,
			@RequestParam(value="flowFile")MultipartFile flowFile) throws Exception{
		Customer customer = super.updateGet(condition.getMap(), Customer.class);
		Customer find  = this.customerMapper.queryByIdentityCard(customer.getIdentityCard());
		if(find != null && find.getId().intValue() != customer.getId().intValue()){
			throw new BusinessExcption("身份证号重复！");
		}
		find  = this.customerMapper.queryByPhone(customer.getPhoneNumber());
		if(find != null && find.getId().intValue() != customer.getId().intValue()){
			throw new BusinessExcption("手机号重复！");
		}
		if(creditReport != null && !creditReport.isEmpty()){
			String creditReportPath= super.upload(creditReport);
			customer.setCreditReport(creditReportPath);
		}
		if(flowFile != null && !flowFile.isEmpty()){
			String flowFilePath= super.upload(flowFile);
			customer.setFlowFile(flowFilePath);
		}
		this.customerMapper.updateById(customer);
		return successWrapper().setData(customer.getId().toString());
	}
	
	@RequestMapping("/download.html")
	public void download(Condition condition){
		Customer find = this.customerMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		String filePath = super.antelopeConfigProperties.getFileuploadPath();
		if(find.getCreditReport().contains(condition.getMap().get("fileName").toString())){
			filePath = filePath + File.separator + find.getCreditReport();
		}else if(find.getFlowFile().contains(condition.getMap().get("fileName").toString())){
			filePath = filePath + File.separator + find.getFlowFile();
		}
		super.download(filePath);
	}
	
	@RequestMapping("/delete.json")
	@ResponseBody
	public Wrapper<?> delete(@RequestParam("id") Long id){
		this.customerService.deleteCustomer(id);
		return successWrapper();
	}
}

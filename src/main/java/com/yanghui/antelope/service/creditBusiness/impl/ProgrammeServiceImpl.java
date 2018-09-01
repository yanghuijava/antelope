package com.yanghui.antelope.service.creditBusiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanghui.antelope.common.constant.CustomerStatusEnum;
import com.yanghui.antelope.common.constant.RoleEnum;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.ProgrammeMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Programme;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.creditBusiness.IProgrammeService;

@Service
public class ProgrammeServiceImpl implements IProgrammeService {
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ProgrammeMapper programmeMapper;

	@Override
	public void save(Programme programme, User user) {
		Programme findPro = this.programmeMapper.getByCustomerId(programme.getCustomerId());
		if(findPro == null) {
			this.programmeMapper.insert(programme);
			return;
		}
		
		Programme p = new Programme();
		p.setId(findPro.getId());
		Customer find = this.customerMapper.selectById(programme.getCustomerId());
		if(RoleEnum.isKehujingli(user.getRoleCodes())) {
			p.setCustomerManagerProposal(programme.getCustomerManagerProposal());
			p.setFollowUpProposal(programme.getFollowUpProposal());
			this.programmeMapper.updateById(programme);
			return;
		}else if(RoleEnum.isZhuguan(user.getRoleCodes())) {
			if(find.getStatus() != CustomerStatusEnum.UN_AUDITED.getStatus()) {
				throw new BusinessExcption("状态为：" + CustomerStatusEnum.getStatus(find.getStatus()).getName() + 
						"，没法提交主管审核！");
			}
			if(programme.getMark() == 1) {
				find.setStatus(CustomerStatusEnum.UN_APPROPRIATION.getStatus());
			}else {
				find.setStatus(CustomerStatusEnum.AUDITED_FAIL.getStatus());
			}
			p.setDirectorProgramme(programme.getDirectorProgramme());
		}else if(RoleEnum.isZongjingli(user.getRoleCodes())) {
			if(find.getStatus() != CustomerStatusEnum.UN_APPROPRIATION.getStatus()) {
				throw new BusinessExcption("状态为：" + CustomerStatusEnum.getStatus(find.getStatus()).getName() + 
						"，没法提交批款审核！");
			}
			if(programme.getMark() == 1) {
				find.setStatus(CustomerStatusEnum.LOAN.getStatus());
			}else {
				find.setStatus(CustomerStatusEnum.REJECT_LOAN.getStatus());
			}
			p.setAppropriationResult(programme.getAppropriationResult());
		}
		this.programmeMapper.updateById(p);
		this.customerMapper.updateById(find);
	}
}

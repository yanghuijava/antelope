package com.yanghui.antelope.web.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProgrammeVO implements Serializable{

	private static final long serialVersionUID = 4563701440443146542L;
	
	private Long id;
	private Long customerId;
	private String customerManagerProposal;
	private String directorProgramme;
	private String appropriationResult;
	private String followUpProposal;

}

package com.yanghui.antelope.common.constant;

public enum CustomerStatusEnum {
	
	UN_SUBMITTED(100,"待提交"),
	UN_AUDITED(101,"待审核"),
	AUDITED_FAIL(102,"审核不通过"),
	UN_APPROPRIATION(103,"待批款"), 
	LOAN(104,"已放款")
	;
	
	private int status;
	private String name;
	private CustomerStatusEnum(int status, String name) {
		this.status = status;
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static CustomerStatusEnum getStatus(int status) {
		for(CustomerStatusEnum cs : CustomerStatusEnum.values()) {
			if(cs.getStatus() == status) {
				return cs;
			}
		}
		return null;
	}
}

package com.yanghui.antelope.common.constant;

public enum CustomerTypeEnum {
	
	WORK(1,"上班"),
	BOSS(2,"自雇"),
	WORKANDBOSS(3,"既上班又自雇"),
	
	NONE(4,"未知");
	
	private int type;
	private String name;
	
	private CustomerTypeEnum(int type, String name){
		this.type = type;
        this.name = name;
	}

	
	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public static CustomerTypeEnum get(int type){
		for(CustomerTypeEnum c : CustomerTypeEnum.values()){
			if(c.getType() == type){
				return c;
			}
		}
		return NONE;
	}
}

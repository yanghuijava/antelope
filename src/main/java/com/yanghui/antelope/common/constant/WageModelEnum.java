package com.yanghui.antelope.common.constant;

public enum WageModelEnum {
	
	DAIFA(1,"代发"),
	ZHUANZHANG(2,"转账"),
	XIANJIN(3,"现金"),
	;
	
	private int model;
	private String name;
	private WageModelEnum(int model, String name) {
		this.model = model;
		this.name = name;
	}
	
	public int getType() {
		return model;
	}

	public void setType(int type) {
		this.model = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public static WageModelEnum getModel(int model) {
		for(WageModelEnum we : WageModelEnum.values()) {
			if(we.getType() == model) {
				return we;
			}
		}
		return null;
	}
}

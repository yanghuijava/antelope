package com.yanghui.antelope.common.constant;

public enum SexEnum {
	
	MAN(1,"男"),
	WOMAN(2,"女");
	
	private int sex;
	private String name;
	
	private SexEnum(int sex, String name) {
		this.sex = sex;
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static SexEnum getSex(int sex) {
		for(SexEnum se : SexEnum.values()) {
			if(se.getSex() == sex) {
				return se;
			}
		}
		return null;
	}
}

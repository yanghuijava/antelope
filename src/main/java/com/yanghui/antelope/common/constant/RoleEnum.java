package com.yanghui.antelope.common.constant;

import org.springframework.util.StringUtils;

public enum RoleEnum {
	
	KEHUJINGLI("kehujingli"),
	ZHUGUAN("zhuguan"),
	ZONGJINGLI("zongjingli"),
	ADMINISTRATOR("administrator"),
	;
	
	private String name;

	private RoleEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 判断是否是客户经理角色
	 * @param roleCodes
	 * @return
	 */
	public static boolean isKehujingli(String roleCodes) {
		if(StringUtils.isEmpty(roleCodes)) {
			return false;
		}
		if(roleCodes.contains(RoleEnum.KEHUJINGLI.getName())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否是主管角色
	 * @param roleCodes
	 * @return
	 */
	public static boolean isZhuguan(String roleCodes) {
		if(StringUtils.isEmpty(roleCodes)) {
			return false;
		}
		if(roleCodes.contains(RoleEnum.ZHUGUAN.getName())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否是总经理角色
	 * @param roleCodes
	 * @return
	 */
	public static boolean isZongjingli(String roleCodes) {
		if(StringUtils.isEmpty(roleCodes)) {
			return false;
		}
		if(roleCodes.contains(RoleEnum.ZONGJINGLI.getName())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否是超级管理员
	 * @param roleCodes
	 * @return
	 */
	public static boolean isAdministrator(String roleCodes) {
		if(StringUtils.isEmpty(roleCodes)) {
			return false;
		}
		if(roleCodes.contains(RoleEnum.ADMINISTRATOR.getName())) {
			return true;
		}
		return false;
	}
}

package com.yanghui.antelope.common.utils;

import com.yanghui.antelope.common.constant.SexEnum;

public class StringUtil {
	
	public static Integer getSexFromIdentityCard(String identityCard) {
		char c = identityCard.charAt(identityCard.length() - 2);
		int sex =  Integer.valueOf(String.valueOf(c));
		if(sex % 2 == 0) {
			SexEnum.WOMAN.getSex();
		}
		return SexEnum.MAN.getSex();
	}
}

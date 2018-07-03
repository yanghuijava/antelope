package com.yanghui.antelope.common.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="antelope.config")
@Data
public class AntelopeConfigProperties {
	
	private Integer sessionTimeout;
	private String fileuploadPath;

}

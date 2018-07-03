package com.yanghui.antelope.web.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yanghui.antelope.common.config.AntelopeConfigProperties;
import com.yanghui.antelope.web.filter.CommonInterceptor;
import com.yanghui.antelope.web.filter.LoginInterceptor;

@Configuration
public class CommonInterceptorConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private AntelopeConfigProperties antelopeConfigProperties;
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
       return new EmbeddedServletContainerCustomizer() {
           @Override
           public void customize(ConfigurableEmbeddedServletContainer container) {
        	   container.setSessionTimeout(antelopeConfigProperties.getSessionTimeout());//单位为S
          }
	    };
	}
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor());
        InterceptorRegistration addInterceptor = registry.addInterceptor(this.loginInterceptor);
        addInterceptor.addPathPatterns("/**");
        addInterceptor.excludePathPatterns("/login**");
        addInterceptor.excludePathPatterns("/logout**");
        addInterceptor.excludePathPatterns("/common/404.html");
    }
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(new QueryConditionArgumentResolver());
	}
}

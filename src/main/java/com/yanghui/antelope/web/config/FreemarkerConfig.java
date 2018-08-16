package com.yanghui.antelope.web.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.yanghui.antelope.web.tags.LinkbuttonDirective;
import com.yanghui.antelope.web.tags.ToolbarDirective;
import com.yanghui.antelope.web.tags.TreeViewDirective;

import freemarker.template.TemplateModelException;

@Configuration
public class FreemarkerConfig {

	@Autowired
	private freemarker.template.Configuration configuration;
	@Autowired
	private TreeViewDirective treeViewDirective;
	@Autowired
	private ToolbarDirective toolbarDirective;
	@Autowired
	private LinkbuttonDirective linkbuttonDirective;

	@PostConstruct
	public void setSharedVariable() throws TemplateModelException {
		configuration.setSharedVariable("tree", this.treeViewDirective);
		configuration.setSharedVariable("toolbar", this.toolbarDirective);
		configuration.setSharedVariable("linkbutton", this.linkbuttonDirective);
	}
}

package com.yanghui.antelope.dao.system;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yanghui.antelope.AntelopeApplication;
import com.yanghui.antelope.domain.system.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AntelopeApplication.class)
public class ResourceMapperTest {

	@Autowired
	private ResourceMapper resourceMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Resource r = new Resource();
		r.setName("fffffff");
		int i = this.resourceMapper.insert(r);
		System.out.println("结果：" + i);
		System.out.println("------------r---------" + r);
	}
}

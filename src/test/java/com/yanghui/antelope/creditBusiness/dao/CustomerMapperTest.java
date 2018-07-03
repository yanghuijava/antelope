package com.yanghui.antelope.creditBusiness.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.AntelopeApplication;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AntelopeApplication.class)
public class CustomerMapperTest {
	
	@Autowired
	private CustomerMapper customerMapper;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Customer find = this.customerMapper.selectById(1);
		System.out.println(find);
		Pagination page = new Pagination(1, 10);
		List<Customer> list = this.customerMapper.getPage(page,null);
		System.out.println("总共记录数：" + page.getTotal());
		System.out.println("当前记录数：" + list.size());
		System.out.println("当前页数：" + page.getCurrent());
		System.out.println("总共多少页：" + page.getPages());
		System.out.println(list);
	}
}

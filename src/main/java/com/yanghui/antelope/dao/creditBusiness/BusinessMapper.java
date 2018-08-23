package com.yanghui.antelope.dao.creditBusiness;

import com.yanghui.antelope.domain.creditBusiness.Business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
  * 生意资料 Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-30
 */
public interface BusinessMapper extends BaseMapper<Business> {

	@Select("delete from td_business where customer_id = #{customerId}")
	@ResultType(Integer.class)
	Integer deleteByCustomerId(Long customerId);

	List<Business> getPage(Pagination pagination, Map<String, Object> params);

}
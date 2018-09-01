package com.yanghui.antelope.dao.creditBusiness;

import com.yanghui.antelope.domain.creditBusiness.Policy;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2018-08-23
 */
public interface PolicyMapper extends BaseMapper<Policy> {

	List<Policy> getPage(Pagination pagination, Map<String, Object> params);

	@Select("delete from td_policy where customer_id = #{customerId}")
	@ResultType(Integer.class)
	Integer deleteByCustomerId(Long id);

}
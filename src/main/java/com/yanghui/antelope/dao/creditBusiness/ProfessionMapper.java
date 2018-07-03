package com.yanghui.antelope.dao.creditBusiness;

import com.yanghui.antelope.domain.creditBusiness.Profession;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 客户职业资料 Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-26
 */
public interface ProfessionMapper extends BaseMapper<Profession> {

	@Select("select * from td_profession where customer_id = #{customerId} and yn = 1")
	@ResultMap("BaseResultMap")
	Profession getByCustomerId(Long customerId);
	
	@Select("delete from td_profession where customer_id = #{customerId}")
	@ResultType(Integer.class)
	Integer deleteByCustomerId(Long customerId);

}
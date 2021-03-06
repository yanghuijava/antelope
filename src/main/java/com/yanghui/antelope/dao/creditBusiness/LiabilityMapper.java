package com.yanghui.antelope.dao.creditBusiness;

import com.yanghui.antelope.domain.creditBusiness.Liability;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2018-08-27
 */
public interface LiabilityMapper extends BaseMapper<Liability> {

	@Select("select * from td_liability where customer_id = #{customerId} and yn = 1")
	@ResultMap("BaseResultMap")
	Liability getByCustomerId(Long customerId);
	@Select("delete from td_liability where customer_id = #{customerId}")
	@ResultType(Integer.class)
	Integer deleteByCustomerId(Long id);

}
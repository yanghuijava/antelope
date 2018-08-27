package com.yanghui.antelope.dao.creditBusiness;

import com.yanghui.antelope.domain.creditBusiness.Demand;

import org.apache.ibatis.annotations.ResultMap;
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
public interface DemandMapper extends BaseMapper<Demand> {
	@Select("select * from td_demand where customer_id = #{customerId} and yn = 1")
	@ResultMap("BaseResultMap")
	Demand getByCustomerId(Long id);

}
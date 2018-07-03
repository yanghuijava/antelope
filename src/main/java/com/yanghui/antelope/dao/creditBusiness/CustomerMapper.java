package com.yanghui.antelope.dao.creditBusiness;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.domain.creditBusiness.Customer;

/**
 * <p>
  * 客户资料表 Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
public interface CustomerMapper extends BaseMapper<Customer> {
	
	public List<Customer> getPage(Pagination page,Map<String,Object> params);

	@Select("select * from td_customer where (identity_card = #{identityCard} or phone_number = #{phoneNumber}) and yn = 1")
	@ResultMap("BaseResultMap")
	public List<Customer> queryByIdentityCardOrPhone(@Param("identityCard")String identityCard,@Param("phoneNumber")String phoneNumber);

	@Select("select * from td_customer where identity_card = #{identityCard} and yn = 1")
	@ResultMap("BaseResultMap")
	public Customer queryByIdentityCard(@Param("identityCard")String identityCard);
	
	@Select("select * from td_customer where phone_number = #{phoneNumber} and yn = 1")
	@ResultMap("BaseResultMap")
	public Customer queryByPhone(@Param("phoneNumber")String phoneNumber);
}
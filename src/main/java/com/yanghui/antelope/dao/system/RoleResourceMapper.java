package com.yanghui.antelope.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yanghui.antelope.domain.system.RoleResource;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
public interface RoleResourceMapper extends BaseMapper<RoleResource> {

	@Select("delete from role_resource where role_id = #{roleId}")
	@ResultType(Integer.class)
	public Integer deleteByRoleId(Long roleId);
	
	@Select("select * from role_resource where res_id = #{resId}")
	@ResultMap("BaseResultMap")
	public List<RoleResource> queryByResId(Long resId);

}
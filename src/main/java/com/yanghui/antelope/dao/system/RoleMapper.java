package com.yanghui.antelope.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yanghui.antelope.domain.system.Role;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
public interface RoleMapper extends BaseMapper<Role> {

	@Select("delete from role_resource where role_id = #{roleId}")
	@ResultType(Integer.class)
	public Integer deleteRoleResource(Long roleId);

	@Select("select r.* from role r join user_role ur on r.id = ur.role_id where ur.user_id = #{userId}")
	@ResultMap("BaseResultMap")
	public List<Role> queryByUserId(Long userId);

	@Select("select * from role where code = #{code}")
	@ResultMap("BaseResultMap")
	public Role queryByCode(String code);

}
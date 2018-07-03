package com.yanghui.antelope.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yanghui.antelope.domain.system.Role;
import com.yanghui.antelope.domain.system.UserRole;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

	@Select("delete from user_role where user_id = #{userId}")
	@ResultType(Integer.class)
	public Integer deleteUserRole(Long userId);
	
	
	@Select("select * from user_role where user_id = #{userId}")
	@ResultMap("BaseResultMap")
	public List<UserRole> selectRoleByUserId(Long userId);
	
//	@Select("select * from user_role where user_id = #{userId}")
//	@ResultMap("BaseResultMap")
//	public UserRole queryByUserId(Long userId);

	@Select("select * from user_role where role_id = #{roleId}")
	@ResultMap("BaseResultMap")
	public List<Role> queryByRoleId(Long roleId);

}
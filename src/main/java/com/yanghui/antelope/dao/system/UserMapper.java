package com.yanghui.antelope.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.domain.system.User;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
public interface UserMapper extends BaseMapper<User> {

	@Select("select * from user where account = #{account}")
	@ResultMap("BaseResultMap")
	public User selectByAccount(String account);

	public List<User> queryPage(Pagination pagination, Map<String, Object> map);

	@Select("select u.* from user u join user_role ur on u.id = ur.user_id join role r on ur.role_id = r.id where r.code = #{roleCode} or code = 'administrator'")
	public List<User> getUserByRoleCode(String roleCode);

}
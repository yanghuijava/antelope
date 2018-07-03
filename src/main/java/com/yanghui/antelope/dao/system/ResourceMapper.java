package com.yanghui.antelope.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yanghui.antelope.domain.system.Resource;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-17
 */
public interface ResourceMapper extends BaseMapper<Resource> {

	@Select("select * from resource where pid = #{pid} order by index_ asc")
	@ResultMap("BaseResultMap")
	public List<Resource> queryByPid(Integer pid);
	
	@Select("select distinct res.* from resource res join role_resource rr on res.id = rr.res_id where rr.role_id = #{roleId}")
	@ResultMap("BaseResultMap")
	public List<Resource> getResourceByRoleId(long roleId);

	public List<Resource> selectUserSubs(Map<String, Object> param);

	@Select("select res.* from resource res join role_resource rr on res.id = rr.res_id where rr.role_id in" +
    " (select r.id from role r join user_role ur on r.id = ur.role_id where ur.user_id = #{userId})")
	@ResultMap("BaseResultMap")
	public List<Resource> getUserAllResource(Long userId);

}
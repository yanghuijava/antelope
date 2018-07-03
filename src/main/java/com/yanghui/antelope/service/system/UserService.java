package com.yanghui.antelope.service.system;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.domain.system.Role;
import com.yanghui.antelope.domain.system.User;

public interface UserService {

	public User checkUser(String account, String password);

	public void save(User user, List<Role> roleList);

	public void update(User user, List<Role> roleList);

	public void delete(Long userId);

	public List<User> queryPage(Pagination pagination, Map<String, Object> params);

	public User queryUserAllMsg(Long id);

}

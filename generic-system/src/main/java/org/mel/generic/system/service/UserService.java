package org.mel.generic.system.service;

import java.util.Date;

import javax.annotation.Resource;

import org.mel.framework.util.BeanMapper;
import org.mel.generic.system.dto.UserCreateRequest;
import org.mel.generic.system.entity.User;
import org.mel.generic.system.repository.UserDao;
import org.mel.security.entity.SecurityUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Resource
	private UserDao userDao;

	public void saveUser(UserCreateRequest request) {
		SecurityUser securityUser = BeanMapper.map(request.getSecurityUser(), SecurityUser.class);
		User user = BeanMapper.map(request.getUser(), User.class);

		user.setSecurityUser(securityUser);

		if (user.getId() == null) {
			// new
			user.setCreateTime(new Date());
			user.setUpdateTime(user.getCreateTime());
		} else {
			// update
			user.setUpdateTime(new Date());
		}
		userDao.save(user);
	}
	

}

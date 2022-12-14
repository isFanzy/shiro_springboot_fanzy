/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 11:23
 **/
package fanzy.top.shiro_springboot_fanzy.service;

import fanzy.top.shiro_springboot_fanzy.dao.Impl.PermissionDaoImpl;
import fanzy.top.shiro_springboot_fanzy.dao.Impl.UserDaoImpl;
import fanzy.top.shiro_springboot_fanzy.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
	@Resource
	private UserDaoImpl userDao;
	@Resource
	private PermissionDaoImpl permissionDao;

	/**
	 * 通过用户名查询用户
	 *
	 * @param name
	 * @return fanzy.top.shiro_springboot_fanzy.entity.User
	 * @author fanzy
	 * @date 2022-10-08 11:54
	 */

	public User queryUserByName(String name) {
		return userDao.queryUserByName(name);
	}

	/**
	 * 增加一个用户
	 *
	 * @param user
	 * @return
	 */
	public User addUser(User user) {
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setUpdateTime(new Date());

		switch (user.getRoleId()) {
			case 1:
				//	超级管理员
				return null;
			case 2:
				//	经理
				user.setRoleName("经理");
				if (userDao.addUser(user) == 1) {
					permissionDao.initManagerPerm(user);
					return queryUserByName(user.getUsername());
				} else {
					return null;
				}
			case 3:
				//	普通用户
				user.setRoleName("普通用户");
				if (userDao.addUser(user) == 1) {
					permissionDao.initUserPerm(user);
					return queryUserByName(user.getUsername());
				} else {
					return null;
				}
			default:
				return null;
		}
	}

	/**
	 * 查询所有的用户
	 *
	 * @return java.util.List<fanzy.top.shiro_springboot_fanzy.entity.User>
	 * @author fanzy
	 * @date 2022-10-08 11:54
	 */
	public List<User> queyruAllUsers() {
		return userDao.queryAllUsers();
	}

}

package fanzy.top.shiro_springboot_fanzy.Dao;

import fanzy.top.shiro_springboot_fanzy.Entity.Permission;
import fanzy.top.shiro_springboot_fanzy.Entity.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface permissionDao {
	// 查询个人权限
	List<Permission> allPermissions(String name);

	// 添加一个权限
	Integer addPerm(Permission permission);

	// 取消一个权限
	Integer movePerm(Permission permission);

	//	初始化权限
	Integer initUserPerm(User user);

	Integer initManagerPerm(User user);

}

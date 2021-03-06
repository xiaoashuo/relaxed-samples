package com.relaxed.samples.datascope.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.relaxed.samples.datascope.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * MP 支持不需要 UserMapper.xml 这个模块演示内置 CRUD 咱们就不要 XML 部分了
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
public interface UserMapper extends BaseMapper<User> {

	/**
	 * 自定义SQL：默认也会增加多租户条件 参考打印的SQL
	 * @return
	 */
	public Integer myCount();

	public List<User> getUserAndAddr(@Param("username") String username);

	public List<User> getAddrAndUser(@Param("name") String name);

	/**
	 * 查询用户地址列表
	 * @return
	 */
	List<User> listUser();

}

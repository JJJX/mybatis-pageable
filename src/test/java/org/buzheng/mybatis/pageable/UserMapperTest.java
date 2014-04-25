package org.buzheng.mybatis.pageable;

import java.util.List;

import javax.annotation.Resource;

import org.buzheng.mybatis.pageable.domain.User;
import org.buzheng.mybatis.pageable.mapper.UserMapper;
import org.buzheng.test.BaseTestCase;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class UserMapperTest extends BaseTestCase {
	
	@Resource
	private UserMapper userMapper;
	
	@Test
	public void testFindAll() {
		List<User> users = userMapper.findAll();
		logger.info("all users: {}", users);
	}
	
	@Test
	public void testFinaPage() {
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<User> userPage = userMapper.findPage(pageRequest);
		logger.info("page 0: {}", userPage);
	}
	
}

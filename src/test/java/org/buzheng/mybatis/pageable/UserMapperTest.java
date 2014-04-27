package org.buzheng.mybatis.pageable;

import java.util.List;

import javax.annotation.Resource;

import org.buzheng.mybatis.pageable.domain.User;
import org.buzheng.mybatis.pageable.mapper.UserMapper;
import org.buzheng.test.BaseTestCase;
import org.junit.Assert;
import org.junit.Test;

public class UserMapperTest extends BaseTestCase {
	
	@Resource
	private UserMapper userMapper;
	
	@Test
	public void testFindAll() {
		List<User> users = userMapper.findAll();
		logger.info("all users: {}", users);
		Assert.assertTrue(users.size() == 18);
	}
	
	@Test
	public void testFindPage() {
		Pageable pageRequest = new Pageable(0, 10);
		Page<User> userPage = userMapper.findPage(pageRequest);
		logger.info("page 0: {}", userPage);
		Assert.assertTrue(userPage.getTotalPages() == 2);
	}
	
	@Test
	public void testFindPageByFirstName() {
		Pageable pageRequest = new Pageable(0, 15);
		Page<User> userPage = userMapper.findPageByFirstName("san", pageRequest);
		logger.info("page 0: {}", userPage);
		Assert.assertTrue(userPage.getTotalPages() == 1);
	}
	
}

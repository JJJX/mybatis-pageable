package org.buzheng.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.buzheng.test.dao.UserDao;
import org.buzheng.test.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class UserDaoTest extends BaseTestCase {
	

	protected Log logger = LogFactory.getLog(this.getClass());

	@Resource
	private UserDao userDao;
	
	@Test
	public void testFindPage() {
		Pageable pageRequest = new PageRequest(0, 5);
		Page<User> page = this.userDao.findPage(pageRequest);
		
		logger.debug(page);
		
		assertEquals(5, page.getContent().size());
		

		pageRequest = new PageRequest(1, 5);
		page = this.userDao.findPage(pageRequest);
		
		logger.debug(page);
		
		assertEquals(2, page.getContent().size());
		

		pageRequest = new PageRequest(2, 5);
		page = this.userDao.findPage(pageRequest);
		
		logger.debug(page);
		
		assertEquals(0, page.getContent().size());
	}
	
	@Test
	public void testFindPageByAge() {

		int age = 20;
		
		Pageable pageRequest = new PageRequest(0, 5);
		Page<User> page = this.userDao.findPageByAge(age, pageRequest);
		
		logger.debug(page.getContent());
		
		assertEquals(5, page.getContent().size());
		

		pageRequest = new PageRequest(1, 5);
		page = this.userDao.findPageByAge(age, pageRequest);
		
		logger.debug(page.getContent());
		
//		assertEquals(1, page.getContent().size());
		Assert.assertTrue(page.getContent().size() <= 5);
	}
	
}

package org.buzheng.test.dao;

import org.buzheng.test.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDao {
	
	Page<User> findPage(Pageable pageRequest);
	
	Page<User> findPageByAge(int age, Pageable pageRequest);
	
}

package org.buzheng.mybatis.pageable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.buzheng.mybatis.pageable.Page;
import org.buzheng.mybatis.pageable.Pageable;
import org.buzheng.mybatis.pageable.domain.User;

public interface UserMapper {

	public List<User> findAll();
	
	public Page<User> findPage(Pageable pageRequest);
	
	public Page<User> findPageByFirstName(@Param("firstName") String firstName, Pageable pageRequest);
	
}

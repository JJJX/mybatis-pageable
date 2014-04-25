package org.buzheng.mybatis.pageable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.buzheng.mybatis.pageable.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserMapper {

//	@Select("select * from user")
	public List<User> findAll();
	
//	@Select("select * from user")
	public Page<User> findPage(Pageable pageRequest);
	
//	@Select("select * from user where firstName = #{firstName}")
	public Page<User> findPageByFirstName(@Param("firstName") String firstName, Pageable pageRequest);
	
}

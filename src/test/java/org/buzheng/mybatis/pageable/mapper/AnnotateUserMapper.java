package org.buzheng.mybatis.pageable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.buzheng.mybatis.pageable.Page;
import org.buzheng.mybatis.pageable.Pageable;
import org.buzheng.mybatis.pageable.domain.User;

public interface AnnotateUserMapper {
	
	@Select("select * from user")
	public List<User> findAll();
	
	@Select("select * from user")
	@ResultType(User.class)
	public Page<User> findPage(Pageable pageRequest);
	
	@Select("select * from user where firstName = #{firstName}")
	@ResultType(User.class)
	public Page<User> findPageByFirstName(@Param("firstName") String firstName, Pageable pageRequest);
	
}

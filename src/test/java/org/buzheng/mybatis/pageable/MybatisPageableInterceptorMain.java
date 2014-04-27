package org.buzheng.mybatis.pageable;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.buzheng.mybatis.pageable.domain.User;
import org.buzheng.mybatis.pageable.mapper.AnnotateUserMapper;
import org.buzheng.mybatis.pageable.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisPageableInterceptorMain {

	static Logger logger = LoggerFactory.getLogger(MybatisPageableInterceptorMain.class);

	public static void main(String[] args) throws IOException {

		logger.info("start");

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> users = mapper.findAll();
			logger.info("all users: {}", users);

			// 分页查询
			Pageable pageRequest = new Pageable(0, 15);
			Page<User> userPage = mapper.findPage(pageRequest);
			logger.info("page 0: {}", userPage);
			
			// 分页查询
			userPage = mapper.findPageByFirstName("san", pageRequest);
			logger.info("page 0: {}", userPage);
			
			// ------------------------------------
			// 以下使用注解的mapper
			// 不使用 xml 配置而在 Mapper类中使用注解, 以下的分页查询会报错, 
			// 要求返回值类必须为一个无参的构造函数. 不懂 !!!
			// Caused by: java.lang.NoSuchMethodException: org.buzheng.mybatis.pageable.Page.<init>()
			AnnotateUserMapper mapper2 = session.getMapper(AnnotateUserMapper.class);
			List<User> users2 = mapper2.findAll();
			logger.info("all users: {}", users2);

			// 分页查询
			Pageable pageRequest2 = new Pageable(0, 15);
			Page<User> userPage2 = mapper2.findPage(pageRequest2);
			logger.info("page 0: {}", userPage2);
			
			// 分页查询
			userPage = mapper2.findPageByFirstName("san", pageRequest2);
			logger.info("page 0: {}", userPage2);

		} finally {
			session.close();
		}

	}

}

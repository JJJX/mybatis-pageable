package org.buzheng.mybatis.pageable;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.buzheng.mybatis.pageable.domain.User;
import org.buzheng.mybatis.pageable.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
//			PageRequest pageRequest = new PageRequest(0, 10);
//			Page<User> userPage = mapper.findPage(pageRequest);
//			logger.info("page 0: {}", userPage);

		} finally {
			session.close();
		}

	}

}

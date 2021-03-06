# Mybatis Pageable

## 背景
实现分页基于以下想法，就是直接将分页请求对象（包括请求页面，页面大小等）作为参数传入，返回为需要的分页对象（包含总页数、总记录数、当前页码、当前页记录等）。没有对Mybatis的原理去做过多的了解，知道拦截器可以实现此功能，再加上网上借鉴了一些代码，先实现了想法。

## 使用方法和思路

拦截器会对Mapper方法中的参数进行分析，如果发现Pageable类型的参数，则认为是分页请求，将请求封装为数据库分页sql，查询出总记录数和当前页记录，封装为Page对象返回。Page对象代表了当前页的信息。

### 拦截器配置 在 mybatis-config.xml 中

```xml
<plugins>
    <plugin interceptor="org.buzheng.mybatis.pageable.MybatisPageableInterceptor">
	    <property name="dialectClass" value="org.buzheng.mybatis.pageable.MySQLDialect"/>
	</plugin>
</plugins>
```

### Mapper接口方法写法

```java
public interface UserMapper {
	public List<User> findAll();	
	public Page<User> findPage(Pageable pageRequest);	
	public Page<User> findPageByFirstName(@Param("firstName") String firstName, Pageable pageRequest);	
}
```

### Mapper.xml 写法(和普通查询一样)

```xml
<mapper namespace="org.buzheng.mybatis.pageable.mapper.UserMapper">

  <select id="findAll" resultType="User">
    select * from user
  </select>
    
  <select id="findPage" resultType="User">
    select * from user
  </select>
  
  <select id="findPageByFirstName" resultType="User">
    select * from user where firstName = #{firstName}
  </select>
</mapper>
```

### 使用方法
```java
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

} finally {
	session.close();
}
```

### 具体使用方法，参看测试案例，位于 src/test/java中
- 单独使用mybatis时，参考：org.buzheng.mybatis.pageable.MybatisPageableInterceptorMain
- spring继承mybatis时，参看测试用例：org.buzheng.mybatis.pageable.UserMaperTest

## 问题
分页暂时只支持Mapper方法中的sql在 xml 中配置。

如果sql通过注解@Select来配置，则会报错：Caused by: java.lang.NoSuchMethodException: org.buzheng.mybatis.pageable.Page.&lt;init>()

********************************************************

方言类和部分逻辑来源于 https://github.com/miemiedev/mybatis-paginator ，特此感谢。

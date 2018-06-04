####传统方式访问数据库：
* 手动创建Connection、prepareStatement、ResultSet等信息
* 使用JdbcTemplate
* 使用spring-data-jpa
***
#### Repository
* Repository是一个空接口，标记接口，标记接口：没有包含方法声明的接口
* 如果我们定义的接口EmployeeRepository extends Repository
* 如果我们自己的接口没有extends Repository,运行时会报错：  
org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.jeffrey.repository.EmployeeRepository' available
* 添加注解能达到不用extends Repository的功能：  
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
* 对于按照方法命名规则赖使用的话，有弊端：  
    * 方法名会比较长：约定大于配置  
    * 对于一些复杂的查询，是很难实现
* Query注解使用：
    * 在Respository方法中使用，不需要遵循查询方法命名规则
    * 只需要将@Query定义在Respository中的方法之上即可
    * 支持命名参数及索引参数的使用
    * 支持本地查询
* 更新及删除操作整合事务的使用
    * @Modifying注解使用
    * @Modifying结合@Query注解执行更新操作
    * @Transaction在Spring Data中的使用
* 事务在Spring Data中的使用：
    * 事务一般是在Service层
    * @Query、@Modifying、@Transactional的综合使用
* PagingAndSortingRespository接口使用详解
    * 该接口包含分页和排序的功能
    * 带排序的查询：findAll(Sort sort)
    * 带排序的分页查询：findAll(Pageable pageable)
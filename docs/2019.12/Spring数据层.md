### Spring事务抽象

- #### 事务传播特性

  - PROPAGATION_REQUIRED 当前有事务就用当前的，没有就用新的
  - PROPAGATION_SUPPORTS 事务可有可无，不是必须的
  - PROPAGATION_MANDATORY 当前一定要有事务，不然就抛异常
  - PROPAGATION_REQUIRES_NEW 无论是否有事务，都起个新事务
  - PROPAGATION_NOT_SUPPORTED 不支持事务，按非事务方式运行
  - PROPAGATION_NEVER 不支持事务，如果有事务则抛异常
  - PROPAGATION_NESTED 当前有事务就在当前事务里再起一个事务

- #### 编程式事务

  - ##### TransactionTemplate

    - TransactionCallback
    - TransactionCallbackWithoutResult

  - ##### PlatformTransactionManager

- #### 声明式事务

  - AOP

  - ##### 基于注解的配置方式

    - @EnableTransactionManagement
    - \<tx:annotation-driven>
    - proxyTargetClass
    - mode
    - order
    - @Transactional
      - transactionManager
      - propagation
      - isolation
      - timeout
      - readOnly
      - rollbackFor

### Spring的JDBC异常抽象

- Spring会将数据操作的异常转换为DataAccessException
- 通过SQLErrorCodeSQLExceptionTranslator解析错误码
- ErrorCode定义
  - org/springframwork/jdbc/support/sql-error-codes.xml
  - Classpath下的sql-error-codes.xml

### MyBatis

- 支持定制化SQL、存储过程和高级映射

- Spring中使用MyBatis

  - MyBatis Spring Adapter
  - MyBatis Spring-Boot-Starter

- SpringBoot中的简单配置

  - mybatis.mapper-locations = classpath*:mapper/**/\*.xml
  - mybatis.type-alias-package = 类型别名的包名
  - mybatis.type-handlers-package = TypeHandler扫描包名
  - mybatis-configuration.map-underscore-to-camel-case = true

- #### MyBatis Generator

  - 命令行：java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml
  - Maven Plugin(mybatis-generator-maven-plugin)
  - Java 编程

- #### MyBatis PageHelper

### NoSQL

#### Spring MongoDB

- MondoTemplate
- MongoCustomConversions
- @EnableMongoRepository
- MongoRepository\<T,ID\>、PagingAndSortRepository\<T,ID>、CrudRepository\<T,ID>

#### Redis

- Redis是一款开源的内存KV存储，支持多种数据结构
- Spring Data Redis
  - 支持的客户端Jedis/Lettuce
  - RedisTemplate
  - Repository支持
- Jedis客户端的简单使用
  - Jedis不是线程安全的
  - 通过JedisPool获得Jedis实例
  - 直接使用Jedis的方法
- 与Redis建立连接
  - 配置连接工厂
    - LettuceConnectionFactory和JedisConnectionFactory
      - RedisStandaloneConfiguration
      - RedisSentinelConfiguration
      - RedisClusterConfiguration

### Spring缓存抽象

- #### 为不同的缓存提供一层抽象

  - 为Java方法增加缓存，缓存执行结果
  - 支持ConcurrentMap、EhCache、Caffeine、JCache(JSR-107)
  - 接口
    - org.springframework.cache.Cache
    - org.springframewaork.cache.CacheManager

- #### 基于注解的缓存

  - @EnableCaching
    - @Cacheable
    - @CacheEvict
    - @CachePut
    - @Caching
    - @CacheConfig



​    
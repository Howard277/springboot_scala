#简介
1. 项目为scala编写的一个spring boot web项目
2. 项目中使用spring-data-jpa作为dao层技术框架，Mysql的数据源配置在com.ms.springbootscala.config.DataSourceConfig中
3. 项目中使用spring-boot-starter-data-redis作为redis接入框架，redis通过RedisTemplate实例来访问，配置在com.ms.springbootscala.config.RedisConfig中
4. 项目中使用spring-boot-starter-data-mongodb作为mongo接入框架，mongo通过MongoTemplate实例来访问，配置在com.ms.springbootscala.config.MongodbConfig中
5. 项目中使用logback作为日志框架
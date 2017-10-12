package com.ms.cashloan.config

import java.sql.SQLException

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * 数据库配置类
  * Created by wuketao on 2017/9/15.
  */
@Configuration
class DataSourceConfig {
  @Value("${spring.datasource.jdbcUrl}")
  val jdbcUrl: String = ""
  @Value("${spring.datasource.userName}")
  val userName: String = ""
  @Value("${spring.datasource.password}")
  val password: String = ""
  @Value("${spring.datasource.driverClassName}")
  val driverClassName: String = ""
  @Value("${spring.datasource.maximum-pool-size}")
  val maximumPoolSize: Int = 0
  @Value("${spring.datasource.maximum-idle}")
  val maximumIdle: Int = 0
  @Value("${spring.datasource.minimum-idle}")
  val minimumIdle: Int = 0

  /**
    * 配置数据源
    * @return
    */
  @Bean
  @throws[SQLException]
  def dataSource = {
    var config: HikariConfig = new HikariConfig()
    config.setJdbcUrl(jdbcUrl)
    config.setUsername(userName)
    config.setPassword(password)
    config.setDriverClassName(driverClassName)
    config.setMaximumPoolSize(maximumPoolSize)
    config.setMinimumIdle(minimumIdle)
    new HikariDataSource(config)
  }
}

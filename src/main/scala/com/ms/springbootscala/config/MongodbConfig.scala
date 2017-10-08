package com.ms.springbootscala.config

import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.data.mongodb.core.{MongoFactoryBean, MongoTemplate}
import com.mongodb.Mongo

/**
  * mongo数据库配置类，用于提供MongoTemplate
  * Created by Administrator on 2017/10/7.
  */
@Configuration
class MongodbConfig {
  @Value("${mongo.host}")
  var host: String = _
  @Value("${mongo.port}")
  var port: Int = _
  @Value("${mongo.databaseName}")
  var databaseName: String = _

  /**
    * 创建mongo
    * @return
    */
  def getMongo: Mongo = {
    var mongo = new Mongo(host, port)
    mongo
  }

  /**
    * mongo模板对象
    * @return
    */
  @Bean
  def mongoTemplate: MongoTemplate = {
    var template = new MongoTemplate(getMongo, databaseName)

    template
  }
}

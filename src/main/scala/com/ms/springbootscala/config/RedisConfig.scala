package com.ms.springbootscala.config

import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.{Bean, Conditional, Configuration}
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import redis.clients.jedis.JedisPoolConfig

/**
  * redis配置类，用于提供RedisTemplate
  * Created by wuketao on 2017/9/20.
  */
@Configuration
class RedisConfig {
  @Value("${redis.maxActive}")
  var maxActive: Int = _
  @Value("${redis.maxIdle}")
  var maxIdle: Int = _
  @Value("${redis.maxWait}")
  var maxWait: Int = _
  @Value("${redis.default.db}")
  var db: Int = _
  @Value("${redis.host}")
  var host: String = _
  @Value("${redis.port}")
  var port: Int = _
  @Value("${redis.password}")
  var password: String = _
  @Value("${redis.timeout}")
  var timeout: Int = _

  @Bean
  def jedisPoolConfig: JedisPoolConfig = {
    var config: JedisPoolConfig = new JedisPoolConfig()
    config.setMaxIdle(maxIdle)
    config.setMaxTotal(maxActive)
    config.setMaxWaitMillis(maxWait)
    config
  }

  @Autowired
  var config: JedisPoolConfig = _

  @Bean
  def jedisConnectionFactory: JedisConnectionFactory = {
    var factory: JedisConnectionFactory = new JedisConnectionFactory(config)
    factory.setDatabase(db)
    factory.setHostName(host)
    factory.setPort(port)
    //    factory.setPassword(password)
    factory.setTimeout(timeout)
    factory.setUsePool(true)

    factory
  }

  @Autowired
  var factory: JedisConnectionFactory = _

  @Bean
  def redisTemplate: RedisTemplate[String, AnyRef] = {
    val redisTemplate = new RedisTemplate[String, AnyRef]
    redisTemplate.setConnectionFactory(factory)
    redisTemplate
  }

}

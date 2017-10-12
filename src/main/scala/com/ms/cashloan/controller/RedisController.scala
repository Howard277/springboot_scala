package com.ms.cashloan.controller

import java.util.Date

import com.ms.cashloan.entities.User
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

/**
  * redis 控制器
  * Created by wuketao on 2017/9/20.
  */
@RestController
@RequestMapping(path = Array("redis"))
class RedisController {
  /**
    * 注入redis模板
    */
  @Autowired(required = false)
  var redisTemplate: RedisTemplate[String, AnyRef] = _

  /**
    * 测试向redis中存入数据
    * @return
    */
  @ApiOperation(value = "put数据进redis测试方法")
  @RequestMapping(path = Array("putTest"), method = Array(RequestMethod.GET))
  def putTest: String = {
    var user = new User
    user.setBirthday(new Date())
    user.setId(1)
    user.setName("xiaohai")
    user.setTelephone("9999999")
    redisTemplate.opsForValue().set("user", user)
    "ok"
  }

  /**
    * 测试从redis中获取数据
    * @return
    */
  @ApiOperation(value = "get数据从redis测试方法")
  @RequestMapping(path = Array("getTest"), method = Array(RequestMethod.GET))
  def getTest: AnyRef = {
    redisTemplate.opsForValue().get("user")
  }
}

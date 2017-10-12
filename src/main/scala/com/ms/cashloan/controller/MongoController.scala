package com.ms.cashloan.controller

import java.util.Date

import com.ms.cashloan.entities.User
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

/**
  * Created by wuketao on 2017/10/8.
  */
@ApiOperation("mongodb控制器")
@RestController
@RequestMapping(path = Array("mongo"))
class MongoController {
  @Autowired(required = false)
  var mongoTemplate: MongoTemplate = _

  @ApiOperation("测试mongodb插入数据")
  @RequestMapping(value = Array("insertTest"), method = Array(RequestMethod.GET))
  def insertTest: Unit = {
    var user = new User();
    user.setId(2)
    user.setBirthday(new Date())
    user.setName("xiaohai")
    user.setTelephone("234")
    user.setLevels("admin;user")
    mongoTemplate.insert(user)
  }

  @ApiOperation("从mongodb中获取user集合所有数据")
  @RequestMapping(path=Array("findAll"), method = Array(RequestMethod.GET))
  def findAll: java.util.List[User] = {
    var query = new Query();
    //mongo中的collection对应着这里的第二个参数。
    var javaList = mongoTemplate.find(query, classOf[User])
    javaList
  }

}

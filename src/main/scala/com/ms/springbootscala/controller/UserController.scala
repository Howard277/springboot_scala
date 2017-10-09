package com.ms.springbootscala.controller

import java.util.{Date, List, UUID}
import javax.validation.Valid

import com.ms.springbootscala.service.UserService
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation._
import com.ms.springbootscala.entities._

import scala.collection.mutable.ListBuffer

/**
  * 用户控制器
  *
  */
@Controller
@ResponseBody
class UserController {
  @Autowired()
  var userService: UserService = _

  /**
    * 创建日志器
    */
  val log = LoggerFactory.getLogger(classOf[UserController])

  @ApiOperation(value = "获取所有用户")
  @RequestMapping(value = Array("/list"), method = Array(RequestMethod.GET))
  def list(): Unit = {

    var thread1 = new Thread() {
      var listBuffer = new ListBuffer[User]

      override def run(): Unit = {
        while (true) {
          listBuffer.+=(new User() {
            name = UUID.randomUUID().toString();
            birthday = new Date()
            telephone = UUID.randomUUID().toString()
          })
          log.info("create user")
        }
      }
    }.start()
  }

  @ApiOperation(value = "保存用户")
  @RequestMapping(value = Array("save"), method = Array(RequestMethod.POST))
  def save(@Valid user: User): User = {
    userService.save(user)
  }

  @ApiOperation(value = "通过id获取用户")
  @RequestMapping(value = Array("/find/{id}"), method = Array(RequestMethod.GET))
  def find(@PathVariable(value = "id") id: Long): User = {
    var u = userService.find(id)
    log.info(u.toString)
    u
  }

  @ApiOperation(value = "通过id删除用户")
  @RequestMapping(value = Array("delete/{id}"), method = Array(RequestMethod.POST))
  def delete(@PathVariable(value = "id") id: Long): Unit = {
    userService.delete(id)
  }

  @ApiOperation(value = "更新用户信息")
  @RequestMapping(value = Array("update"), method = Array(RequestMethod.POST))
  def update(@Valid user: User, bindingResult: BindingResult): User = {
    userService.update(user)
  }

  @RequestMapping(value = Array("page"), method = Array(RequestMethod.GET))
  def page(@RequestParam("page") page: Int, @RequestParam("pageSize") pageSize: Int): Page[User] = {
    userService.page(page, pageSize)
  }
}
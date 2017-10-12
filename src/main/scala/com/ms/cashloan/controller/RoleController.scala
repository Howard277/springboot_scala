package com.ms.cashloan.controller

import com.ms.cashloan.entities.Role
import com.ms.cashloan.service.RoleService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

import scala.collection.mutable._


/**
  * Created by wuketao on 2017/9/19.
  */
@RestController
@RequestMapping(path = Array("role"))
class RoleController {

  @Autowired
  var roleService: RoleService = _

  @ApiOperation(value = "查找所有角色")
  @RequestMapping(path = Array("findAll"), method = Array(RequestMethod.GET))
  def findAll: Buffer[Role] = {
    roleService.findAll
  }

  @ApiOperation(value = "保存角色")
  @RequestMapping(path = Array("save"), method = Array(RequestMethod.POST))
  def save(role: Role): Role = {
    roleService.save(role)
  }
}

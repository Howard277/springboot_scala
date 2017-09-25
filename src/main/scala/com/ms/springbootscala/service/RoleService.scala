package com.ms.springbootscala.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.ms.springbootscala.entities._
import scala.collection.mutable._
import com.ms.springbootscala.repository._
import scala.collection.JavaConverters._

/**
  * 角色服务类
  * Created by wuketao on 2017/9/19.
  */
@Service
class RoleService {

  var log = LoggerFactory.getLogger(classOf[RoleService])

  @Autowired
  var roleRepository: RoleRepository = _

  def findAll: Buffer[Role] = {
    roleRepository.findAll.asScala
  }

  def save(role: Role): Role = {
    roleRepository.save(role)
  }
}

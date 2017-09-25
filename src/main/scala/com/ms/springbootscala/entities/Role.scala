package com.ms.springbootscala.entities

import java.lang.Long
import javax.persistence.{Entity, GeneratedValue, Id}

import scala.beans.BeanProperty

/**
  * 角色类
  * Created by wuketao on 2017/9/19.
  */
@Entity
class Role {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var code: String = _

  @BeanProperty
  var description: String = _
}

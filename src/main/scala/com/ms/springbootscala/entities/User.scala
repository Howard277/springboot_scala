package com.ms.springbootscala.entities

import java.util.Date
import javax.persistence.{Entity, GeneratedValue, Id}
import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.{NotBlank, NotEmpty}
import org.springframework.format.annotation.DateTimeFormat

import scala.beans.BeanProperty

@Entity
class User extends Serializable {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @NotBlank
  var name: String = _

  @BeanProperty
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  var birthday: Date = _

  @BeanProperty
  @NotEmpty
  var telephone: String = _

  @BeanProperty
  @NotEmpty
  var levels: String = _

  override def toString = "id = " + id + ",name = " + name + ",birthday = " + birthday + ",telephone = " + telephone

}
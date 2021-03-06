package com.ms.cashloan.repository

import java.lang.Long
import com.ms.cashloan.entities._
import org.springframework.data.jpa.repository.JpaRepository

/**
  * 角色 Repository
  * Created by wuketao on 2017/9/19.
  */
trait RoleRepository extends JpaRepository[Role, Long] {

}

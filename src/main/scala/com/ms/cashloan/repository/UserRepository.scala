package com.ms.cashloan.repository

import java.lang.Long
import com.ms.cashloan.entities._
import org.springframework.data.jpa.repository.JpaRepository

trait UserRepository extends JpaRepository[User, Long]
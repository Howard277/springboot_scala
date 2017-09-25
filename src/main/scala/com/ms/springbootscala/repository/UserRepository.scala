package com.ms.springbootscala.repository

import java.lang.Long
import com.ms.springbootscala.entities._
import org.springframework.data.jpa.repository.JpaRepository

trait UserRepository extends JpaRepository[User, Long]
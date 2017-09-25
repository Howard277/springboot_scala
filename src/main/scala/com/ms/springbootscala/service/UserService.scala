package com.ms.springbootscala.service

import com.ms.springbootscala.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.ms.springbootscala.entities._

/**
  * 用户服务类
  */
@Transactional
@Service
class UserService extends BaseService[User] {
  
    @Autowired var userRepository: UserRepository = _
}
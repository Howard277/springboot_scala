package com.ms.cashloan

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
  * Created by wuketao on 2017/9/25.
  */
@EnableTransactionManagement
@SpringBootApplication
@EnableSwagger2
class CashLoanApplication

object CashLoanApplication extends App{
  SpringApplication.run(classOf[CashLoanApplication])
}

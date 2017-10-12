package com.ms.cashloan.config

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver

/**
  * Created by Administrator on 2017/10/9.
  */
@Configuration
class VelocityConfig {

  import org.springframework.context.annotation.Bean
  import org.springframework.web.servlet.ViewResolver
  import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver

  /**
    * 模板viewResolver
    */
  @Bean
  def getViewResolver: ViewResolver = {
    val resolver = new VelocityLayoutViewResolver
    resolver.setSuffix(".vm")
    resolver.setContentType("text/html;charset=utf-8")
    resolver.setExposeRequestAttributes(true)
    resolver.setExposeSessionAttributes(true)
//    resolver.setRequestContextAttribute(REQUEST_CONTEXT_ATTRIBUTE)
//    resolver.setToolboxConfigLocation(getToolboxConfigLocation)
    resolver.setLayoutUrl("layout/layout.vm")
    resolver.setOrder(0)
    resolver
  }
}

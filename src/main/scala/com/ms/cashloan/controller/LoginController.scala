package com.ms.cashloan.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import org.springframework.web.servlet.ModelAndView

/**
  * Created by wuketao on 2017/10/12.
  */
@Controller
@RequestMapping(path=Array("login"))
class LoginController {
  @RequestMapping(path=Array("/login"),method = Array(RequestMethod.GET))
  def login:ModelAndView={
    var mav = new ModelAndView()
    mav.setViewName("login")
    mav
  }
}

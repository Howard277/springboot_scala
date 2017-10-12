package com.ms.cashloan.controller

import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import org.springframework.web.servlet.ModelAndView

/**
  * Created by wuketao on 2017/10/12.
  */
@Controller
@RequestMapping(path=Array("/"))
class CashLoanController {
  @ApiOperation(value = "主页")
  @RequestMapping(path=Array("/"),method=Array(RequestMethod.GET))
  def index:ModelAndView={
    var mav = new ModelAndView("index")
    mav
  }
}

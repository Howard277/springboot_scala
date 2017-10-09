package com.ms.springbootscala.controller

import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import org.springframework.web.servlet.ModelAndView

/**
  * Created by wuketao on 2017/10/9.
  */
@Controller
@RequestMapping(path=Array("layer"))
class LayerDemoController {

  @ApiOperation(value = "索引页面")
  @RequestMapping(path=Array("index"),method=Array(RequestMethod.GET))
  def index:ModelAndView={
    var mav = new ModelAndView("index")
    mav
  }
}

package com.ms.springbootscala.controller

import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import org.springframework.web.servlet.ModelAndView

/**
  * Created by wuketao on 2017/10/9.
  */
@Controller
@RequestMapping(path=Array("layui","/"))
class LayuiController {

  @ApiOperation(value = "索引页面")
  @RequestMapping(path=Array("index","/"),method=Array(RequestMethod.GET))
  def index:ModelAndView={
    var mav = new ModelAndView("/layout/layout_default")
    mav
  }

  @ApiOperation(value = "测试页面1")
  @RequestMapping(path=Array("test1"),method=Array(RequestMethod.GET))
  def test1:ModelAndView={
    var mav = new ModelAndView("test1")
    mav
  }
}

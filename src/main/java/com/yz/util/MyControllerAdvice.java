package com.yz.util;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2019/12/26 15:46
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
@ControllerAdvice
public class MyControllerAdvice {

    public MyControllerAdvice(){
        System.out.println("========MyControllerAdvice============");
    }


//    @ExceptionHandler
//    public String handler(ArithmeticException ex){
//        System.out.println(ex.getMessage());
//        ModelAndView ModelAndView = new ModelAndView("index");
//        ModelAndView.addObject("ex",ex);
//        return "redirect:/index.jsp";
//    }

}

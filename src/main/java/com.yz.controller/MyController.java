package com.yz.controller;

import com.yz.mode.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2019/12/25 10:48
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */


@Controller
@RequestMapping("/myController")
public class MyController {



    @RequestMapping("/toSuccess")
    public ModelAndView toSuccess(HttpServletRequest request){
        request.setAttribute("name",":asdasd");
        ModelAndView ModelAndView = new ModelAndView();
        ModelAndView.addObject("name","yz");
        ModelAndView.setViewName("success");
        return ModelAndView;
    }

    @RequestMapping("/testRest/{id}")
    public String testJson(@PathVariable("id") Integer id){
        System.out.println("============"+id);
        return "success";
    }


    @GetMapping("/testMethod/{id}")
    public String testMethod(@PathVariable("id") Integer id){
        System.out.println("============"+id);
        return "success";
    }


    @PostMapping("/testMethod/{id}")
    public String testMethod2(@PathVariable("id") Integer id){
        System.out.println("============"+id);
        return "success";
    }

    @DeleteMapping("/testMethod/{id}")
    public String testMethodDelete(@PathVariable("id") Integer id){
        System.out.println("testMethodDelete"+id);
        return "success";
    }

    @PutMapping("/testMethod/{id}")
    public String testMethodPut(@PathVariable("id") Integer id){
        System.out.println("testMethodPut"+id);
        return "success";
    }


    @RequestMapping("/testRequestParam")
    public String testJson(@RequestParam(value = "name",defaultValue = "666") String id,@RequestParam(value = "sex",required = true) String idsex
    ,@RequestHeader(value="Accept") String header,@CookieValue("JSESSIONID") String cookeiVal){
        System.out.println("============"+id);
        System.out.println("============"+idsex);
        System.out.println("============"+header);
        System.out.println("============"+cookeiVal);
        return "success";
    }

    @RequestMapping("/testPoJo")
    public String testJson(User user){
        System.out.println("============"+user);
        return "success";
    }


    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("testForward");
        return "forward:/index.jsp";
    }


}

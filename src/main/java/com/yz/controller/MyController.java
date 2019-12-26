package com.yz.controller;

import com.yz.mode.User;
import com.yz.service.UserService;
import com.yz.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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

    public MyController(){
        System.out.println("======MyController===========");
    }

    @Autowired
    private UserService userService;



    @RequestMapping("/toSuccess")
    public ModelAndView toSuccess(HttpServletRequest request){
        request.setAttribute("name",":asdasd");
        ModelAndView ModelAndView = new ModelAndView();
        ModelAndView.addObject("name","yz");
        ModelAndView.setViewName("success");
        return ModelAndView;
    }

    @RequestMapping("/testRest/{id}")
    public String testJson(@PathVariable("id") Integer id) throws Exception{
        if(id==12){
            throw new MyException();
        }


        try{
            int a = 2/id;
        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }
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
    public String testJson( @Valid User user, Errors errors){
        System.out.println("============"+user);
        if(errors.getErrorCount() >0){
            for(FieldError error:errors.getFieldErrors()){
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }
        }
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

    @RequestMapping("/testCoversionService")
    public String testCoversionService(@RequestParam("param") User user){

        System.out.println(user);
        return "forward:/index.jsp";
    }

    @InitBinder
    public void initBinder(WebDataBinder wbDataBinder){
        wbDataBinder.setDisallowedFields("name");
    }


    /**
     * 如果返回值是string StringHttpMessageConverter carRead canWrite
     * 如果返回值是VO 加入 jackson jar  MappingJackson2HttpMessageConverter carRead canWrite
     **/
    @ResponseBody
    @RequestMapping("/testMessageCover")
    public User testMessageCover(@RequestBody User user2){
        User User = new User();
        User.setEmail("357823669@qq");
        User.setName("yz");
        User.setSex("boy");
        return User;
    }


    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam(value = "desc",required = false) String desc,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("desc: " + desc);
        System.out.println("OriginalFilename: " + file.getOriginalFilename());
        System.out.println("InputStream: " + file.getInputStream());
        return "success";
    }

    /**
     * 1. 在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数, 该参数即对应发生的异常对象
     * 2. @ExceptionHandler 方法的入参中不能传入 Map. 若希望把异常信息传导页面上, 需要使用 ModelAndView 作为返回值
     * 3. @ExceptionHandler 方法标记的异常有优先级的问题.
     * 4. @ControllerAdvice: 如果在当前 Handler 中找不到 @ExceptionHandler 方法来出来当前方法出现的异常,
     * 则将去 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常.
     */
//    @ExceptionHandler({RuntimeException.class})
//    public ModelAndView handlerException (Exception ex){
//        System.out.println(ex.getMessage());
//        ModelAndView ModelAndView = new ModelAndView("success");
//        ModelAndView.addObject("ex",ex);
//        return ModelAndView;
//    }


    @ResponseBody
    @RequestMapping("/testSpring")
    public List<User> testSpring()   {
        return userService.getAll();
    }

}

package com.yz.util;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2019/12/26 15:53
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 在异常及异常父类中找到 @ResponseStatus 注解，然
后使用这个注解的属性进行处理。
• 定义一个 @ResponseStatus 注解修饰的异常类
• 若在处理器方法中抛出了上述异常：
若ExceptionHandlerExceptionResolver 不解析述异常。由于
触发的异常 UnauthorizedException 带有@ResponseStatus
注解。因此会被ResponseStatusExceptionResolver 解析
到。最后响应HttpStatus.UNAUTHORIZED 代码给客户
端。HttpStatus.UNAUTHORIZED 代表响应码401，无权限。
关于其他的响应码请参考 HttpStatus 枚举类型源码。 2019/12/26
 * @Param
 * @return
 **/



//DefaultHandlerExceptionResolver
  //      • 对一些特殊的异常进行处理，比
    //    如NoSuchRequestHandlingMethodException、HttpReques
      //  tMethodNotSupportedException、HttpMediaTypeNotSuppo
       // rtedException、HttpMediaTypeNotAcceptableException
       // 等。
//抛出的异常不能是ControlleAdvice 标注异常的子类，否则会走到那边去
@ResponseStatus(value = HttpStatus.TEMPORARY_REDIRECT,reason = "就是不行")
public class MyException extends RuntimeException{
}

package com.yz.service;

import com.yz.mapper.UserMapper;
import com.yz.mode.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2019/12/26 17:09
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */

@Service
public class UserService {

    public UserService(){
        System.out.println("=======UserService===============");
    }

    @Autowired
    private UserMapper UserMapper;

    public List<User> getAll(){
        return UserMapper.getAll();
    }
}

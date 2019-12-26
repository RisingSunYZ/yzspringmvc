package com.yz.mapper;

import com.yz.mode.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2019/12/26 17:55
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */

@Repository
public class UserMapper {

    public List<User> getAll(){

        List<User> list = new ArrayList<>();
        User u = new User();
        u.setEmail("123");
        u.setName("zxc");
        u.setSex("123345");
        list.add(u);
        return list;
    }

}

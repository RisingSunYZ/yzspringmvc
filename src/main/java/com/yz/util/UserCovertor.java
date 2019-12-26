package com.yz.util;

import com.yz.mode.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2019/12/26 11:22
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */

@Component
public class UserCovertor implements Converter<String,User> {
    @Override
    public User convert(String o) {
        User User = new User();
        String[] split = o.split(",");
        User.setName(split[0]);
        User.setSex(split[1]);
        User.setEmail(split[2]);
        return User;
    }
}

package com.superm.easy.cloud.auth.authorization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.superm.easy.cloud.auth.authorization.entity.Users;
import org.springframework.cache.annotation.Cacheable;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Chao.Ma
 * @since 2019-06-11
 */
public interface IUsersService extends IService<Users> {

    /**
     * @description: 根据用户名查询用户信息
     * @param: [username]
     * @return: com.superm.easy.cloud.auth.authorization.entity.Users
     * @author: Chao.Ma
     * @date: 2019-06-12
     **/
    @Cacheable(value = "#id")
    Users getByUsername(String username);
}

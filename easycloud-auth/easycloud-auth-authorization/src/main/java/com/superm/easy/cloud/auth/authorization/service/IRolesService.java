package com.superm.easy.cloud.auth.authorization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.superm.easy.cloud.auth.authorization.entity.Roles;

import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Chao.Ma
 * @since 2019-06-11
 */
public interface IRolesService extends IService<Roles> {

    /**
     * @description: 查询用户的角色列表
     * @param: [userId]
     * @return: java.util.Set<com.superm.easy.cloud.auth.authorization.entity.Roles>
     * @author: Chao.Ma
     * @date: 2019-06-12
     **/
    Set<Roles> queryUserRolesByUserId(long userId);
}

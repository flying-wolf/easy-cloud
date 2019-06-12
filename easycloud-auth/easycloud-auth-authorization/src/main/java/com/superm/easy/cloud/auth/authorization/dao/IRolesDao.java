package com.superm.easy.cloud.auth.authorization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.superm.easy.cloud.auth.authorization.entity.Roles;

import java.util.Set;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Chao.Ma
 * @since 2019-06-11
 */
public interface IRolesDao extends BaseMapper<Roles> {

    /**
     * @description: 查询用户的角色列表
     * @param: [userId]
     * @return: java.util.Set<com.superm.easy.cloud.auth.authorization.entity.Roles>
     * @author: Chao.Ma
     * @date: 2019-06-12
     **/ 
    Set<Roles> queryByUserId(long userId);
}

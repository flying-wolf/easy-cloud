package com.superm.easy.cloud.auth.authorization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.superm.easy.cloud.auth.authorization.dao.IRolesDao;
import com.superm.easy.cloud.auth.authorization.entity.Roles;
import com.superm.easy.cloud.auth.authorization.service.IRolesService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Chao.Ma
 * @since 2019-06-11
 */
@Service
public class RolesServiceImpl extends ServiceImpl<IRolesDao, Roles> implements IRolesService {

    @Override
    public Set<Roles> queryUserRolesByUserId(long userId) {
        return baseMapper.queryByUserId(userId);
    }
}

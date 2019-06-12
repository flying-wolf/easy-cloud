package com.superm.easy.cloud.auth.authorization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.superm.easy.cloud.auth.authorization.dao.IUsersDao;
import com.superm.easy.cloud.auth.authorization.entity.Users;
import com.superm.easy.cloud.auth.authorization.service.IUsersService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Chao.Ma
 * @since 2019-06-11
 */
@Service
public class UsersServiceImpl extends ServiceImpl<IUsersDao, Users> implements IUsersService {

    @Override
    public Users getByUsername(String username) {
        return this.getOne(new LambdaQueryWrapper<Users>().eq(Users::getUsername, username));
    }
}

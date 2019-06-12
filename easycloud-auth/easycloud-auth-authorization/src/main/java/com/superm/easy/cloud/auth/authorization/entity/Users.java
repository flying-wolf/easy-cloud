package com.superm.easy.cloud.auth.authorization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.superm.easy.cloud.commons.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Chao.Ma
 * @since 2019-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Users extends BaseEntity<Roles> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 用户密码密文
     */
    @TableField("password")
    private String password;

    /**
     * 用户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 用户手机
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 是否有效用户
     */
    @TableField("enabled")
    private Boolean enabled;

    /**
     * 账号是否未过期
     */
    @TableField("account_non_expired")
    private Boolean accountNonExpired;

    /**
     * 密码是否未过期
     */
    @TableField("credentials_non_expired")
    private Boolean credentialsNonExpired;

    /**
     * 是否未锁定
     */
    @TableField("account_non_locked")
    private Boolean accountNonLocked;

    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String NAME = "name";

    public static final String MOBILE = "mobile";

    public static final String ENABLED = "enabled";

    public static final String ACCOUNT_NON_EXPIRED = "account_non_expired";

    public static final String CREDENTIALS_NON_EXPIRED = "credentials_non_expired";

    public static final String ACCOUNT_NON_LOCKED = "account_non_locked";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

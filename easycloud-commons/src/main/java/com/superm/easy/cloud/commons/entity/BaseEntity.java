package com.superm.easy.cloud.commons.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: easy-cloud
 * @description: 基础实体类
 * @author: Chao.Ma
 * @create: 2019-06-11 22:48
 **/
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> {
    /**
     * 创建时间
     */
    @TableField(value = "created_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time", fill = FieldFill.UPDATE)
    private LocalDateTime updatedTime;

    /**
     * 创建人
     */
    @TableField(value = "created_by", fill = FieldFill.INSERT_UPDATE)
    private String createdBy;

    /**
     * 更新人
     */
    @TableField(value = "updated_by", fill = FieldFill.UPDATE)
    private String updatedBy;


    public static final String CREATED_TIME = "created_time";

    public static final String UPDATED_TIME = "updated_time";

    public static final String CREATED_BY = "created_by";

    public static final String UPDATED_BY = "updated_by";
}

package com.superm.easy.cloud.mybatisplus.demo.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Chao.Ma
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_device_info")
public class DeviceInfo extends Model<DeviceInfo> {

private static final long serialVersionUID=1L;

    /**
     * primary key
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * device serial
     */
    @TableField("device_did")
    private String deviceDid;

    /**
     * device inner serial
     */
    @TableField("device_uid")
    private String deviceUid;

    /**
     * device name
     */
    @TableField("name")
    private String name;

    /**
     * user id bind
     */
    @TableField("user_id")
    private Long userId;

    /**
     * bind state, 0-unbind, 1-bingding
     */
    @TableField("bind_state")
    private Integer bindState;

    /**
     * vehicle type: 1-sedan,2-suv,3-sports car
     */
    @TableField("vehicle_type")
    private Integer vehicleType;

    /**
     * record creation time
     */
    @TableField("created_at")
    private Date createdAt;

    /**
     * record modify time
     */
    @TableField("updated_at")
    private Date updatedAt;


    public static final String ID = "id";

    public static final String DEVICE_DID = "device_did";

    public static final String DEVICE_UID = "device_uid";

    public static final String NAME = "name";

    public static final String USER_ID = "user_id";

    public static final String BIND_STATE = "bind_state";

    public static final String VEHICLE_TYPE = "vehicle_type";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

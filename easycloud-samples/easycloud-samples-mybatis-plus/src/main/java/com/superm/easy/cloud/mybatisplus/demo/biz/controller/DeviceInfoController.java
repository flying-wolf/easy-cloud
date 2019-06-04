package com.superm.easy.cloud.mybatisplus.demo.biz.controller;


import com.superm.easy.cloud.mybatisplus.demo.biz.entity.DeviceInfo;
import com.superm.easy.cloud.mybatisplus.demo.biz.service.IDeviceInfoService;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chao.Ma
 * @since 2019-05-14
 */
@Controller
@RequestMapping("/biz/deviceInfo")
public class DeviceInfoController {
    @Resource
    private IDeviceInfoService deviceInfoService;

    @ResponseBody
    @RequestMapping("/all")
    public String listAll() {
        List<DeviceInfo> list = deviceInfoService.list();
        return ArrayUtils.toString(list.toArray());
    }
}


package com.superm.easy.cloud.commons.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: easy-cloud
 * @description: 正则工具类
 * @author: Chao.Ma
 * @create: 2019-05-15 11:21
 **/
public class RegexUtil {

    /**
     * @description: 根据正则表达式校验参数
     * @param: [params, regex]
     * @return: boolean
     * @author: Chao.Ma
     * @date: 2019-05-15
     **/ 
    public static boolean checkObj(String params, String regex){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(params);
        return m.matches();
    }
}

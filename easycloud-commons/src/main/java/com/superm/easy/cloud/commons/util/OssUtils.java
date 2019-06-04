package com.superm.easy.cloud.commons.util;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-05-28 16:08
 **/
public class OssUtils {
    public static String removePreSignedPart(String video_urls) {
        if (video_urls == null) {
            return null;
        }
        int queryIndex = video_urls.indexOf('?');
        if (queryIndex == -1) {
            return video_urls;
        }
        return video_urls.substring(0, queryIndex);
    }
}

package com.superm.easy.cloud.provider.entity;

import lombok.*;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-15 13:54
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String name;
    private int age;
    private String sex;
}

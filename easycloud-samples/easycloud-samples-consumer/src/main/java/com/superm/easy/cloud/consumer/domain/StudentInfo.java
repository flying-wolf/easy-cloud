package com.superm.easy.cloud.consumer.domain;

import lombok.*;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-04-15 14:26
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfo {
    private String name;
    private String sex;
    private int age;
}

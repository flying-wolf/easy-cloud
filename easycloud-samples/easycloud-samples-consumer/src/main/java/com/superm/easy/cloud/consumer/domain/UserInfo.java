package com.superm.easy.cloud.consumer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Setter
@Getter
@ToString
public class UserInfo implements Serializable {

    private String name;
    private Short age;


}

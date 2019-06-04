package com.superm.easy.cloud.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.superm.easy.cloud.commons.constant.MessageConstants;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ListResp<T> implements Serializable {
    private static final long serialVersionUID = 1535276319736658077L;
    /**
     * 响应代码
     */
    protected String code;

    /**
     * 响应信息
     */
    protected String message;

    /**
     * 响应数据
     */
    protected List<T> data;

    /**
     * 响应时间
     */
    protected String timestamp;
    /**
     * 总记录数
     */
    private int total;
    /**
     * 当前页
     */
    @JsonProperty("page_no")
    private int pageNo;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 下条记录索引
     */
    private Object next;

    public static ListResp error(String code, String message) {
        return new ListRespBuilder<>().code(code).message(message).build();
    }

    public static ListResp empty() {
        return new ListRespBuilder<>().code(MessageConstants.V2_SUCCESS_CODE).message("").data(new ArrayList<>())
            .build();
    }
}

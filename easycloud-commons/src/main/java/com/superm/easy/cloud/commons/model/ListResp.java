package com.superm.easy.cloud.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.superm.easy.cloud.commons.enums.ResponseMsg;
import com.superm.easy.cloud.commons.exception.IMessage;
import com.superm.easy.cloud.commons.util.StringUtils;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("rawtypes")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@SuperBuilder(toBuilder = true)
public class ListResp<T> extends Resp<List<T>> implements Serializable {
    private static final long serialVersionUID = 1535276319736658077L;

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

    /*public static ListResp empty() {
        return new ListRespBuilder<>().code(MessageConstants.V2_SUCCESS_CODE).message("").data(new ArrayList<>())
            .build();
    }*/

    public ListResp setResult(List<T> datas) {
        this.data = datas;
        return this;
    }

    public static ListResp success() {
        return create(ResponseMsg.SUCCESS);
    }

    public static ListResp failure() {
        return create(ResponseMsg.CREATE_FAIL);
    }

    public static ListResp error() {
        return create(ResponseMsg.SERVER_ERROR);
    }

    public static ListResp create(IMessage msg) {
        return create(msg.getCode(), msg.getMessage());
    }

    public static ListResp create(IMessage msg, Object... params) {
        return create(msg.getCode(), msg.getMessage(params));
    }

    public static ListResp create(String code) {
        return create(code, StringUtils.EMPTY);
    }

    public static ListResp create(String code, String msg) {
        ListResp<Object> listResps = new ListResp<>();
        listResps.toBuilder(code, msg);
        return listResps;
    }


    public static void main(String[] args) {
    }

}

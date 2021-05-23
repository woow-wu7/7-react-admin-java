package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AjaxResponseBean {
    public boolean isOk;
    public int code;
    public String message;
    public Object data;

    // 成功 - 无数据
    // 请求成功的响应，返回值不带查询数据，( 用于添加，删除，修改 )
    public AjaxResponseBean success() {
        AjaxResponseBean ajaxResponseBean = new AjaxResponseBean();
        AjaxResponseBean.builder()
                .isOk(true)
                .code(200)
                .message("请求成功")
                .build();
        return ajaxResponseBean;
    }


    // 成功 - 带数据
    // 请求成功的响应，返回值带查询数据，( 用于查询 )
    public static AjaxResponseBean success(Object obj) {
        AjaxResponseBean ajaxResponse = new AjaxResponseBean();
        AjaxResponseBean.builder()
                .isOk(true)
                .code(200)
                .message("请求成功")
                .data(obj)
                .build();
        return ajaxResponse;
    }

    // 失败
    public static AjaxResponseBean error(CustomExceptionBean customExceptionBean) {
        AjaxResponseBean ajaxResponse = new AjaxResponseBean();
        AjaxResponseBean.builder()
                .isOk(false)
                .code(customExceptionBean.getCode())
                .message(customExceptionBean.getMessage())
                .build();
        return ajaxResponse;
    }
}

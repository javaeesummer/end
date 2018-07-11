package com.rev.exception;

import java.io.Serializable;

/**
 * @Author 大闲人柴毛毛
 * @Date 2017/10/27 下午10:37
 * 通用业务异常（由异常状态码区分不同的业务异常）
 */
public class CommonBizException extends RuntimeException implements Serializable {
    private com.rev.exception.ExpCodeEnum codeEnum;

    public CommonBizException(com.rev.exception.ExpCodeEnum codeEnum){
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }

    public CommonBizException(){}

    public com.rev.exception.ExpCodeEnum getCodeEnum() {
        return codeEnum;
    }
}

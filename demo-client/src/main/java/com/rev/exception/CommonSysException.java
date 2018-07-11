package com.rev.exception;

import java.io.Serializable;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/6 下午2:11
 *
 * @description 通用系统异常
 */
public class CommonSysException extends RuntimeException implements Serializable {

    private com.rev.exception.ExpCodeEnum codeEnum;

    public CommonSysException(com.rev.exception.ExpCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }

    public CommonSysException() {

    }
}

package com.rev.revfile.result;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private boolean isSuccess;
    private String message;
    private T data;


}

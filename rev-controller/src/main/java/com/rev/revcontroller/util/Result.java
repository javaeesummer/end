package com.rev.revcontroller.util;


import java.util.Objects;

/**
 * @author: yuantao
 * @Date: 2018/4/20
 * @Description:
 */
public class Result<T> {

    private final static Result<?> EMPTY = new Result<>();

    private T data;

    /**
     * 错误信息
     */
    private String msg;
    /**
     * 状态 1成功 其它失败，失败需要返回msg
     */
    private int state;

    /**
     * 是否跳转
     */
    private boolean is_redirect = false;

    /**
     * 跳转地址
     */
    private String redirect_url;

    /**
     * token
     */
    private String token;

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public int getState() {
        return state;
    }

    public boolean isIs_redirect() {
        return is_redirect;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public String getToken() {
        return token;
    }

    private Result() {
        this.data = null;
    }

    private Result(String message, int state) {
        this.msg = message;
        this.state = state;
    }

    private Result(T data, int state) {
        this.data = data;
        this.state = state;
    }

    /**
     *
     * 功能描述: 创建一个空Result类
     * @auther: yuantao
     * @date: 2018/4/21
     */
    public static <T> Result<T> empty() {
        @SuppressWarnings("unchecked")
        Result<T> t = (Result<T>) EMPTY;
        return t;
    }

    /**
     *
     * 功能描述: 生成一个成功状态Result类
     * @auther: yuantao
     * @param: Data
     * @return: Result<T>
     * @date: 2018/4/21
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data, 1);
    }

    /**
     *
     * 功能描述: 生成一个成功状态Result类
     * @auther: yuantao
     * @param: 返回的错误信息
     * @return: Result<T>
     * @date: 2018/4/21
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(message, 0);
    }

    /**
     *
     * 功能描述: 设置跳转地址
     * @auther: yuantao
     * @param: 跳转地址
     * @return: Result<T>
     * @date: 2018/4/21
     */
    public <T> Result<T> redirect(String url) {
        this.is_redirect = true;
        this.redirect_url = url;
        return (Result<T>) this;
    }

    /**
     *
     * 功能描述: 设置失败状态跳转地址
     * @auther: yuantao
     * @param: 跳转地址
     * @return: Result<T>
     * @date: 2018/4/21
     */
    public <T> Result<T> orFailRedirect(String url) {
        if (state == 1) {
            return (Result<T>) this;
        }
        this.is_redirect = true;
        this.redirect_url = url;
        return (Result<T>) this;
    }

    /**
     *
     * 功能描述: 判断是否传入值是否为空,非空则返回值，为空则返回失败信息
     * @auther: yuantao
     * @param: 返回的错误信息
     * @return: Result<T>
     * @date: 2018/4/21
     */
    public <T> Result<T> orFail(String message) {
        if (null != data) {
            return (Result<T>) this;
        } else {
            this.msg = message;
            this.state = 0;
        }
        return (Result<T>) this;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return data != null
                ? String.format("result[%s]", data)
                : "result.empty";
    }
}
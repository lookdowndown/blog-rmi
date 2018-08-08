package com.xiexiaoyuan.blog.rmi.server;

/**
 * Created by xiaoyuan on 2018/8/2
 */
public interface Task<T> {

    T execute();
}

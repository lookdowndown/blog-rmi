package com.xiexiaoyuan.blog.rmi.client;

import com.xiexiaoyuan.blog.rmi.server.Task;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by xiaoyuan on 2018/8/8
 */
public class Pi implements Task<Integer>, Serializable {

    @Override
    public Integer execute() {
        return new Random().nextInt();
    }
}

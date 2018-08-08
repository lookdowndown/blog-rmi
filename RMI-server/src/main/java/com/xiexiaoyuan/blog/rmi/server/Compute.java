package com.xiexiaoyuan.blog.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xiaoyuan on 2018/8/2
 */
public interface Compute extends Remote {

    <T> T executeTask(Task<T> task) throws RemoteException;
}

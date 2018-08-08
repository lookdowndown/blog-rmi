package com.xiexiaoyuan.blog.rmi.client;

import com.xiexiaoyuan.blog.rmi.server.Compute;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by xiaoyuan on 2018/8/8
 */
public class ComputePi {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        Registry registry = LocateRegistry.getRegistry();
        Compute compute = (Compute) registry.lookup("compute");
        Pi pi = new Pi();
        int result = compute.executeTask(pi);
        System.out.println(result);
    }
}

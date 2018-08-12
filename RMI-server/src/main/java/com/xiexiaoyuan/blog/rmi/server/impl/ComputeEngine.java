package com.xiexiaoyuan.blog.rmi.server.impl;

import com.xiexiaoyuan.blog.rmi.server.Compute;
import com.xiexiaoyuan.blog.rmi.server.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by xiaoyuan on 2018/8/2
 */
public class ComputeEngine implements Compute {

    @Override
    public <T> T executeTask(Task<T> task) throws RemoteException {
        return task.execute();
    }

    public static void main(String[] args) throws RemoteException, InterruptedException {
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
        Compute compute = new ComputeEngine();
        Compute stub = (Compute) UnicastRemoteObject.exportObject(compute, 0);

        Registry registry = LocateRegistry.getRegistry();
        registry.rebind("compute", stub);
        while (true) {
            Thread.sleep(5*1000);
            System.out.println("sleep 5s");
        }
    }
}

package com.lwl.thrift;

import org.apache.thrift.TException;

public class JazzClientImpl implements JazzClient.Iface{
    @Override
    public boolean exists(String path) throws TException {
        System.out.println("哈哈哈哈拿到的path:" + path);
        return false;
    }

    @Override
    public String shit(boolean success) throws TException {
        return null;
    }

    @Override
    public ShitPO getShit(int id, ShitPO shitPO) throws TException {
        System.out.println("接收到getShit方法调用，id:" + id + " shitPO:" + shitPO);
        shitPO.setAge(id);
        shitPO.setDead(true);
        return shitPO;
    }
}
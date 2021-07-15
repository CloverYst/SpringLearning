package org.example.service.impl;

import org.example.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl(){
        System.out.println("无参方法被执行了");
    }
    @Override
    public void doSome() {
        System.out.println("执行了业务方法doSome");
    }
}

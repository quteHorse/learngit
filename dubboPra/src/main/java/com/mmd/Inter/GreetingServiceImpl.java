package com.mmd.Inter;

/**
 * @author nantian
 * @date 2022-06-29 9:07
 */
public class GreetingServiceImpl implements GreetingService{
    @Override
    public String sayHi(String name) {
        return "hi,"+name;
    }
}

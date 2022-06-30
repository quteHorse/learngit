package com.mmd.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author nantian
 * @date 2022-06-02 14:36
 */
@RestController
public class NginxExample {

    private static final Logger log = LogManager.getLogger(NginxExample.class);

    @RequestMapping("/test1/sayHello")
    public String hello(){
        return "hello,world";
    }

    @RequestMapping("/test2/paramter")
    public String exam1(String name){
        JSONObject json = new JSONObject();
        try {
            json.put("name",name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    @RequestMapping("/test2/passnow")
    public void exam2(){
      log.info("调用了exam2方法");
    }
}

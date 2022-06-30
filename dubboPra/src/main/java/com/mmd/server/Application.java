package com.mmd.server;

import com.mmd.Inter.GreetingService;
import com.mmd.Inter.GreetingServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

/**
 * @author nantian
 * @date 2022-06-29 9:12
 */
public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address","127.0.0.1");

    public static void main(String[] args) throws InterruptedException {
        ServiceConfig<GreetingService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://"+zookeeperHost+":2181"));
        service.setInterface(GreetingService.class);
        service.setRef(new GreetingServiceImpl());
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}

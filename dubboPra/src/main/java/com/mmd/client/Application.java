package com.mmd.client;

import com.mmd.Inter.GreetingService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * @author nantian
 * @date 2022-06-29 9:24
 */
public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address","127.0.0.1");

    public static void main(String[] args) {
        ReferenceConfig<GreetingService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://"+zookeeperHost+":2181"));
        reference.setInterface(GreetingService.class);
        GreetingService service = reference.get();
        String message = service.sayHi("dubbo");
        System.out.println(message);
    }
}

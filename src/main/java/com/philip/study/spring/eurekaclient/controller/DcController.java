package com.philip.study.spring.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * Created by philipl on 2018/11/25.
 */
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;


    @GetMapping("/dc")
    public String dc(@RequestParam String count) {
        String services = "Services: " + discoveryClient.getServices();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        services = "instance[1111]----->"+count+"from eureka-client 2, at "+ts;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(services);
        return services;
    }


}

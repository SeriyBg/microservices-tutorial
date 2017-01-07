package com.micro.tutorial.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class SencenceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return
                getWord("MICROTUTORIAL-EUREKA-CLIENT-SUBJECT") + " "
                        + getWord("MICROTUTORIAL-EUREKA-CLIENT-VERB") + " "
                        + getWord("MICROTUTORIAL-EUREKA-CLIENT-ARTICLE") + " "
                        + getWord("MICROTUTORIAL-EUREKA-CLIENT-ADJECTIVE") + " "
                        + getWord("MICROTUTORIAL-EUREKA-CLIENT-NOUN") + "."
                ;
    }

    public String getWord(String service) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(service);
        URI uri = serviceInstance.getUri();
        if (uri !=null ) {
            return (new RestTemplate()).getForObject(uri,String.class);
        }
        return null;
    }
}

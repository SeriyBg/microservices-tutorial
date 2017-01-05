package com.micro.tutorial.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class LukyWordController {

    @Value("${lucky-word}")
    private String luckyWord;

    @PostConstruct
    public void init(){
        System.out.println(luckyWord);
    }

    @RequestMapping("/lucky-word")
    public String showLuckyWord() {
        return "The lucky word is: " + luckyWord;
    }
}

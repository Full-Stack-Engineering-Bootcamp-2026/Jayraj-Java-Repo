package com.app.componet;

import org.springframework.stereotype.Component;

import com.app.config.CustomeBean;
import com.app.service.GreetingService;

import jakarta.annotation.PostConstruct;

@Component
public class AppRunner {

    private final GreetingService greetingService;
    private final CustomeBean customBean;

    // Constructor Injection
    public AppRunner(GreetingService greetingService, CustomeBean customBean) {
        this.greetingService = greetingService;
        this.customBean = customBean;
    }

    @PostConstruct
    public void run() {
        System.out.println("=== APPLICATION STARTED ===");
        System.out.println(greetingService.getMessage());
        System.out.println(customBean.showMessage());
    }
}
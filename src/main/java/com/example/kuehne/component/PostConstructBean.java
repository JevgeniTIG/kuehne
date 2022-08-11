package com.example.kuehne.component;

import com.example.kuehne.service.InitialLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PostConstructBean {

    @Autowired
    private InitialLoaderService initialLoaderService;


    @EventListener
    public void onAppEvent(ContextRefreshedEvent event) {
        initialLoaderService.loadData();
    }
}

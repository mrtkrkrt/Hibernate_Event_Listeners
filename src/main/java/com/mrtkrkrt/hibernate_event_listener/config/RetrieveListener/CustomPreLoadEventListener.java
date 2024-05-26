package com.mrtkrkrt.hibernate_event_listener.config.RetrieveListener;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PreLoadEvent;
import org.hibernate.event.spi.PreLoadEventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomPreLoadEventListener implements PreLoadEventListener {
    @Override
    public void onPreLoad(PreLoadEvent preLoadEvent) {
        log.info("PreLoadEventListener.onPreLoad with event: {}", preLoadEvent.getEntity().toString());
    }
}

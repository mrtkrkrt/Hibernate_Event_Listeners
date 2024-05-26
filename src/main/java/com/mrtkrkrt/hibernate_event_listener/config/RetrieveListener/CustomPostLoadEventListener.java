package com.mrtkrkrt.hibernate_event_listener.config.RetrieveListener;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomPostLoadEventListener implements PostLoadEventListener {
    @Override
    public void onPostLoad(PostLoadEvent postLoadEvent) {
        log.info("PostLoadEventListener.onPostLoad with event: {}", postLoadEvent.getEntity().toString());
    }
}

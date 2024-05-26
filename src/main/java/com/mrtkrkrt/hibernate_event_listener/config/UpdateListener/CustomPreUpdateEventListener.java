package com.mrtkrkrt.hibernate_event_listener.config.UpdateListener;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomPreUpdateEventListener implements PreUpdateEventListener {
    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        log.info("PreUpdateEventListener.onPreUpdate with event: {}", preUpdateEvent.getEntity().toString());
        return false;
    }
}

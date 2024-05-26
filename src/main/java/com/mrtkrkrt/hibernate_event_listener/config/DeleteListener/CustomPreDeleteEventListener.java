package com.mrtkrkrt.hibernate_event_listener.config.DeleteListener;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.event.spi.PreDeleteEventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomPreDeleteEventListener implements PreDeleteEventListener {
    @Override
    public boolean onPreDelete(PreDeleteEvent preDeleteEvent) {
        log.info("PreDeleteEventListener.onPreDelete with event: {}", preDeleteEvent.getEntity().toString());
        return false;
    }
}

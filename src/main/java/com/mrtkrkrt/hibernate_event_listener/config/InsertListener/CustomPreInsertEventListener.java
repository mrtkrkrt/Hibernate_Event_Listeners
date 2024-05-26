package com.mrtkrkrt.hibernate_event_listener.config.InsertListener;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomPreInsertEventListener implements PreInsertEventListener {
    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        log.info("PreInsertEventListener.onPreInsert with event: {}", preInsertEvent.getEntity().toString());
        return false;
    }
}

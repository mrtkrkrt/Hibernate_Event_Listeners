package com.mrtkrkrt.hibernate_event_listener.config.UpdateListener;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomPostUpdateEventListener implements PostUpdateEventListener {
    @Override
    public void onPostUpdate(PostUpdateEvent postUpdateEvent) {
        log.info("PostUpdateEventListener.onPostUpdate with event: {}", postUpdateEvent.getEntity().toString());
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
        return false;
    }
}

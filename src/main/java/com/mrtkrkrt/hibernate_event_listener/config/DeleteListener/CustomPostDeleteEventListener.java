package com.mrtkrkrt.hibernate_event_listener.config.DeleteListener;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomPostDeleteEventListener implements PostDeleteEventListener {
    @Override
    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        log.info("PostDeleteEventListener.onPostDelete with event: {}", postDeleteEvent.getEntity().toString());
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
        return false;
    }
}

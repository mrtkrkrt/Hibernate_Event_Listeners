package com.mrtkrkrt.hibernate_event_listener.config;

import com.mrtkrkrt.hibernate_event_listener.config.DeleteListener.CustomPostDeleteEventListener;
import com.mrtkrkrt.hibernate_event_listener.config.DeleteListener.CustomPreDeleteEventListener;
import com.mrtkrkrt.hibernate_event_listener.config.InsertListener.CustomPostInsertEventListener;
import com.mrtkrkrt.hibernate_event_listener.config.InsertListener.CustomPreInsertEventListener;
import com.mrtkrkrt.hibernate_event_listener.config.RetrieveListener.CustomPostLoadEventListener;
import com.mrtkrkrt.hibernate_event_listener.config.RetrieveListener.CustomPreLoadEventListener;
import com.mrtkrkrt.hibernate_event_listener.config.UpdateListener.CustomPostUpdateEventListener;
import com.mrtkrkrt.hibernate_event_listener.config.UpdateListener.CustomPreUpdateEventListener;
import jakarta.persistence.EntityManagerFactory;
import lombok.NonNull;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomrBeanPostProcessor implements BeanPostProcessor {

    private final CustomPreInsertEventListener customPreInsertEventListener;
    private final CustomPostInsertEventListener customPostInsertEventListener;
    private final CustomPreDeleteEventListener customPreDeleteEventListener;
    private final CustomPostDeleteEventListener customPostDeleteEventListener;
    private final CustomPreLoadEventListener customPreLoadEventListener;
    private final CustomPostLoadEventListener customPostLoadEventListener;
    private final CustomPreUpdateEventListener customPreUpdateEventListener;
    private final CustomPostUpdateEventListener customPostUpdateEventListener;

    public CustomrBeanPostProcessor(CustomPreInsertEventListener customPreInsertEventListener, CustomPostInsertEventListener customPostInsertEventListener, CustomPreDeleteEventListener customPreDeleteEventListener, CustomPostDeleteEventListener customPostDeleteEventListener, CustomPreLoadEventListener customPreLoadEventListener, CustomPostLoadEventListener customPostLoadEventListener, CustomPreUpdateEventListener customPreUpdateEventListener, CustomPostUpdateEventListener customPostUpdateEventListener) {
        this.customPreInsertEventListener = customPreInsertEventListener;
        this.customPostInsertEventListener = customPostInsertEventListener;
        this.customPreDeleteEventListener = customPreDeleteEventListener;
        this.customPostDeleteEventListener = customPostDeleteEventListener;
        this.customPreLoadEventListener = customPreLoadEventListener;
        this.customPostLoadEventListener = customPostLoadEventListener;
        this.customPreUpdateEventListener = customPreUpdateEventListener;
        this.customPostUpdateEventListener = customPostUpdateEventListener;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) {
        if (bean instanceof EntityManagerFactory entityManagerFactory) {
            SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
            EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
            registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(customPreInsertEventListener);
            registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(customPostInsertEventListener);
            registry.getEventListenerGroup(EventType.PRE_DELETE).appendListener(customPreDeleteEventListener);
            registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(customPostDeleteEventListener);
            registry.getEventListenerGroup(EventType.PRE_LOAD).appendListener(customPreLoadEventListener);
            registry.getEventListenerGroup(EventType.POST_LOAD).appendListener(customPostLoadEventListener);
            registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(customPreUpdateEventListener);
            registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(customPostUpdateEventListener);
        }
        return bean;
    }
}

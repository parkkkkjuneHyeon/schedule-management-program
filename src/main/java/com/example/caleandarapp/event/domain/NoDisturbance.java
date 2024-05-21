package com.example.caleandarapp.event.domain;

import com.example.caleandarapp.event.type.EventType;
import com.example.caleandarapp.event.updateDto.AbstractAuditableEvent;

import java.time.ZonedDateTime;

import static com.example.caleandarapp.event.type.EventType.NO_DISTURBANCE;

public class NoDisturbance extends AbstractEvent {
    protected NoDisturbance(int id,
                            String title,
                            ZonedDateTime startAt,
                            ZonedDateTime endAt
    ) {
        super(id, title, startAt, endAt);
    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }

    @Override
    public void print() {
        System.out.println("[방해 금지]");
    }

    @Override
    public boolean support(EventType type) {
        return type == NO_DISTURBANCE;
    }
}

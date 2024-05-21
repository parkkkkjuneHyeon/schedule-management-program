package com.example.caleandarapp.event.domain;

import com.example.caleandarapp.event.type.EventType;
import com.example.caleandarapp.event.updateDto.AbstractAuditableEvent;

import java.time.ZonedDateTime;

import static com.example.caleandarapp.event.type.EventType.OUT_OF_OFFICE;

public class OutOfOffice extends AbstractEvent {

    protected OutOfOffice(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }

    @Override
    public void print() {
        System.out.println("[근무 중이 아님]");
    }

    @Override
    public boolean support(EventType type) {
        return type == OUT_OF_OFFICE;
    }
}

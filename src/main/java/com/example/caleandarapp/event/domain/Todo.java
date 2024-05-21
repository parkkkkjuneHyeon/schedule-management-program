package com.example.caleandarapp.event.domain;

import com.example.caleandarapp.event.type.EventType;
import com.example.caleandarapp.event.updateDto.AbstractAuditableEvent;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

import static com.example.caleandarapp.event.type.EventType.TO_DO;

@Getter
@Setter
public class Todo extends AbstractEvent {

    private String description;

    public Todo(
            int id,
            String title,
            ZonedDateTime startAt,
            ZonedDateTime endAt,
            String description
    ) {
        super(id, title, startAt, endAt);

        this.description = description;
    }

    @Override
    public void print() {
        System.out.printf("[할 일] %s : %s%n", getTitle(), description);
    }

    @Override
    public boolean support(EventType type) {
        return type == TO_DO;
    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }
}

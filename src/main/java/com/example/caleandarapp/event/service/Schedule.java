package com.example.caleandarapp.event.service;

import com.example.caleandarapp.Exception.InvalidEventException;
import com.example.caleandarapp.event.domain.AbstractEvent;
import com.example.caleandarapp.event.domain.Event;
import com.example.caleandarapp.event.type.EventType;
import com.example.caleandarapp.event.updateDto.UpdateMeeting;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<AbstractEvent> events = new ArrayList<>();

    public void add(AbstractEvent event) {
        if(hasScheduleConflictWith(event))
            throw new InvalidEventException("같은 시간대에 스케줄이 있습니다.");
        this.events.add(event);
    }

    public void updateSchedule(int id, UpdateMeeting updateMeeting) {
        events.stream().filter(s -> id == s.getId())
                .forEach(s -> s.validateAndUpdate(updateMeeting));
    }

    public void deleteSchedule(int id) {
        events.stream()
                .filter(event -> id == event.getId())
                .forEach(event -> event.delete(true));
    }

    public void printAll() {
        this.events.stream()
                .filter(event -> !event.isDeletedYn())
                .forEach(Event::print);
    }

    public void printBy(EventType type) {
        this.events
                .stream()
                .filter(event -> !event.isDeletedYn() && event.support(type))
                .forEach(Event::print);
    }

    private boolean hasScheduleConflictWith(AbstractEvent event) {
        return events.stream()
                .anyMatch(e ->
                        (event.getStartAt().isBefore(e.getEndAt()) &&
                                event.getStartAt().isAfter(e.getStartAt())
                        || event.getEndAt().isAfter(e.getStartAt()) &&
                                event.getEndAt().isBefore(e.getEndAt())
                        ));
    }


}

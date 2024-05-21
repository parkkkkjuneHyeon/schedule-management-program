package com.example.caleandarapp.event.domain;

import com.example.caleandarapp.event.type.EventType;
import com.example.caleandarapp.event.updateDto.AbstractAuditableEvent;
import com.example.caleandarapp.event.updateDto.UpdateMeeting;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Set;

import static com.example.caleandarapp.event.type.EventType.MEETING;

@Setter
@Getter
public class Meeting extends AbstractEvent{

    private Set<String> participants;
    private String meetingRoom;
    private String agenda;  //내용


    public Meeting(
            int id,
            String title,
            ZonedDateTime startAt,
            ZonedDateTime endAt) {

        super(id, title, startAt, endAt);
    }

    @Override
    protected void update(AbstractAuditableEvent update) {
        UpdateMeeting updateMeeting = (UpdateMeeting) update;
        this.participants = updateMeeting.getParticipants();
        this.meetingRoom = updateMeeting.getMeetingRoom();
        this.agenda = updateMeeting.getAgenda();
    }

    @Override
    public void print() {
        System.out.printf("[회의] %s : %s%n", getTitle(), this.agenda);
    }

    @Override
    public boolean support(EventType type) {
        return type == MEETING;
    }
}

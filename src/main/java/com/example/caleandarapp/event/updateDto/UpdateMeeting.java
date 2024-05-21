package com.example.caleandarapp.event.updateDto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Set;

@Setter
@Getter
public class UpdateMeeting extends AbstractAuditableEvent{
    private Set<String> participants;
    private String meetingRoom;
    private String agenda;  //내용


    public UpdateMeeting(
            String title,
            ZonedDateTime startAt,
            ZonedDateTime endAt,
            Set<String> participants,
            String meetingRoom,
            String agenda
    ) {
        super(title, startAt, endAt);
        this.participants = participants;
        this.meetingRoom = meetingRoom;
        this.agenda = agenda;
    }



}

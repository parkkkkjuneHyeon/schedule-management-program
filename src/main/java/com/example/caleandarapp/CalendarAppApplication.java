package com.example.caleandarapp;

import com.example.caleandarapp.event.domain.Meeting;
import com.example.caleandarapp.event.service.Schedule;
import com.example.caleandarapp.event.updateDto.UpdateMeeting;
import com.example.caleandarapp.reader.EventCSVReader;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.example.caleandarapp.event.type.EventType.TO_DO;

public class CalendarAppApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();
        EventCSVReader eventCSVReader = new EventCSVReader();
        String meetingCsvPath = "/data/meeting.csv";

        //add
        List<Meeting> meetingList = eventCSVReader.readMeetings(meetingCsvPath);
        meetingList.forEach(schedule::add);
        schedule.printAll();

        //update
        System.out.println("수정 후........");
        UpdateMeeting updateMeeting = new UpdateMeeting(
                "update title",
                ZonedDateTime.of(
                        LocalDateTime.parse("2024-06-25 12:50:00",
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                        ),
                        ZoneId.of("Asia/Seoul")
                ),
                ZonedDateTime.of(
                        LocalDateTime.parse("2024-06-26 12:50:00",
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                        ),
                        ZoneId.of("Asia/Seoul")
                ),
                new HashSet<>(Arrays.asList("A,B")),
                "804호",
                "수정"
                );
        schedule.updateSchedule(1, updateMeeting);
        schedule.printAll();

        //delete
        schedule.deleteSchedule(1);
        System.out.println("삭제 후........");
        schedule.printAll();


        schedule.printBy(TO_DO);

    }

}

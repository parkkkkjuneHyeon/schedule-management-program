package com.example.caleandarapp.reader;

import com.example.caleandarapp.event.domain.Meeting;
import com.opencsv.CSVReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class EventCSVReader {
    public List<Meeting> readMeetings(String path) throws IOException{
        List<Meeting> result = new ArrayList<>();
        List<String[]> read = readAll(path);
        int readLen = read.size();
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (int i=1; i<readLen; i++) {
            String[] meeting = read.get(i);
            Meeting meetings = new Meeting(Integer.parseInt(meeting[0]),
                    meeting[2],
                    ZonedDateTime.of(LocalDateTime
                                .parse(meeting[6], formatter),
                            ZoneId.of("Asia/Seoul")
                    ),
                    ZonedDateTime.of(LocalDateTime
                                    .parse(meeting[7], formatter),
                            ZoneId.of("Asia/Seoul")
                    )
            );

//            meetings.setParticipants(
//                            Arrays.stream(meeting[3].split(","))
//                                    .collect(Collectors.toCollection(HashSet::new))
//                    );
            meetings.setParticipants(
                    new HashSet<>(Arrays
                            .asList(meeting[3].split(","))
                    )
            );
            meetings.setMeetingRoom(meeting[4]);
            meetings.setAgenda(meeting[5]);

            result.add(meetings);
        }


        return result;
    }

    private List<String[]> readAll(String path) throws IOException {

        InputStream in =
                getClass().getResourceAsStream(path);

        InputStreamReader reader =
                new InputStreamReader(in, StandardCharsets.UTF_8);

        CSVReader csvReader = new CSVReader(reader);
        return csvReader.readAll();
    }

}

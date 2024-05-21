package com.example.caleandarapp.event.domain;

import com.example.caleandarapp.event.type.EventType;

public interface Event {
    void print();

    boolean support(EventType type);


}

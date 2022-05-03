package com.rusetskiy.boxOffice.MyTypes;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MyJson implements Serializable{
    private Map<String, String> seats = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getSeats() {
        return seats;
    }

    @JsonAnySetter
    public void add(String key, String value) {
        seats.put(key, value);
    }

    @Override
    public String toString() {
        return "MyJson{" +
                "seats=" + seats +
                '}';
    }
}

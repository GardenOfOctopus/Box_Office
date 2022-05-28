package com.rusetskiy.boxOffice.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "performances")
public class Performance {

    public Performance(){

    }

    public Performance(int th_id_, String name_, String description_, Time length_, String image_, String actors_, String producers_){
        th_id = th_id_;
        perf_name = name_;
        description = description_;
        perf_length = length_;
        perf_image_url = image_;
        actors = actors_;
        producer = producers_;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @NonNull
    private int perf_id;

    @Getter
    @Setter
    @NonNull
    private int th_id;

    @Getter
    @Setter
    @NonNull
    private String perf_name;

    @Getter
    @Setter
    @NonNull
    private String description;

    @Getter
    @Setter
    @NonNull
    private Time perf_length;

    @Getter
    @Setter
    private String perf_image_url;

    @Getter
    @Setter
    @NonNull
    private String actors;

    @Getter
    @Setter
    @NonNull
    private String producer;

    @Override
    public String toString() {
        return "Performance{" +
                "perf_id=" + perf_id +
                ", th_id=" + th_id +
                ", name='" + perf_name + '\'' +
                ", description='" + description + '\'' +
                ", length=" + perf_length +
                ", image=" + perf_image_url +
                ", actors='" + actors + '\'' +
                ", producers='" + producer + '\'' +
                '}';
    }
}

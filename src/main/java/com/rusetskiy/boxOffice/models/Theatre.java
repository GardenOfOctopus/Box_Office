package com.rusetskiy.boxOffice.models;

import com.rusetskiy.boxOffice.MyTypes.MyJson;
import com.rusetskiy.boxOffice.MyTypes.MyJsonType;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "theatres")
@TypeDef(name = "JsonSeatsInfType", typeClass = MyJsonType.class)
public class Theatre{

    public Theatre(){

    }

    public Theatre(String th_name_, String address_, String producers_, String actors_ ,MyJson seats_inf_ ,String th_image_url_, String seats_map_image_url_, String description_){
        th_name = th_name_;
        address = address_;
        producers = producers_;
        actors = actors_;
        seats_inf = seats_inf_;
        th_image_url = th_image_url_;
        seats_map_image_url = seats_map_image_url_;
        description = description_;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @NonNull
    private int theatre_id;

    @Getter
    @Setter
    @NonNull
    private String th_name;

    @Getter
    @Setter
    @NonNull
    private String address;

    @Getter
    @Setter
    @NonNull
    private String producers;

    @Getter
    @Setter
    @NonNull
    private String actors;

    @Getter
    @Setter
    @Column(name = "seats_inf")
    @Type(type = "JsonSeatsInfType")
    @NonNull
    private MyJson seats_inf;

    @Getter
    @Setter
    @URL
    private String th_image_url;

    @Getter
    @Setter
    @URL
    private String seats_map_image_url;

    @Getter
    @Setter
    @NonNull
    private String description;

    @Override
    public String toString() {
        return "Theatre{" +
                "theatre_id=" + theatre_id +
                ", th_name='" + th_name + '\'' +
                ", address='" + address + '\'' +
                ", producers='" + producers + '\'' +
                ", actors='" + actors + '\'' +
                ", seats_inf=" + seats_inf +
                ", th_image_url='" + th_image_url + '\'' +
                ", seats_map_image_url='" + seats_map_image_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.rusetskiy.boxOffice.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    public Ticket(){

    }

    public Ticket(int ev_id_, int seat_id_, String seat_type_, String text_number_, boolean saled_){
        ev_id = ev_id_;
        seat_id = seat_id_;
        seat_type = seat_type_;
        seat_number = text_number_;
        saled = saled_;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @NonNull
    private int tick_id;

    @Getter
    @Setter
    @NonNull
    private int ev_id;

    @Getter
    @Setter
    @NonNull
    private int seat_id;

    @Getter
    @Setter
    @NonNull
    private String seat_type;

    @Getter
    @Setter
    @NonNull
    private String seat_number;

    @Getter
    @Setter
    @NonNull
    private boolean saled;

    @Override
    public String toString() {
        return "Ticket{" +
                "tick_id=" + tick_id +
                ", ev_id=" + ev_id +
                ", seat_id=" + seat_id +
                ", seat_type='" + seat_type + '\'' +
                ", text_number='" + seat_number + '\'' +
                ", saled=" + saled +
                '}';
    }
}

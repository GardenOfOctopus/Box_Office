package com.rusetskiy.boxOffice.models;

import com.rusetskiy.boxOffice.MyTypes.MyJson;
import com.rusetskiy.boxOffice.MyTypes.MyJsonType;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "events")
@TypeDef(name = "JsonRolesType", typeClass = MyJsonType.class)
public class Event {

    public Event(){

    }

    public Event(Date ev_date_, int perf_id_, MyJson roles_){
        ev_date = ev_date_;
        perf_id = perf_id_;
        roles_actors = roles_;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @NonNull
    private int ev_id;

    @Getter
    @Setter
    @NonNull
    private Date ev_date;

    @Getter
    @Setter
    @NonNull
    private int perf_id;

    @Getter
    @Setter
    @Type(type = "JsonRolesType")
    @NonNull
    private MyJson roles_actors;

    @Override
    public String toString() {
        return "Event{" +
                "ev_id=" + ev_id +
                ", ev_date=" + ev_date +
                ", perf_id=" + perf_id +
                ", roles=" + roles_actors +
                '}';
    }
}

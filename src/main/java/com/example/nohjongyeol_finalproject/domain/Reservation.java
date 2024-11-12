package com.example.nohjongyeol_finalproject.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private Long id;
    private String name;
    private User user;
    private Car car;
    private LocalDate date;
    private LocalTime time;

    public Reservation(Long id, String name, User user, Car car, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.car = car;
        this.date = date;
        this.time = time;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public User getUser() { return user; }
    public Car getCar() { return car; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
}

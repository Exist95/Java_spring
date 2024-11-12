package com.example.nohjongyeol_finalproject.dao;

import com.example.nohjongyeol_finalproject.domain.Car;
import com.example.nohjongyeol_finalproject.domain.Reservation;
import com.example.nohjongyeol_finalproject.domain.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDao {
    private static Reservation[] reservations = new Reservation[10];
    private static int count = 0;

    public Reservation registerReservation(String name, User user, Car car, LocalDate date, LocalTime time) {
        if (count >= 10) throw new IllegalArgumentException("예약은 최대 10개까지 등록할 수 있습니다.");
        Reservation reservation = new Reservation((long) (count + 1), name, user, car, date, time);
        reservations[count++] = reservation;
        return reservation;
    }

    public Reservation[] getAllReservations() {
        return reservations;
    }

    public Reservation getReservation(Long id) {
        for (Reservation reservation : reservations) {
            if (reservation != null && reservation.getId().equals(id)) {
                return reservation;
            }
        }
        throw new IllegalArgumentException("예약 ID가 존재하지 않습니다.");
    }
}

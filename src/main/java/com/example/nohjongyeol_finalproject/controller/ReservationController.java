package com.example.nohjongyeol_finalproject.controller;

import com.example.nohjongyeol_finalproject.dao.CarDao;
import com.example.nohjongyeol_finalproject.dao.ReservationDao;
import com.example.nohjongyeol_finalproject.dao.UserDao;
import com.example.nohjongyeol_finalproject.domain.Car;
import com.example.nohjongyeol_finalproject.domain.Reservation;
import com.example.nohjongyeol_finalproject.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationDao reservationDao = new ReservationDao();
    private final UserDao userDao = new UserDao();
    private final CarDao carDao = new CarDao();

    @PostMapping
    public ResponseEntity<Reservation> registerReservation(@RequestParam String name,
                                                           @RequestParam Long userId,
                                                           @RequestParam Long carId,
                                                           @RequestParam String date,
                                                           @RequestParam String time) {
        if (userId < 1 || userId > userDao.getAllUsers().length) {
            throw new IllegalArgumentException("유저 ID가 존재하지 않습니다.");
        }
        if (carId < 1 || carId > carDao.getAllCars().length) {
            throw new IllegalArgumentException("차량 ID가 존재하지 않습니다.");
        }

        User user = userDao.getAllUsers()[(int)(userId - 1)];
        Car car = carDao.getAllCars()[(int)(carId - 1)];
        LocalDate reservationDate = LocalDate.parse(date);
        LocalTime reservationTime = LocalTime.parse(time);

        Reservation reservation = reservationDao.registerReservation(name, user, car, reservationDate, reservationTime);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public ResponseEntity<Reservation[]> getAllReservations() {
        Reservation[] reservations = reservationDao.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/single")
    public ResponseEntity<Reservation> getReservation(@RequestParam Long id) {
        Reservation reservation = reservationDao.getReservation(id);
        return ResponseEntity.ok(reservation);
    }
}

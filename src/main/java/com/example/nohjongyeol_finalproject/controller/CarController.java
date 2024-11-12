package com.example.nohjongyeol_finalproject.controller;

import com.example.nohjongyeol_finalproject.dao.CarDao;
import com.example.nohjongyeol_finalproject.domain.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarDao carDao = new CarDao();

    @PostMapping
    public ResponseEntity<Car> registerCar(@RequestParam String name,
                                           @RequestParam double price,
                                           @RequestParam String owner,
                                           @RequestParam int year) {
        Car car = carDao.registerCar(name, price, owner, year);
        return ResponseEntity.ok(car);
    }

    @GetMapping
    public ResponseEntity<Car[]> getAllCars() {
        Car[] cars = carDao.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/last")
    public ResponseEntity<Car> getLastCar() {
        Car car = carDao.getLastCar();
        return ResponseEntity.ok(car);
    }
}

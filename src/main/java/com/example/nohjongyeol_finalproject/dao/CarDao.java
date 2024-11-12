package com.example.nohjongyeol_finalproject.dao;

import com.example.nohjongyeol_finalproject.domain.Car;

public class CarDao {
    private static Car[] cars = new Car[5];
    private static int count = 0;

    public Car registerCar(String name, double price, String owner, int year) {
        if (count >= 5) throw new IllegalArgumentException("차량은 최대 5대까지 등록할 수 있습니다.");
        Car car = new Car((long) (count + 1), name, price, owner, year);
        cars[count++] = car;
        return car;
    }

    public Car[] getAllCars() {
        return cars;
    }

    public Car getLastCar() {
        if (count == 0) throw new IllegalArgumentException("차량이 없습니다.");
        return cars[count - 1];
    }
}

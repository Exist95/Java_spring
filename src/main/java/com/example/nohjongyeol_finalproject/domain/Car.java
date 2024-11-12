package com.example.nohjongyeol_finalproject.domain;

public class Car {
    private Long id;
    private String name;
    private double price;
    private String owner;
    private int year;

    public Car(Long id, String name, double price, String owner, int year) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("차량 이름은 필수입니다.");
        if (price <= 0) throw new IllegalArgumentException("차량 가격은 0보다 커야 합니다.");
        if (owner == null || owner.trim().isEmpty()) throw new IllegalArgumentException("차량 소유자는 필수입니다.");
        if (year <= 1950) throw new IllegalArgumentException("차량 연식은 1950보다 커야 합니다.");
        this.id = id;
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.year = year;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getOwner() { return owner; }
    public int getYear() { return year; }
}

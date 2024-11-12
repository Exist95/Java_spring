package com.example.nohjongyeol_finalproject.domain;

public class User {
    private Long id;
    private String name;
    private String email;

    public User(Long id, String name, String email) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("유저 이름은 필수입니다.");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("유저 이메일은 필수입니다.");
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

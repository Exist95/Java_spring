package com.example.nohjongyeol_finalproject.dao;

import com.example.nohjongyeol_finalproject.domain.User;

public class UserDao {
    private static User[] users = new User[10];
    private static int count = 0;

    public User registerUser(String name, String email) {
        if (count >= 10) throw new IllegalArgumentException("유저는 최대 10명까지 등록할 수 있습니다.");
        User user = new User((long) (count + 1), name, email);
        users[count++] = user;
        return user;
    }

    public User[] getAllUsers() {
        return users;
    }

    public User updateUser(Long id, String name, String email) {
        for (int i = 0; i < count; i++) {
            if (users[i].getId().equals(id)) {
                users[i] = new User(id, name, email);
                return users[i];
            }
        }
        throw new IllegalArgumentException("업데이트 대상 유저가 존재하지 않습니다.");
    }
}
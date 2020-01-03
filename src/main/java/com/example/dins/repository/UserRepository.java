package com.example.dins.repository;

import com.example.dins.domain.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> getAll();
    User getById(int id);
    List<User> getByName(String name);
    boolean delete(int id);
}

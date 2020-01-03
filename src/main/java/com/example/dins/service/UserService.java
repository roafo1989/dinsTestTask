package com.example.dins.service;

import com.example.dins.domain.User;
import com.example.dins.repository.UserRepository;
import com.example.dins.util.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.example.dins.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User create(User user) {
        return repository.save(user);
    }

    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User getById(int id) throws NotFoundException {
        return repository.getById(id);
    }

    public List<User> getByName(String name) throws NotFoundException {
        return repository.getByName(name);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public User update(User user) throws NotFoundException {
        return repository.save(user);
    }
}
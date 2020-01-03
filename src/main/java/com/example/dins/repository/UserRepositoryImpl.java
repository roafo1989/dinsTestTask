package com.example.dins.repository;

import com.example.dins.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static Map<Integer, User> usersMap = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    {
        User user1 = new User("Dima","dima@mail.ru");
        save(user1);
        User user2 = new User("Max", "max@mail.ru");
        save(user2);
    }

    @Override
    public User save(User user) {
        if (user.isNew()) {
            System.out.println("service: user is new");
            user.setId(counter.incrementAndGet());
            usersMap.put(user.getId(), user);
            return user;
        }
        System.out.println("service: user is not new");
        return usersMap.computeIfPresent(user.getId(), (id, oldUser) -> user);
    }

    @Override
    public List<User> getAll() {
        return usersMap.values().stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public User getById(int id) {
        return usersMap.get(id);
    }

    @Override
    public List<User> getByName(String name) {
        List<User> userList = new ArrayList<>();
        userList.addAll(usersMap.values());
        List <User> result = new ArrayList<>();
        for(User u : userList){
            if(u.getName().equalsIgnoreCase(name) || u.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(u);
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        return usersMap.remove(id) != null;
    }
}

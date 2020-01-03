package com.example.dins.controller;

import com.example.dins.domain.User;
import com.example.dins.service.UserService;
import com.example.dins.util.Handlers.ApiResponse;
import com.example.dins.util.Handlers.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = UserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    static final String REST_URL = "/users";

    private UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<User>> getAll(){
        List<User> users = service.getAll();
        return new ApiResponse<>(HttpStatus.OK,users);
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getById(@PathVariable Integer id) throws EntityNotFoundException {
        User user = service.getById(id);
        if(user == null){
            throw new EntityNotFoundException(User.class,"id",id.toString());
        }
        return new ApiResponse<>(HttpStatus.OK,user);
    }

    @GetMapping("/by")
    public ApiResponse<List<User>> getByName(@RequestParam String name){
        List<User> users = service.getByName(name);
        return new ApiResponse<>(HttpStatus.OK,users);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<User> delete(@PathVariable Integer id) throws EntityNotFoundException {
        User user = service.getById(id);
        if(user == null){
            throw new EntityNotFoundException(User.class,"id",id.toString());
        } else {
            service.delete(id);
            return new ApiResponse<>(HttpStatus.NO_CONTENT,user);
        }
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<User> update(@RequestBody User user) {
        return new ApiResponse<>(HttpStatus.OK,service.update(user));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<User> create(@RequestBody User user) {
        return new ApiResponse<>(HttpStatus.CREATED, service.create(user));
    }
}

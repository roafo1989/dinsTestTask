package com.example.dins;

import com.example.dins.DinsApplication;
import com.example.dins.domain.User;

import com.example.dins.repository.NoteRepository;
import com.example.dins.repository.UserRepository;
import com.example.dins.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.example.dins.UserTestDate.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DinsApplication.class)
class UserControllerTest {
    @Autowired
    private UserService service;

    @Test
    void getAll() {
        List<User> users = service.getAll();
        assertMatch(users,USERS);
    }

    @Test
    void getById() {
        User user = service.getById(USER1_ID);
        Assert.assertEquals(USER1,user);
    }

    @Test
    void getByName() {
        List<User>users = service.getByName("Dima");
        assertMatch(users,USER1);
    }
    @Test
    void getByPartOfName() {
        List<User>users = service.getByName("ma");
        assertMatch(users,USER1,USER2);
    }

    @Test
    void delete() {
        service.delete(USER1_ID);
        List<User> users = service.getAll();
        Assert.assertEquals(1,users.size());
        Assert.assertEquals(USER2,users.iterator().next());
    }

    @Test
    void update() {
        User user = new User(USER1_ID,"Dimon","dimon-krasava@mail.ru");
        User updated = service.update(user);
        Assert.assertEquals(UPDATED.getName(),updated.getName());
        Assert.assertEquals(UPDATED.getEmail(),updated.getEmail());
        Assert.assertTrue(USER1_ID==updated.getId());
    }

    @Test
    void create() {
        User user = new User("createdUser","email@bk.ru");
        User created = service.create(user);
        Assert.assertEquals(CREATED.getName(),created.getName());
        Assert.assertEquals(CREATED.getEmail(),created.getEmail());
    }
}
package com.example.dins;

import com.example.dins.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTestDate {
    public static final int USER1_ID = 1;
    public static final int USER2_ID = 2;
    public static final int CREATED_ID = 3;

    public static final User USER1 = new User(USER1_ID,"Dima","dima@mail.ru");
    public static final User USER2 = new User(USER2_ID, "Max","max@mail.ru");
    public static final User CREATED = new User(CREATED_ID,"createdUser","email@bk.ru");
    public static final User UPDATED = new User(USER1_ID,"Dimon","dimon-krasava@mail.ru");


    public static final List<User> USERS = Arrays.asList(USER1,USER2);

    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingDefaultElementComparator().isEqualTo(expected);
    }
}

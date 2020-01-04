package com.example.dins;

import com.example.dins.domain.Note;
import com.example.dins.service.NoteService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.example.dins.NoteTestData.*;
import static com.example.dins.UserTestDate.*;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DinsApplication.class)
class NoteControllerTest {
    @Autowired
    private NoteService service;

    @Test
    void getAll() {
        List<Note> notes = service.getAll(USER1_ID);
        assertMatch(notes,NOTE_LIST);
    }

    @Test
    void getById() {
        Note note = service.getById(NOTE1_ID,USER1_ID);
        Assert.assertEquals(NOTE1,note);
    }

    @Test
    void getByNumber() {
        List<Note> notes = service.getByNumber("8800900",USER1_ID);
        assertMatch(notes,NOTE1);
    }

    @Test
    void delete() {
        service.delete(NOTE1_ID,USER1_ID);
        List<Note> notes = service.getAll(USER1_ID);
        Assert.assertEquals(1,notes.size());
        Assert.assertEquals(NOTE2,notes.iterator().next());
    }

    @Test
    void update() {
        Note note = new Note(NOTE4_ID,"mama Piter","81484384");
        Note updated = service.update(note,USER2_ID);
        Assert.assertEquals(NoteTestData.UPDATED,updated);
    }

    @Test
    void create() {
        Note note = new Note("created","123456");
        Note created = service.create(note,USER1_ID);
        Assert.assertEquals(NoteTestData.CREATED,created);
    }
}
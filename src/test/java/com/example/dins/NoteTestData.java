package com.example.dins;

import com.example.dins.domain.Note;
import com.example.dins.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.dins.UserTestDate.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NoteTestData {
    public static final int NOTE1_ID = 0;
    public static final int NOTE2_ID = 1;
    public static final int NOTE3_ID = 2;
    public static final int NOTE4_ID = 3;
    public static final int NOTE_CREATED_ID = 4;
    public static final Note NOTE1 = new Note(NOTE1_ID,"Oleg","8800900");
    public static final Note NOTE2 = new Note(NOTE2_ID,"Ivan","168413");
    public static final Note NOTE3 = new Note(NOTE3_ID,"dom","4184389");
    public static final Note NOTE4 = new Note(NOTE4_ID,"mama","81484384");
    public static final Note CREATED = new Note(NOTE_CREATED_ID,"created","123456");
    public static final Note UPDATED = new Note(NOTE4_ID,"mama Piter","81484384");
    public static final Map<Integer, Map<Integer,Note>> ALL_NOTES = new ConcurrentHashMap<>();
    public static final Map<Integer,Note> NOTES_1 = new ConcurrentHashMap<>();
    public static final Map<Integer,Note> NOTES_2 = new ConcurrentHashMap<>();
    public static final List<Note> NOTE_LIST = Arrays.asList(NOTE1,NOTE2);
    {
        NOTES_1.put(NOTE1_ID,NOTE1);
        NOTES_1.put(NOTE2_ID,NOTE2);
        NOTES_2.put(NOTE3_ID,NOTE3);
        NOTES_2.put(NOTE4_ID,NOTE4);

        ALL_NOTES.put(USER1_ID,NOTES_1);
        ALL_NOTES.put(USER2_ID,NOTES_2);
    }
    public static void assertMatch(Note actual, Note expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Note> actual, Note... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Note> actual, Iterable<Note> expected) {
        assertThat(actual).usingDefaultElementComparator().isEqualTo(expected);
    }
}

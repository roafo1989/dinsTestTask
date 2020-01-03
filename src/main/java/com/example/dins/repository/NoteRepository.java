package com.example.dins.repository;

import com.example.dins.domain.Note;

import java.util.List;

public interface NoteRepository {
    Note save(Note note, int userId);
    Note getById(Integer id, int userId);
    List<Note> getByNumber(String number, int userId);
    List<Note> getAll(Integer userId);
    boolean delete(Integer id, int userId);

}

package com.example.dins.service;

import com.example.dins.domain.Note;
import com.example.dins.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.dins.util.ValidationUtil.checkNotFound;
import static com.example.dins.util.ValidationUtil.checkNotFoundWithId;

@Service
public class NoteService {
    private final NoteRepository repository;
    @Autowired
    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Note create(Note note, int userId) {
        return repository.save(note,userId);
    }
    public Note update(Note note, int userId){
        return checkNotFoundWithId(repository.save(note,userId),note.getId());
    }
    public List<Note> getAll(Integer userId){
        return repository.getAll(userId);
    }
    public Note getById(Integer id, int userId){
        return checkNotFoundWithId(repository.getById(id, userId), id);
    }
    public List<Note> getByNumber(String number, Integer userId){
        return checkNotFound(repository.getByNumber(number, userId),"number="+number);
    }
    public void delete(int id, int userId){
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

}

package com.example.dins.repository;

import com.example.dins.domain.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class NoteRepositoryImpl implements NoteRepository {
    private Map<Integer, Map<Integer, Note>> userNoteMap = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    {
        Note note1 = new Note("Oleg","8800900");
        Note note2 = new Note("Ivan","168413");
        Note note3 = new Note("dom","4184389");
        Note note4 = new Note("mama","81484384");
        save(note1,1);
        save(note2,1);
        save(note3,2);
        save(note4,2);
    }

    @Override
    public Note save(Note note, int userId) {
        Map<Integer, Note> notes = userNoteMap.computeIfAbsent(userId, ConcurrentHashMap::new);
        if(note.isNew()){
            note.setId(counter.getAndIncrement());
            notes.put(note.getId(),note);
            return note;
        }
        return notes.computeIfPresent(note.getId(),(id, odlNote) -> note);
    }

    @Override
    public Note getById(Integer id, int userId) {
        Map<Integer, Note> notes = userNoteMap.get(userId);
        return notes.get(id);
    }

    @Override
    public List<Note> getByNumber(String number, int userId) {
        return userNoteMap.get(userId).values().stream()
                .filter(n -> n.getNumber().contains(number))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getAll(Integer userId) {
        List<Note> notes = new ArrayList<>();
        notes.addAll(userNoteMap.get(userId).values());
        return notes;
    }

    @Override
    public boolean delete(Integer id, int userId) {
        Map<Integer, Note> notes = userNoteMap.get(userId);
        return notes != null && notes.remove(id) != null;
    }
}

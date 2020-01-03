package com.example.dins.controller;

import com.example.dins.domain.Note;
import com.example.dins.service.NoteService;
import com.example.dins.util.Handlers.ApiResponse;
import com.example.dins.util.Handlers.EntityNotFoundException;
import com.example.dins.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = NoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class NoteController {

    static final String REST_URL = "/notes";

    private NoteService service;
    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<Note>> getAll(@RequestParam Integer userId){
        List<Note> notes = service.getAll(userId);
        return new ApiResponse<>(HttpStatus.OK,notes);
    }

    @GetMapping("/{id}")
    public ApiResponse<Note> getById(@PathVariable Integer id, @RequestParam Integer userId) throws EntityNotFoundException {
        Note note = service.getById(id, userId);
        if (note == null) {
            throw new EntityNotFoundException(Note.class, "id", id.toString());
        }
        return new ApiResponse<>(HttpStatus.OK, note);
    }

    @GetMapping("/by")
    public ApiResponse<List<Note>> getByNumber(@RequestParam String number, @RequestParam Integer userId){
        List<Note> notes = service.getByNumber(number, userId);
        return new ApiResponse<>(HttpStatus.OK,notes);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Note> delete(@PathVariable Integer id, @RequestParam Integer userId) throws EntityNotFoundException {
        Note note = service.getById(id,userId);
        if (note == null) {
            throw new EntityNotFoundException(Note.class, "id", id.toString());
        } else {
            service.delete(id, userId);
            return new ApiResponse<>(HttpStatus.NO_CONTENT,note);
        }
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Note> update(@RequestBody Note note, @RequestParam Integer userId) {
        return new ApiResponse<>(HttpStatus.OK,service.update(note,userId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Note> create(@RequestBody Note note, @RequestParam Integer userId) {
        return new ApiResponse<>(HttpStatus.CREATED, service.create(note,userId));

    }
}
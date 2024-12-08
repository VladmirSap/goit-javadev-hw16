package org.example.service;

import org.example.model.Note;
import org.example.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;


    public List<Note> listAll() {

        return noteRepository.findAll();
    }

    public Note add(Note note) {

        return noteRepository.save(note);
    }

     public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        if (noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        } else {
            throw new RuntimeException("Note not found");
        }

    }

    public Note getById(long id) {

        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }
}

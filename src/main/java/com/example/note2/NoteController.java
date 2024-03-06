package com.example.note2;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/api/notebook")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Notebook> getAllNotes() {
        return noteService.getAllNotes();
    }


    @GetMapping("/{id}")
    public Notebook getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping
    public Notebook createNote(@RequestBody Notebook note) {
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public Notebook updateNote(@PathVariable Long id, @RequestBody Notebook note) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        if (noteService.deleteNote(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


package com.example.note2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository userRepository;

    public List<Notebook> getAllNotes() {
        return userRepository.findAll();
    }

    public Notebook getNoteById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Notebook createNote(Notebook user) {
        return userRepository.save(user);
    }

    public Notebook updateNote(Long id, Notebook user) {
        Notebook existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setContent(user.getContent());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public boolean deleteNote(Long id) {
        Notebook existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }
        return false;
    }
}


package ua.com.alevel.nix.experienceusingclass.service;

import org.junit.jupiter.api.Test;
import ua.com.alevel.nix.experienceusingclass.data.Author;
import ua.com.alevel.nix.experienceusingclass.repository.AuthorRepository;
import ua.com.alevel.nix.experienceusingclass.repository.impl.AuthorRepositoryImpl;

import java.util.List;

public class TestAuthorServiceImpl {


    private final AuthorRepository authorRepository = new AuthorRepositoryImpl();

    public Author findByFullName(String fullName) {
        return authorRepository.findByFullName(fullName);
    }

    public List<Author> findByBook(String bookName) {
        return authorRepository.findByBook(bookName);
    }

    public List<Author> findByBookId(Long bookId) {
        return authorRepository.findByBookId(bookId);
    }
}

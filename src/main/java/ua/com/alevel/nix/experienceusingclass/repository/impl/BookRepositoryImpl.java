package ua.com.alevel.nix.experienceusingclass.repository.impl;

import ua.com.alevel.nix.experienceusingclass.data.Book;
import ua.com.alevel.nix.experienceusingclass.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private final List<Book> bookList = new ArrayList<>();

    public Book findByBookName(String bookName) {
        /*return bookList
                .stream()
                .filter(book -> book.getBookName().equals(bookName))
                .findFirst()
                .orElse(null);*/
        Book bk = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookName().equals(bookName)) {
                bk = bookList.get(i);
            }
        }
        return bk;
    }

    public Book findByAuthor(String authorName) {
        /*return bookList
                .stream()
                .filter(book -> book.getAuthor().getFullName().equals(authorName))
                .findFirst()
                .orElse(null);*/
        Book bk = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().getFullName().equals(authorName)) {
                bk = bookList.get(i);
                break;
            }
        }
        return bk;
    }

    public Book findByAuthorId(Long authorId) {
        /*return bookList
                .stream()
                .filter(book -> book.getAuthor().getId().equals(authorId))
                .findFirst()
                .orElse(null);*/
        Book bk = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList
                    .get(i)
                    .getAuthor()
                    .getId()
                    .equals(authorId)
            ) {
                bk = bookList.get(i);
            }
        }
        return bk;
    }

    @Override
    public Book findByUq(String uq) {
        /*return bookList
                .stream()
                .filter(book -> book.getUq().equals(uq))
                .findFirst()
                .orElse(null);*/
        Book bk = null;
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getUq().equals(uq)){
                bk = bookList.get(i);
            }
        }
        return bk;
    }

    public void save(Book book) {
        bookList.add(book);
    }

    public Book findById(Long id) {
        /*return bookList
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);*/
        Book bk = null;
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getId().equals(id)){
                bk = bookList.get(i);
            }
        }
        return bk;
    }

    public List<Book> findAll() {
        return bookList;
    }

    public void update(Book book) {
        bookList.forEach(currentBook -> {
            if (book.getId().equals(currentBook.getId())) {
                currentBook.setAuthor(book.getAuthor());
                currentBook.setBookName(book.getBookName());
            }
        });
    }

    public void remove(Long id) {
        //bookList.removeIf(book -> book.getId().equals(id));
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getId().equals(id)){
                bookList.remove(i);
                break;
            }
        }
    }
}

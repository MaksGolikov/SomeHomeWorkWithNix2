package ua.com.alevel.nix.experienceusingclass.repository.impl;

import ua.com.alevel.nix.experienceusingclass.data.Author;
import ua.com.alevel.nix.experienceusingclass.data.Book;
import ua.com.alevel.nix.experienceusingclass.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorRepositoryImpl implements AuthorRepository {

    private final List<Author> authorList = new ArrayList<>();

    public Author findByFullName(final String fullName) {
        Author au = null;
        for (int i = 0; i < authorList.size(); i++) {
            if(authorList.get(i).getFullName().equals(fullName)){
                au = authorList.get(i);
                break;
            }
        }
        return au;
    }

    public List<Author> findByBook(String bookName) {
        List<Author> auL = new ArrayList<>();
        for (int i = 0; i < authorList.size(); i++) {
            List<Book> bkL = authorList.get(i).getBookList();
            for (int j = 0; j < bkL.size(); j++) {
                if(bkL.get(j).getBookName().equals(bookName)){
                    auL.add(authorList.get(i));
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(auL.toArray()));
        /*for (int i = 0; i < auL.size(); i++) {
            System.out.println(auL.get(i).getFullName());
        }*/
        return auL;
    }

    public List<Author> findByBookId(Long bookId) {
        List<Author> auL = new ArrayList<>();
        for (int i = 0; i < authorList.size(); i++) {
            List<Book> bkL = authorList.get(i).getBookList();
            for (int j = 0; j < bkL.size(); j++) {
                if(bkL.get(j).getId().equals(bookId)){
                    auL.add(authorList.get(i));
                    break;
                }
            }
        }
        for (int i = 0; i < auL.size(); i++) {
            System.out.println(auL.get(i).getFullName());
        }
        return auL;
    }

    public void save(Author author) {
        authorList.add(author);
    }

    public Author findById(Long id) {
        Author au = null;
        for (int i = 0; i < authorList.size(); i++) {
            if(authorList.get(i).getId().equals(id)){
                au = authorList.get(i);
                break;
            }
        }
        return au;
    }

    public List<Author> findAll() {
        return authorList;
    }

    public void update(Author author) {
        authorList.forEach(currentAuthor -> {
            if (author.getId().equals(currentAuthor.getId())) {
                currentAuthor.setBookList(author.getBookList());
                currentAuthor.setFullName(author.getFullName());
            }
        });
    }

    public void remove(Long id) {
        //authorList.removeIf(author -> author.getId().equals(id));
        for (int i = 0; i < authorList.size(); i++) {
            if(authorList.get(i).getId().equals(id)){
                authorList.remove(i);
                break;
            }
        }
    }
}

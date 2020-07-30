package com.service;

import com.dao.BooksDao;
import com.pojo.Books;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksService{

    @Resource
    private BooksDao booksDao;

    public int addBook(Books book) {
        return booksDao.addBook(book);
    }

    public int deleteBookById(int id) {
        return booksDao.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return booksDao.updateBook(books);
    }

    public Books queryBookById(int id) {
        return booksDao.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return booksDao.queryAllBook();
    }
}

package com.Qzhou.service.impl;

import com.Qzhou.dao.BookDao;
import com.Qzhou.pojo.Book;
import com.Qzhou.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService2 {
    @Autowired
    public BookDao bookDao;

    @Override
    public Boolean saveBookById(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public Boolean deleteBookById(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public Boolean updateBookById(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public List<Book> selectAllBook() {
        return bookDao.selectList(null);
    }

    @Override
    public Book selectBookById(Integer id) {
        return bookDao.selectById(id);
    }
}

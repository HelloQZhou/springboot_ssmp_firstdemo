package com.Qzhou.service;

import com.Qzhou.pojo.Book;

import java.util.List;

public interface BookService2 {
    Boolean saveBookById(Book book);
    Boolean deleteBookById(Integer id);
    Boolean updateBookById(Book book);
    List<Book> selectAllBook();
    Book selectBookById(Integer id);
}

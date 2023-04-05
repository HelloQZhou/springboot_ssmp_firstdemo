package com.Qzhou.service;

import com.Qzhou.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBookService2 {
    @Autowired
    private BookService2 bookService;
    @Test
    void testGetAllBook(){
        System.out.println(bookService.selectAllBook());
    }
    @Test
    void testUpdateBookById(){
        bookService.updateBookById(new Book(5,"计算机","php","php是最好的语言"));
    }
}

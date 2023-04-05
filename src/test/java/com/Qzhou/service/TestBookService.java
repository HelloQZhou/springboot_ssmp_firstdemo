package com.Qzhou.service;

import com.Qzhou.pojo.Book;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBookService {
    @Autowired
    private BookService bookService;
    @Test
    void testGetAllBookById(){
        System.out.println(bookService.getById(1));
    }

    @Test
    void testGetAllBook(){
        bookService.list().forEach(System.out::println);
    }

    @Test
    void testSave(){
        bookService.save(new Book("大数据","hbase","hadoop"));
    }

    @Test
    void testGetBookToPage(){
        Page<Book> bookPage = new Page<>(2,4);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();

        bookService.page(bookPage, queryWrapper);
    }
}

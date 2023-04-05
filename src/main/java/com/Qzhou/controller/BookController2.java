package com.Qzhou.controller;

import com.Qzhou.pojo.Book;
import com.Qzhou.service.BookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable("id") Integer id){
        return bookService.getById(id);
    }

    @GetMapping("{current}/{pageSize}")
    public IPage<Book> getPage(@PathVariable("current") int currentPage,@PathVariable("pageSize") int pageSize){
        return bookService.getPage(currentPage,pageSize);
    }


    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }


    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") Integer id){
       return bookService.deleteBookById(id);
    }

}

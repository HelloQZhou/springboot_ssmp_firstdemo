package com.Qzhou.controller;

import com.Qzhou.controller.utils.R;
import com.Qzhou.pojo.Book;
import com.Qzhou.service.BookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @GetMapping("{id}")
    public R getById(@PathVariable("id") Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping("{current}/{pageSize}")
    public R getPage(@PathVariable("current") int currentPage,@PathVariable("pageSize") int pageSize,Book book){

        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);

        //如果当前页码值大于了最大页码值（删除最后一页数据后来不及变化页码），使用最大页码值作为当前页码值
        if(currentPage>page.getPages()){
            page=bookService.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {

        if(book.getName().equals("123"))throw new IOException();
        Boolean flag=bookService.save(book);
        return new R(flag,flag? "添加成功^_^" : "添加失败-_-");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable("id") Integer id){
        return new R(bookService.deleteBookById(id));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }



}

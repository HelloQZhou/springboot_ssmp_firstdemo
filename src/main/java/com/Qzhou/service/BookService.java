package com.Qzhou.service;

import com.Qzhou.pojo.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



public interface BookService extends IService<Book> {
    Boolean deleteBookById(Integer id);

    IPage<Book> getPage(int currentPage,int pageSize);
    IPage<Book> getPage(int currentPage,int pageSize,Book book);
}

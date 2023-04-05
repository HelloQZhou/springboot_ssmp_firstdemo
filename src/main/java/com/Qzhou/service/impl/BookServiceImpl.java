package com.Qzhou.service.impl;

import com.Qzhou.dao.BookDao;
import com.Qzhou.pojo.Book;
import com.Qzhou.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {
    @Autowired
    private BookDao bookDao;

    /**
     * 此处重写 可理解为新加一个方法 需在Dao层写入对应接口
     * @param id
     * @return
     */
    @Override
    public Boolean deleteBookById(Integer id){
       return bookDao.deleteById(id)>0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        //参数解读：判断 属性 给该属性赋的值
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage page=new Page(currentPage,pageSize);
        bookDao.selectPage(page,lambdaQueryWrapper);
        return page;
    }


}

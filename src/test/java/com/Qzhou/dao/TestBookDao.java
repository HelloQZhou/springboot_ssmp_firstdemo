package com.Qzhou.dao;

import com.Qzhou.pojo.Book;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBookDao {
    @Autowired
    private BookDao dao;

    @Test
    public void testGetBookById(){
        System.out.println(dao.selectById(1));
    }

    @Test
    public void testInsertBook(){
        dao.insert(new Book("计算机","java","jvm"));
    }

    @Test
    public  void testGetAllBook(){
        System.out.println(dao.selectList(null));
    }

    @Test
    public  void testBookByPage(){
        IPage page= new Page(2,4);
        dao.selectPage(page, null);
    }

    @Test
    public void testSelectBookByLike(){
        //String name="ja";
        String name=null;
        //QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        //queryWrapper.like(name!=null,"name",name);
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name!=null,Book::getName,name);
        dao.selectList(queryWrapper);
    }
    @Test
    public void testUpdateBookById(){
        dao.updateById(new Book(4,"计算机","c++","C++开发"));
    }
}

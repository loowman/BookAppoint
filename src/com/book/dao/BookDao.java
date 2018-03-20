package com.book.dao;

import java.util.List;

import com.book.entity.Book;

public interface BookDao {
      public Book queryById(int id);
      public List<Book> queryByName(String name);
      public List<Book> queryAll(int offset,int limit);
      //减少缓存数量
      public int reduceNumber(Integer id);
}

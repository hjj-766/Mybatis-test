package com.spring.tx.annotation.dao;

public interface BookDao {

    Integer getPriceByBookId(Integer bookId);
    void updateStock(Integer bookId);
    void updateBalance(Integer userId, Integer price);
}


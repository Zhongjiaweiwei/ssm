package org.example.dao;

public interface BookDao {
    /**
     * 根据图书的ID查询图书的价格
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 更新库存
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新余额
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}

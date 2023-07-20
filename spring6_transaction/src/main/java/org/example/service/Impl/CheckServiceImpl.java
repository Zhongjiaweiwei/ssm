package org.example.service.Impl;

import org.example.service.BookService;
import org.example.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private BookService bookService;
    @Override
    @Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
        for (Integer bookId:bookIds){
            bookService.buyBook(userId,bookId);
        }
    }
}

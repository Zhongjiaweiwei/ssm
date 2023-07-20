package org.example.controller;

import org.example.service.BookService;
import org.example.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckService checkService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }
    public void checkout(Integer userId,Integer[] bookIds){
        checkService.checkout(userId,bookIds);
    }
}

package org.example;

import org.example.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {
    @Autowired
    private BookController controller;
    @Test
    public void testBuyBook(){
        controller.buyBook(1,1);
        System.out.println("购买成功");
    }
    @Test
    public void testCheckout(){
        Integer[] integers=new Integer[]{1,2};
        controller.checkout(1,integers);
    }
}

package org.example;

import org.example.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXmlTest {
    @Autowired
    private BookController controller;

    @Test
    public void testCheckout(){
        controller.checkout(1,new Integer[]{1,2});
    }
}

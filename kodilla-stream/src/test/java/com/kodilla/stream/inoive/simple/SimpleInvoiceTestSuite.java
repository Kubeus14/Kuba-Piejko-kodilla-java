package com.kodilla.stream.inoive.simple;

import com.kodilla.stream.invoice.simple.SimpleInvoice;
import com.kodilla.stream.invoice.simple.SimpleItem;
import com.kodilla.stream.invoice.simple.SimpleProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInvoiceTestSuite{
    @Test
    void testGetValueToPay(){
        //Given
        SimpleInvoice invoice = new SimpleInvoice();
        //When
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1",2.50),3.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2",7.25),7.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",4.75),5.0));
        //Then
        assertEquals(82.0,invoice.getValueToPay(),0.001);
    }
}

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
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1",15.55),4.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2",25.30),5.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",5.70),2.0));
        //Then
        System.out.println(invoice.getValueToPay());
        assertEquals(200.1,invoice.getValueToPay(),0.001);
    }
}

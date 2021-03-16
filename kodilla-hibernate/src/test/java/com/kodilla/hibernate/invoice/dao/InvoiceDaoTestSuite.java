package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("21/12/2021");

        Product computer = new Product("Computer");
        Product mouse = new Product("Mouse");
        Product keybord = new Product("Keybord");
        Product loudspeaker = new Product("Loudspeaker");

        Item PCcomputer= new Item(computer, new BigDecimal(1000), 7);
        Item PCmouse = new Item(mouse, new BigDecimal(20), 50);
        Item PCkeybord = new Item(keybord, new BigDecimal(42),17);
        Item PCloudspeaker = new Item(loudspeaker, new BigDecimal(11),89);

        PCcomputer.setInvoice(invoice);
        PCmouse.setInvoice(invoice);
        PCkeybord.setInvoice(invoice);
        PCloudspeaker.setInvoice(invoice);

        List<Item> items = new ArrayList<>();
        items.add(PCcomputer);
        items.add(PCmouse);
        items.add(PCkeybord);
        items.add(PCloudspeaker);




        //When
        invoiceDao.save(invoice);
        int IDNumber = invoice.getId();


        Invoice findInDatabase = invoiceDao.findById(IDNumber);

        //Then
        assertEquals(IDNumber,findInDatabase.getId() );

    }
}

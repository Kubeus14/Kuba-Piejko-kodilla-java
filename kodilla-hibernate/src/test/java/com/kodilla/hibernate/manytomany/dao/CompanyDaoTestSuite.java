package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manttomany.Company;
import com.kodilla.hibernate.manttomany.Employee;
import com.kodilla.hibernate.manttomany.dao.CompanyDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee worker1 = new Employee("Tom", "Collins");
        Employee worker2 = new Employee("Kate", "Thomas");
        Employee worker3 = new Employee("John","Watt");
        Employee worker4 = new Employee("Mary","Connor");


        Company company1 = new Company("Market");
        Company company2 = new Company("Restaurant");


        company1.getEmployees().add(worker1);
        company1.getEmployees().add(worker2);
        company2.getEmployees().add(worker1);
        company2.getEmployees().add(worker3);
        company2.getEmployees().add(worker4);

        worker1.getCompanies().add(company1);
        worker1.getCompanies().add(company2);
        worker2.getCompanies().add(company2);
        worker3.getCompanies().add(company2);
        worker4.getCompanies().add(company2);

        //When
        companyDao.save(company1);
        int company1Id = company1.getId();
        companyDao.save(company2);
        int company2Id = company2.getId();


        //Then
        assertNotEquals(0, company1Id);
        assertNotEquals(0, company2Id);



    }
}

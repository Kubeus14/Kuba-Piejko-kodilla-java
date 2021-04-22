package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class FacadeTest {

    @Autowired
    private Facade facade;
    @Autowired
    private CompanyDao companyDao;

    private ArrayList<Company> companyResultList = new ArrayList<>();
    private ArrayList<Employee> employeeResultList = new ArrayList<>();


    @Test
    public void retrieveCompanyLikeTest() {

        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaSmith = new Employee("Linda", "Smith");

        Company softwareMachine = new Company("Software Machine");
        Company softDataMasters = new Company("Soft Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softDataMasters.getEmployees().add(stephanieClarckson);
        softDataMasters.getEmployees().add(lindaSmith);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaSmith);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(softDataMasters);
        companyDao.save(greyMatter);

        companyResultList.add(softwareMachine);
        companyResultList.add(softDataMasters);

        employeeResultList.add(johnSmith);
        employeeResultList.add(lindaSmith);
        //When
        List<Company> resultList = facade.retrieveCompanyLike("oft");
        //Then
        assertEquals(employeeResultList.size(), resultList.size());
        //CleanUp
        try {
            companyDao.delete(softwareMachine);
            companyDao.delete(softDataMasters);
            companyDao.delete(greyMatter);
        } catch (Exception e) {
            //do nothing
        }

    }

    @Test
    public void retrieveEmployeesWithLastNameContainingTest() {

        //Given

        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaSmith = new Employee("Linda", "Smith");

        Company softwareMachine = new Company("Software Machine");
        Company softDataMasters = new Company("Soft Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softDataMasters.getEmployees().add(stephanieClarckson);
        softDataMasters.getEmployees().add(lindaSmith);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaSmith);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(softDataMasters);
        companyDao.save(greyMatter);

        companyResultList.add(softwareMachine);
        companyResultList.add(softDataMasters);

        employeeResultList.add(johnSmith);
        employeeResultList.add(lindaSmith);


        //When
        List<Employee> queryResult = facade.retrieveEmployeesWithLastNameContaining("mit");
        //Then
        assertEquals(employeeResultList.size(), queryResult.size());

        try {
            companyDao.delete(softwareMachine);
            companyDao.delete(softDataMasters);
            companyDao.delete(greyMatter);
        } catch (Exception e) {
            //do nothing
        }
    }
}

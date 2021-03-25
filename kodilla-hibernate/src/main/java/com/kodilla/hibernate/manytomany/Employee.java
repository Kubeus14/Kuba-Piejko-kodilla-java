package com.kodilla.hibernate.manytomany;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NamedQueries({
        @NamedQuery(
                name = "Employee.retrieveEmployeesWithLastname",
                query = "FROM Employee WHERE lastname = :LASTNAME"
        ),
        @NamedQuery(
                name = "Employee.retrieveEmployeesWithLastNameContaining",
                //query = "FROM Employee WHERE lastname like :LASTNAME_PART"
                query = "FROM Employee WHERE lastname like concat('%',:LASTNAME_PART,'%')"
        )
})
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    private int id;
    private String firstname;
    private String lastname;
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }
    @ManyToMany(cascade = CascadeType.ALL)

    public List<Company> getCompanies() {
        return companies;
    }

    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

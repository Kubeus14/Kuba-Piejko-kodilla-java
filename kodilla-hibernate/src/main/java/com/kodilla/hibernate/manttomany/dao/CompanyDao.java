package com.kodilla.hibernate.manttomany.dao;

import com.kodilla.hibernate.manttomany.Company;
import com.kodilla.hibernate.manttomany.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query
    List<Employee> retrieveEmployeeWithLastname(@Param("LASTNAME") String lastname);
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyNameLike(@Param("NAME") String name);

}

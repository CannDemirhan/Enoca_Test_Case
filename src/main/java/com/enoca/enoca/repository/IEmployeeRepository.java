package com.enoca.enoca.repository;

import com.enoca.enoca.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByOid(Long oid);
}

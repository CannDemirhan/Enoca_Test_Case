package com.enoca.enoca.repository;

import com.enoca.enoca.repository.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findByOid(Long oid);
}

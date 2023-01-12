package com.enoca.enoca.config;

import com.enoca.enoca.repository.IEmployeeRepository;
import com.enoca.enoca.repository.entity.Company;
import com.enoca.enoca.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final IEmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Employee employee = Employee.builder()
            .name("Can Demirhan")
            .birthDate(LocalDate.of(1994,9,28))
            .build();
        Company company = Company.builder()
            .name("Enoca")
            .build();
        employee.setCompany(company);
        employeeRepository.save(employee);
    }
}

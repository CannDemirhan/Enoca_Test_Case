package com.enoca.enoca.service;


import com.enoca.enoca.dto.EmployeeDeleteRequestDto;
import com.enoca.enoca.dto.EmployeeSaveRequestDto;
import com.enoca.enoca.dto.EmployeeUpdateRequestDto;
import com.enoca.enoca.dto.Response;
import com.enoca.enoca.repository.ICompanyRepository;
import com.enoca.enoca.repository.IEmployeeRepository;
import com.enoca.enoca.repository.entity.Company;
import com.enoca.enoca.repository.entity.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final ICompanyRepository companyRepository;

    public EmployeeService(IEmployeeRepository employeeRepository, ICompanyRepository companyRepository){
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Response save(EmployeeSaveRequestDto employeeSaveRequestDto) {
        Optional<Company> companyOpt = companyRepository.findByOid(employeeSaveRequestDto.getCompanyOid());
        Employee employee = Employee.builder()
                .birthDate(employeeSaveRequestDto.getBirthDate())
                .name(employeeSaveRequestDto.getName())
                .isWorking(true)
                .startingDate(LocalDate.now())
            .build();
        if(companyOpt.isPresent()){
            employee.setCompany(companyOpt.get());
        }
        Employee employeeSaved = employeeRepository.save(employee);
        if(employeeSaved.getName() == ""){
            return Response.builder().status("BAD_REQUEST").build();
        }
        return Response.builder().status("OK").build();

    }

    public Response update(EmployeeUpdateRequestDto employeeUpdateRequestDto) {
        Optional<Company> companyOpt = companyRepository.findByOid(employeeUpdateRequestDto.getCompanyOid());
        Optional<Employee> employeeOpt = employeeRepository.findByOid(employeeUpdateRequestDto.getOid());
        if(employeeOpt.isEmpty()){
            return Response.builder().status("BAD_REQUEST").build();
        }
        if(companyOpt.isPresent()){
            employeeOpt.get().setCompany(companyOpt.get());
        }
        employeeOpt.get().setName(employeeUpdateRequestDto.getName());
        employeeOpt.get().setIsWorking(employeeUpdateRequestDto.getIsWorking());
        employeeRepository.save(employeeOpt.get());
        return Response.builder().status("OK").build();
    }

    public Response delete(EmployeeDeleteRequestDto employeeDeleteRequestDto) {
        Optional<Employee> employeeOpt = employeeRepository.findByOid(employeeDeleteRequestDto.getOid());
        if(employeeOpt.isEmpty()){
            return Response.builder().status("BAD_REQUEST").build();
        }
        employeeRepository.delete(employeeOpt.get());
        return Response.builder().status("OK").build();
    }
}

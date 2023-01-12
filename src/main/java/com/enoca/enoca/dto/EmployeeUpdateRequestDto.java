package com.enoca.enoca.dto;

import com.enoca.enoca.repository.entity.Company;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeUpdateRequestDto {

    private Long oid;
    private Long companyOid;
    private String name;
    private Boolean isWorking;
}

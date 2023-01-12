package com.enoca.enoca.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeSaveRequestDto {

    private String name;
    private LocalDate birthDate;
    private Long companyOid;
}

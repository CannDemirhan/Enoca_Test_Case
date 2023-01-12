package com.enoca.enoca.repository.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Employee extends BaseObject {

    private String name;
    private LocalDate birthDate;
    private LocalDate startingDate;
    private Boolean isWorking;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_oid")
    private Company company;
}

package com.enoca.enoca.service;

import com.enoca.enoca.dto.CompanyDeleteRequestDto;
import com.enoca.enoca.dto.CompanySaveRequestDto;
import com.enoca.enoca.dto.CompanyUpdateRequestDto;
import com.enoca.enoca.dto.Response;
import com.enoca.enoca.repository.ICompanyRepository;
import com.enoca.enoca.repository.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final ICompanyRepository companyRepository;

    public CompanyService(ICompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        List<Company> compList =companyRepository.findAll();
        return companyRepository.findAll();
    }

    public Response save(CompanySaveRequestDto companySaveRequestDto) {
        Company company = companyRepository.save(Company.builder()
            .name(companySaveRequestDto.getName())
            .build());
        if(company.getName() == ""){
            return Response.builder().status("BAD_REQUEST").build();
        }
        return Response.builder().status("OK").build();
    }

    public Response update(CompanyUpdateRequestDto companyUpdateRequestDto) {
        Optional<Company> companyOpt = companyRepository.findByOid(companyUpdateRequestDto.getOid());
        if(companyOpt.isEmpty()){
            return Response.builder().status("BAD_REQUEST").build();
        }
        companyOpt.get().setName(companyUpdateRequestDto.getName());
        companyRepository.save(companyOpt.get());
        return Response.builder().status("OK").build();
    }

    public Response delete(CompanyDeleteRequestDto companyDeleteRequestDto) {
        Optional<Company> companyOpt = companyRepository.findByOid(companyDeleteRequestDto.getOid());
        if(companyOpt.isEmpty()){
            return Response.builder().status("BAD_REQUEST").build();
        }
        companyRepository.delete(companyOpt.get());
        return Response.builder().status("OK").build();
    }
}

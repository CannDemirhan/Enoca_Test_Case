package com.enoca.enoca.controller;

import com.enoca.enoca.dto.CompanyDeleteRequestDto;
import com.enoca.enoca.dto.CompanySaveRequestDto;
import com.enoca.enoca.dto.CompanyUpdateRequestDto;
import com.enoca.enoca.dto.Response;
import com.enoca.enoca.repository.entity.Company;
import com.enoca.enoca.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping()
    public ResponseEntity<List<Company>> getAll(){
        return ResponseEntity.ok(companyService.getAll());
    }
    @PostMapping("/create")
    public ResponseEntity<Response> save(@RequestBody CompanySaveRequestDto companySaveRequestDto){
        try{
            return ResponseEntity.ok(companyService.save(companySaveRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Response.builder().status("SERVER_ERROR").build());
        }
    }
    @PostMapping("/update")
    public ResponseEntity<Response> update(@RequestBody CompanyUpdateRequestDto companyUpdateRequestDto){
        try{
            return ResponseEntity.ok(companyService.update(companyUpdateRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Response.builder().status("SERVER_ERROR").build());
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<Response> update(@RequestBody CompanyDeleteRequestDto companyDeleteRequestDto){
        try{
            return ResponseEntity.ok(companyService.delete(companyDeleteRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Response.builder().status("SERVER_ERROR").build());
        }
    }
}

package com.enoca.enoca.controller;

import com.enoca.enoca.dto.EmployeeDeleteRequestDto;
import com.enoca.enoca.dto.EmployeeSaveRequestDto;
import com.enoca.enoca.dto.EmployeeUpdateRequestDto;
import com.enoca.enoca.dto.Response;
import com.enoca.enoca.repository.entity.Employee;
import com.enoca.enoca.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }
    @PostMapping("/create")
    public ResponseEntity<Response> save(@RequestBody EmployeeSaveRequestDto employeeSaveRequestDto){
        try{
            return ResponseEntity.ok(employeeService.save(employeeSaveRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Response.builder().status("SERVER_ERROR").build());
        }
    }
    @PostMapping("/update")
    public ResponseEntity<Response> update(@RequestBody EmployeeUpdateRequestDto employeeUpdateRequestDto){
        try{
            return ResponseEntity.ok(employeeService.update(employeeUpdateRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Response.builder().status("SERVER_ERROR").build());
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<Response> delete(@RequestBody EmployeeDeleteRequestDto employeeDeleteRequestDto){
        try{
            return ResponseEntity.ok(employeeService.delete(employeeDeleteRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Response.builder().status("SERVER_ERROR").build());
        }
    }
}

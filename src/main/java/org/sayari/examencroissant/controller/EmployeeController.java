package org.sayari.examencroissant.controller;

import org.sayari.examencroissant.models.Employe;
import org.sayari.examencroissant.service.EmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeSevice employeeSevice ;
    @PostMapping("/addEmployee")
    private ResponseEntity<?> addEmployee(@RequestBody  Employe employe,@RequestParam String nomCompany){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeSevice.addEmployeAndAssignToCompany(employe,nomCompany));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/getEmployeesByCompany")
    private ResponseEntity<?> getEmployeesByCompany(@RequestParam String nomCompany,@RequestParam String area){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeSevice.getEmployeByArea(nomCompany, area));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

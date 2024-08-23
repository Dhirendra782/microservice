package com.companyapp.controller;

import com.companyapp.model.Company;
import com.companyapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {


    @Autowired
    private CompanyService companyService;

    //create company
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company saveCompany = companyService.saveCompany(company);
        return new ResponseEntity<>(saveCompany, HttpStatus.CREATED);
    }

    //get company list
    @GetMapping
    public ResponseEntity<List<Company>> getCompanyList() {
        List<Company> getCompanyList = companyService.getCompanyList();
        return ResponseEntity.ok(getCompanyList);
    }

    //get by company id
    @GetMapping("/{id}")
    public ResponseEntity<Company> getByCompanyId(@PathVariable Long id) {
        Company companyId = companyService.getByCompanyId(id);
        if(companyId !=null) {
            return new ResponseEntity<>(companyId,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //update company
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        companyService.updateCompany(company, id);
        return new ResponseEntity("Company updated successfully",HttpStatus.OK);
    }

    //delete by company id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByCompanyId(@PathVariable Long id) {
        boolean isDelete = companyService.deleteByCompanyId(id);
        if(isDelete){
            return new ResponseEntity<>("Company Delete Successfully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
        }

    }

}


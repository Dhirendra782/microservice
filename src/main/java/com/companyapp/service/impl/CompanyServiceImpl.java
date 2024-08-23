package com.companyapp.service.impl;


import com.companyapp.model.Company;
import com.companyapp.repository.CompanyRepository;
import com.companyapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }

    @Override
    public Company getByCompanyId(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    //update company
    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companyUpdate = companyOptional.get();
            companyUpdate.setName(company.getName());
            companyUpdate.setDescription(company.getDescription());
            // companyUpdate.setJobs(company.getJobs());
            companyRepository.save(companyUpdate);
            return true;
        }
        else {
            return false;
        }
    }

    //delete by company by id
    @Override
    public boolean deleteByCompanyId(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}

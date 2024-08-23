package com.companyapp.service;


import com.companyapp.model.Company;

import java.util.List;

public interface CompanyService {

    //create company
    public Company saveCompany(Company company);

    //Get All company list
    public List<Company> getCompanyList();

    public Company getByCompanyId(Long id);

    //update the company
    public boolean updateCompany(Company company, Long id);

    //delete company by id
    public boolean deleteByCompanyId(Long id);


}

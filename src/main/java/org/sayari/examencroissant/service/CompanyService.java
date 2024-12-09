package org.sayari.examencroissant.service;

import org.sayari.examencroissant.models.Company;
import org.sayari.examencroissant.reposetry.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo ;

    public Company addCompany(Company company){
        return companyRepo.save(company);
    }



}

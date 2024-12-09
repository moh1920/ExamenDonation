package org.sayari.examencroissant.service;

import lombok.extern.slf4j.Slf4j;
import org.sayari.examencroissant.models.Company;

import org.sayari.examencroissant.models.Employe;
import org.sayari.examencroissant.reposetry.CompanyRepo;
import org.sayari.examencroissant.reposetry.DonationRepo;
import org.sayari.examencroissant.reposetry.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class EmployeeSevice {
    @Autowired
    private EmployeeRepo employeeRepo ;
    @Autowired
    private CompanyRepo companyRepo ;
    @Autowired
    private DonationRepo donationRepo;

    public Employe addEmployeAndAssignToCompany(Employe employe, String campanyName){
        Company company =companyRepo.findByNomCampanya(campanyName);
        if(company != null){
            employe.setCompany(company);
            return employeeRepo.save(employe);
        }int date = LocalDate.now().getMonth().getValue();
        return employe ;
    }
    @Scheduled(cron = "*/10 * * * * *")
    public void getEmployeByDonation() {
        List<Employe> employees = employeeRepo.findAll();

        Employe maxEmploye = null;
        int maxDonations = 0;

        for (Employe employe : employees) {
            int donationCount = (employe.getDonations() != null) ? employe.getDonations().size() : 0;

            if (donationCount > maxDonations) {
                maxDonations = donationCount;
                maxEmploye = employe;
            }
        }

        if (maxEmploye != null) {
            log.info("L'employé avec le plus de donations est : " + maxEmploye.getNom() + " avec " + maxDonations + " donations.");
        } else {
            log.warn("Aucun employé trouvé.");
        }
    }
    public List<Employe> getEmployeByArea(String companyName , String area) {
      return  employeeRepo.findByCompanyNomCampanyaAndDonations(companyName, area);
    }



}

package org.sayari.examencroissant.reposetry;

import org.sayari.examencroissant.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
    Company findByNomCampanya(String NomCampanya);
}

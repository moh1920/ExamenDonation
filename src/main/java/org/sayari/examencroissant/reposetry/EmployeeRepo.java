package org.sayari.examencroissant.reposetry;

import org.sayari.examencroissant.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employe,Long> {

    @Query(value = """
        SELECT employe_employer_id, COUNT(*) AS nombre
        FROM donation
        WHERE DATE_FORMAT(date, '%m') = :mois
        GROUP BY employe_employer_id
        ORDER BY nombre DESC
        LIMIT 1
    """, nativeQuery = true)
    Object[] findTopDonatingEmployee(@Param("mois") int mois);

    @Query("SELECT e FROM Employe e " +
            "INNER JOIN e.donations d " +
            "WHERE e.company.nomCampanya = :companyName " +
            "AND d.donId IN (SELECT don.donId FROM RedCrescent r " +
            "INNER JOIN r.donations don " +
            "WHERE r.area = :area)")
    List<Employe> findByCompanyNomCampanyaAndDonations(@Param("companyName") String companyName , @Param("area") String area);
}

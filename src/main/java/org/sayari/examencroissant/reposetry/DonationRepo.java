package org.sayari.examencroissant.reposetry;

import org.sayari.examencroissant.models.Donation;
import org.sayari.examencroissant.models.DonationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Set;

public interface DonationRepo extends JpaRepository<Donation,Long> {
    Set<Donation> findByTypeOrderByDate(DonationType type);

    @Query(value = """
            select sum(Donation.amount) from Donation 
            where Donation.date between :startDate and :endDate""", nativeQuery = true )
    abstract Float findByDateBetween(@Param("startDate") Date startDate,@Param("endDate") Date endDate);


}

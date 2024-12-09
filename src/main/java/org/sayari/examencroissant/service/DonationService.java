package org.sayari.examencroissant.service;

import org.sayari.examencroissant.models.Donation;
import org.sayari.examencroissant.models.DonationType;
import org.sayari.examencroissant.reposetry.DonationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class DonationService {
    @Autowired
    private DonationRepo donationRepo ;

    public Donation addDonation(Donation donation){
        if(donation.getType().equals(DonationType.MONETARY) && donation.getAmount()<=0){
            throw new RuntimeException("not a valid donation");
        }
        if(donation.getType().equals(DonationType.BLOOD) || donation.getType().equals(DonationType.IN_KIND) ){
            donation.setAmount(donation.getAmount()*0);
        }
        return donationRepo.save(donation);
    }
    public Set<Donation> getDonationByType(DonationType type) {
        return donationRepo.findByTypeOrderByDate(type);
    }
    public Float getTotalDonation(Date date1, Date date2) {
        return donationRepo.findByDateBetween(date1, date2);
    }

}

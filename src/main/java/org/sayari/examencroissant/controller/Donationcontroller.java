package org.sayari.examencroissant.controller;

import org.sayari.examencroissant.models.Donation;
import org.sayari.examencroissant.models.DonationType;
import org.sayari.examencroissant.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/donation")
public class Donationcontroller {

    @Autowired
    private DonationService donationService;
    @PostMapping("/addDonation")
    public ResponseEntity<?> addDonation(@RequestBody Donation donation){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(donationService.addDonation(donation));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/getDonations")
    public ResponseEntity<?> getDonationsByType(@RequestParam DonationType type){
        try {
            return ResponseEntity.ok(donationService.getDonationByType(type));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/getDonationsBetweenDate")
    public ResponseEntity<?> getDonationsByCompany(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") Date startDate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") Date endDate){
        try {
            return ResponseEntity.ok(donationService.getTotalDonation(startDate, endDate));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

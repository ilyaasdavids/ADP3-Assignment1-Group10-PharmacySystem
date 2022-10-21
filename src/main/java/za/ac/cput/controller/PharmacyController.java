package za.ac.cput.controller;

/* PharmacyController.java
Controller for the Pharmacy
Author: Waseem Dollie (216040566)
Date: 15 October 2022 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.service.PharmacyServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/pharmacy")
@Slf4j
public class PharmacyController {

    private final PharmacyServiceImpl pharmacyService;

    @Autowired
    public PharmacyController(PharmacyServiceImpl pharmacyService){this.pharmacyService = pharmacyService;}

    @PostMapping("save")
    public ResponseEntity<Pharmacy> save(@Valid @RequestBody Pharmacy pharmacy){
        log.info("save request:{}", pharmacy);
        Pharmacy save = pharmacyService.save(pharmacy);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{pharmId}")
    public ResponseEntity<Pharmacy> read (@PathVariable String pharmId){

        log.info("read request:{}", pharmId);
        Pharmacy pharmacy = this.pharmacyService.read(pharmId);
        return ResponseEntity.ok(pharmacy);
    }

    @GetMapping("delete/{pharmId}")
    public ResponseEntity<Pharmacy>delete(@PathVariable String pharmID)
    {
        log.info("Read request:{}", pharmID);
        this.pharmacyService.delete(pharmID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Pharmacy>>findAll(){
        List<Pharmacy>pharmacyList = this.pharmacyService.getAll();
        return ResponseEntity.ok(pharmacyList);
    }

}

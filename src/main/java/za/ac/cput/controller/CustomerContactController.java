/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * CustomerContactController.java
 */

package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.domain.PharmacyContact;
import za.ac.cput.service.CustomerContactServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/customerContact")
@Slf4j
public class CustomerContactController {

    private final CustomerContactServiceImpl customerContactService;

    @Autowired
    public CustomerContactController(CustomerContactServiceImpl customerContactService){
        this.customerContactService = customerContactService;
    }

    @PostMapping("save")
    public ResponseEntity<CustomerContact> save(@Valid @RequestBody CustomerContact customerContact){
        log.info("save request:{}", customerContact);
       CustomerContact save = customerContactService.save(customerContact);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{customerId}")
    public ResponseEntity<CustomerContact> read (@PathVariable String customerId){

        log.info("read request:{}", customerId);
        CustomerContact customerContact = this.customerContactService.read(customerId);
        return ResponseEntity.ok(customerContact);
    }

    @GetMapping("delete/{}")
    public ResponseEntity<Void>delete(@PathVariable String customerId)
    {
        log.info("Read request:{}", customerId);
        this.customerContactService.delete(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<CustomerContact>>findAll(){
        List<CustomerContact>customerContactList = this.customerContactService.getAll();
        return ResponseEntity.ok(customerContactList);
    }
}

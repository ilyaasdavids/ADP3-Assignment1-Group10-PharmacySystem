package za.ac.cput.controller;

/*EmployeeContactController.java
 *Controller for the EmployeeContact
 * Author: Daniella Burgess 219446482
 * Date: 15 October 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.service.EmployeeContactServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/employeeContact")
@Slf4j
public class EmployeeContactController {

    private final EmployeeContactServiceImpl employeeContactService;

    @Autowired
    public EmployeeContactController(EmployeeContactServiceImpl employeeContactService)
    {this.employeeContactService = employeeContactService;}

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeContact>> findAll(){
        List<EmployeeContact> employeeContactsList = this.employeeContactService.getAll();
        return ResponseEntity.ok(employeeContactsList);
    }

    @GetMapping("/read/{staffId}")
    public ResponseEntity<EmployeeContact> read(@PathVariable String staffId){
        log.info("read request:{}", staffId);
        EmployeeContact employeeContact = employeeContactService.read(staffId);
        return ResponseEntity.ok(employeeContact);
    }

    @PostMapping("save")
    public ResponseEntity<EmployeeContact> save(@Valid @RequestBody EmployeeContact employeeContact) {
        log.info("save request:{}", employeeContact);
        EmployeeContact save = employeeContactService.save(employeeContact);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<EmployeeContact>delete(@PathVariable String staffId) {
        log.info("read request:{}", staffId);
        this.employeeContactService.delete(staffId);
        return ResponseEntity.noContent().build();
    }
}

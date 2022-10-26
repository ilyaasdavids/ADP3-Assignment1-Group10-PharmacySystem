/*SupplierContactController.java
 * Controller class for SupplierContact
 * Author: Ilyaas Davids (219466242)
 * Date: 11 Oct 2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Medication;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierContact;
import za.ac.cput.service.SupplierContactServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/supplierContact")
@Slf4j
public class SupplierContactController {

    private final SupplierContactServiceImpl supplierContactService;

    @Autowired
    public SupplierContactController(SupplierContactServiceImpl supplierContactService) {
        this.supplierContactService = supplierContactService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SupplierContact>> getAll(){
        List<SupplierContact> supplierContacts  = supplierContactService.getAll();
        return new ResponseEntity<>(supplierContacts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SupplierContact> read(@PathVariable("id")String id){
        log.info("read request:{}", id);
        SupplierContact supplierContact = this.supplierContactService.read(id);
        return ResponseEntity.ok(supplierContact);
    }

    @PostMapping("/save")
    public ResponseEntity<SupplierContact> save(@Valid @RequestBody SupplierContact supplierContact){
        SupplierContact newSupplierContact = supplierContactService.save(supplierContact);
        return new ResponseEntity<>(newSupplierContact,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SupplierContact> update(@RequestBody SupplierContact supplierContact){
        SupplierContact updateSupplierContact = supplierContactService.save(supplierContact);
        return new ResponseEntity<>(updateSupplierContact,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SupplierContact> delete(@PathVariable String id){
        supplierContactService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

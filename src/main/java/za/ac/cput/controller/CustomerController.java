package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @PostMapping("save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer){
        log.info("save request:{}", customer);
        Customer save = customerService.save(customer);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{customerId}")
    public ResponseEntity<Customer> read (@PathVariable String customerId){

        log.info("read request:{}", customerId);
        Customer customer = this.customerService.read(customerId);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("delete/{}")
    public ResponseEntity<Void>delete(@PathVariable String customerId)
    {
        log.info("Read request:{}", customerId);
        this.customerService.delete(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>>findAll(){
        List<Customer>customerList = this.customerService.getAll();
        return ResponseEntity.ok(customerList);
    }

}

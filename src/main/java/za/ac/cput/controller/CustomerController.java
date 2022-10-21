package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.CustomerService;

import java.util.List;
import java.util.Optional;

/* CustomerController.java
 * Controller class for the Customer Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date:  22 September 2022
 */
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping("save")
    public ResponseEntity<Customer> save(@Validated @RequestBody Customer customer) {
        log.info("Save request: {}", customer);
        Customer save = customerService.save(customer);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{customerId}")
    public ResponseEntity<Customer> read(@PathVariable("id") String customerId) {
        log.info("Read request:{}", customerId);
        Customer customer = this.customerService.read(customerId);
        return ResponseEntity.ok(customer);

    }

   // @PutMapping("/update")
   // public ResponseEntity<Customer> update(@Validated @RequestBody Customer customer) {
    //    log.info("Update request: {}", customer);
    //    Customer update = customerService.update(customer);
     //   return ResponseEntity.ok(update);
  //  }

    @DeleteMapping("delete/{customerId}")
    public ResponseEntity<Customer> delete(@PathVariable String customerId) {
        log.info("Delete request{}", customerId);
        this.customerService.deleteById(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customerList = this.customerService.findAll();
        return ResponseEntity.ok(customerList);
    }
}

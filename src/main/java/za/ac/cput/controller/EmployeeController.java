package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/employee")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee){
        log.info("save request:{}", employee);
        Employee save = employeeService.save(employee);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Employee> read (@PathVariable String staffId){

        log.info("read request:{}", staffId);
        Employee employee = this.employeeService.read(staffId);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete/{staffId}")
    public ResponseEntity<Employee>delete(@PathVariable String staffId)
    {
        log.info("Read request:{}", staffId);
        this.employeeService.delete(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>>findAll(){
        List<Employee>employeeList = this.employeeService.getAll();
        return ResponseEntity.ok(employeeList);
    }

}

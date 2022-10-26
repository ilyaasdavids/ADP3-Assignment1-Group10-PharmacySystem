/*EmployeeContactServiceImpl.java
 *EmployeeContactServiceImpl class for EmployeeContactService
 * Author: Daniella Burgess 219446482
 * Date: 13 October 2022
 */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.repository.EmployeeContactRepository;

import java.util.List;
@Service
public class EmployeeContactServiceImpl implements EmployeeContactService {

    private final EmployeeContactRepository employeeContactRepository;

    @Autowired
    public EmployeeContactServiceImpl(EmployeeContactRepository employeeContactRepository)
    {this.employeeContactRepository = employeeContactRepository;}

    @Override
    public EmployeeContact save(EmployeeContact employeeContact) {
        return this.employeeContactRepository.save(employeeContact);
    }

    @Override
    public EmployeeContact read(String s) {
        return this.employeeContactRepository.findById(s).orElse(null);
    }


    @Override
    public boolean delete(String s) {
        if (this.employeeContactRepository.existsById(s)) {
            this.employeeContactRepository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeContact> getAll() {
        return this.employeeContactRepository.findAll() ;
    }



}

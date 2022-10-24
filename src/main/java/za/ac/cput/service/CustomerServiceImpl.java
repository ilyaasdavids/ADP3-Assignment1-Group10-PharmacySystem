package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer read(String s) {
        return this.customerRepository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.customerRepository.existsById(s)) {
            this.customerRepository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

}


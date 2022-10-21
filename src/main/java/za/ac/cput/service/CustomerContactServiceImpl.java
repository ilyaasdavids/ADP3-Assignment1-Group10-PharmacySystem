package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.repository.CustomerContactRepository;

import java.util.List;

@Service
public class CustomerContactServiceImpl implements CustomerContactService{

    private final CustomerContactRepository customerContactRepository;

    @Autowired
    public CustomerContactServiceImpl(CustomerContactRepository customerContactRepository)
    {this.customerContactRepository = customerContactRepository;}

    @Override
    public List<CustomerContact> getAll() {return this.customerContactRepository.findAll();}

    @Override
    public CustomerContact save(CustomerContact customerContact) {return this.customerContactRepository.save(customerContact);}

    @Override
    public CustomerContact read(String s) {return this.customerContactRepository.findById(s).orElse(null);}

    @Override
    public boolean delete(String s) {
        if (this.customerContactRepository.existsById(s)) {
            this.customerContactRepository.deleteById(s);
            return true;
        }
        return false;
    }
}

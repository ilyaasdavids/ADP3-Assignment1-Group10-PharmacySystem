package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.domain.PharmacyContact;
import za.ac.cput.factory.CustomerContactFactory;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.PharmacyContactFactory;
import za.ac.cput.factory.PharmacyFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerContactServiceImplTest {

    @Autowired
    CustomerContactService customerContactService;

    private final CustomerContact customerContact = CustomerContactFactory.createCustomerContact("01","0213552233", "Pharmacy@gmail.com");

    @Order(1)
    @Test
    void save() {
        CustomerContact create1 = customerContactService.save(this.customerContact);
        assertNotNull(create1);
        System.out.println(create1);
    }

    @Order(2)
    @Test
    void read() {
       CustomerContact read1 = customerContactService.read(customerContact.getCustomerId());

        assertEquals(read1.getCustomerId(), customerContact.getCustomerId());
        System.out.println(read1);

    }

    @Order(4)
    @Test
    void delete() {
        boolean success = customerContactService.delete(customerContact.getCustomerId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Order(3)
    @Test
    void getAll() {
        System.out.println(customerContactService.getAll());
    }
}

package za.ac.cput.service;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceImplTest {

    @Autowired
    CustomerService empService;

    private final Customer customer1 = CustomerFactory.createCustomer("220296006", "male", "Thabiso", "Patrick", "Matsaba" );

    @Order(1)
    @Test
    void save() {
        Customer create1 = empService.save(this.customer1);
        assertNotNull(create1);
        System.out.println(create1);
    }

    @Order(2)
    @Test
    void read() {
        Customer read1 = empService.read(customer1.getCustomerId());

        assertEquals(read1.getCustomerId(), customer1.getCustomerId());
        System.out.println(read1);

    }

    @Order(4)
    @Test
    void delete() {
        boolean success = empService.delete(customer1.getCustomerId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Order(3)
    @Test
    void getAll() {
        System.out.println(empService.getAll());
    }
}
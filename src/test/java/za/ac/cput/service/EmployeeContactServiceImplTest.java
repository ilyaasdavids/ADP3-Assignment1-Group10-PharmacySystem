/*EmployeeContactServiceImplTest.java
 *EmployeeContactServiceImplTest class for EmployeeContactServiceImpl
 * Author: Daniella Burgess 219446482
 * Date: 13 October 2022
 */

package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.factory.EmployeeContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeContactServiceImplTest {

    @Autowired
    EmployeeContactService employeeContactService;

    private final EmployeeContact employeeContact = EmployeeContactFactory.build("01","0672664466","219446482@mycput.ac.za");

    @Order(1)
    @Test
    void save() {
        EmployeeContact create1 = employeeContactService.save(this.employeeContact);
        assertNotNull(create1);
        System.out.println(create1);
    }

    @Order(2)
    @Test
    void read() {
        EmployeeContact read1 = employeeContactService.read(employeeContact.getStaffId());
        assertEquals(read1.getStaffId(), employeeContact.getStaffId());
        System.out.println(read1);
    }
    @Order(4)
    @Test
    void delete() {
        boolean success = employeeContactService.delete(employeeContact.getStaffId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Order(3)
    @Test
    void getAll() {
        System.out.println(employeeContactService.getAll());
    }
}

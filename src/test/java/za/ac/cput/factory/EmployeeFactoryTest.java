package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    void testCreateEmployee() {
        Employee employee = EmployeeFactory.createEmployee("219010145", "male", "Zaeem", "", "Petersen");
        Assertions.assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    void testCreateEmployeeWithError() {
        Employee employee = EmployeeFactory.createEmployee("219010145", "", "Zaeem", "", "Petersen");
        Assertions.assertNotNull(employee);
        System.out.println(employee);
    }
}
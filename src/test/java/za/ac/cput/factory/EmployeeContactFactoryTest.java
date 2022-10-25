/**Test class EmployeeContactFactory.java
 * Test class for EmployeeContact factory
 * Author: Daniella Burgess (219446482)
 * Date: 11 October 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.EmployeeContact;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        EmployeeContact employeeContact = EmployeeContactFactory.build("03","0685678132", "test@gmail.com");
        Assertions.assertNotNull(employeeContact);
        System.out.println(employeeContact);

    }

    @Test
    public void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> EmployeeContactFactory.build("03","", "test@gmail.com"));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Contact number is null or empty", exceptionMessage);
    }

}

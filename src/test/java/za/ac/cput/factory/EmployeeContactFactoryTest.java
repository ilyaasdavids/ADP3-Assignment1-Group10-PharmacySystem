/**Test class ContactFactory.java
 * Test class for Contact factory
 * Author: Daniella Burgess (219446482)
 * Date: 11 October 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.EmployeeContactFactory;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Exception exception= Assertions.assertThrows(IllegalArgumentException.class,()-> EmployeeContactFactory.build("03","0685678132", "test@gmail.com"));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
        Assertions.assertSame("This is a valid email", exceptionMessage);
    }

    @Test
    public void buildWithError()
    {
        Exception exception= Assertions.assertThrows(IllegalArgumentException.class,()-> EmployeeContactFactory.build("03","", "test@gmail.com"));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
        Assertions.assertSame("Contact number or email is null or empty", exceptionMessage);
    }

}
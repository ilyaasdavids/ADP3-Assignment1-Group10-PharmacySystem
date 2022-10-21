/**Test class ContactFactory.java
 * Test class for Contact factory
 * Author: Daniella Burgess (219446482)
 * Date: 11 October 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.ContactFactory;
import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {
    @Test
    void buildWithSuccess()
    {
        Exception exception= Assertions.assertThrows(IllegalArgumentException.class,()-> ContactFactory.build("001", "vanilla01@gmail.com"));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
        Assertions.assertSame("This is a valid email", exceptionMessage);
    }

    @Test
    void buildWithError()
    {
        Exception exception= Assertions.assertThrows(IllegalArgumentException.class,()-> ContactFactory.build("", null));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
    }

}
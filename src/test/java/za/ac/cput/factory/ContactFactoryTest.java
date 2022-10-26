/**Test class ContactFactory.java
 * Test class for Contact factory
 * Author: Daniella Burgess (219446482)
 * Date: 11 October 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactFactoryTest {
    @Test
    void buildWithSuccess()
    {
        Contact contact = ContactFactory.build("0672664466", "219446482@mycput.ac.za" );
        Assertions.assertNotNull(contact);
        System.out.println(contact);

    }

    @Test
    void buildWithoutContactNumber()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> ContactFactory.build("", "vanilla@gmail.com"));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    void buildWithInvalidEmail()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> ContactFactory.build("0672664466", "vanilla#gmail,com"));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    void buildWithoutEmail()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> ContactFactory.build("0672664466", ""));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
    }

}

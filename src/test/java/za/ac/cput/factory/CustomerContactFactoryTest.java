package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CustomerContact;

public class CustomerContactFactoryTest {
    @Test
    @Order(1)
    public void buildWithError(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,()->
                CustomerContactFactory.createCustomerContact("01","0213552233", "Pharmacy@gmail.com"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }


    @Test
    @Order(2)
    public void buildWithSucess(){
        CustomerContact customerContact = CustomerContactFactory.createCustomerContact("01","0213552233", "Pharmacy@gmail.com");
        Assertions.assertNotNull(customerContact);
        System.out.println(customerContact);
    }
}

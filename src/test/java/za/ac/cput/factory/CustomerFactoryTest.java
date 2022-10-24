package za.ac.cput.factory;
import org.junit.jupiter.api.Assertions;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Name;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {
    Name name = NameFactory.build("Thabiso","Patrick", "Matsaba") ;

    @Test
    public void testCustomerWithSuccess() {
        Customer customer = CustomerFactory.createCustomer("220296006", "male", "Thabiso", "Patrick", "Matsaba");
        System.out.println(customer);
        Assertions.assertNotNull(customer);
    }

    @Test
    public void testCustomerWithNullId(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> CustomerFactory.createCustomer("220296006", "male", "Thabiso", "Patrick", "Matsaba"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        Assertions.assertSame("Customer is null", exceptionMessage);
    }
}
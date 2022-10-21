package za.ac.cput.factory;
import org.junit.jupiter.api.Assertions;
import za.ac.cput.domain.Name;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {
    @Test
    public void testNameWithSuccess() {
        Name name = NameFactory.build("Thabiso","Patrick", "Matsaba") ;
        System.out.println(name);
        Assertions.assertNotNull(name);
    }
    @Test
    public void testNameWithNullFirstName() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()->NameFactory.build("", "Patrick","Matsaba"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        Assertions.assertSame("First Name is null", exceptionMessage);
    }
    @Test
    public void testNameWithNullMiddleName(){
        Name name2 = NameFactory.build("Thabiso","", "Matsaba");
        Assertions.assertAll(
                ()-> Assertions.assertTrue(name2.getMiddleName().isEmpty()),
                ()-> Assertions.assertNotNull(name2)
        );
        System.out.println(name2);
    }

}
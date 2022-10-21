package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Pharmacy;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    @Test
    @Order(1)
    public void buildWithError(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,()->
                InventoryFactory.createInventory("01","100","150"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }


    @Test
    @Order(2)
    public void buildWithSuccess(){
        Inventory inventory = InventoryFactory.createInventory("01", "100", "150");
        Assertions.assertNotNull(inventory);
        System.out.println(inventory);
    }
}
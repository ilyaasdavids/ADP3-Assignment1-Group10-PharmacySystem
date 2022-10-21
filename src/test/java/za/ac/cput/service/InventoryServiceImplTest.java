package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Inventory;
import za.ac.cput.factory.InventoryFactory;


import static org.junit.jupiter.api.Assertions.*;

    @SpringBootTest
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class InventoryServiceImplTest {

        @Autowired
        InventoryService inventoryService;

        private final Inventory inventory = InventoryFactory.createInventory("01","100","150");

        @Order(1)
        @Test
        void save() {
            Inventory create1 = inventoryService.save(this.inventory);
            assertNotNull(create1);
            System.out.println(create1);
        }

        @Order(2)
        @Test
        void read() {
            Inventory read1 = inventoryService.read(inventory.getInventoryID());

            assertEquals(read1.getInventoryID(), inventory.getInventoryID());
            System.out.println(read1);

        }

        @Order(4)
        @Test
        void delete() {
            boolean success = inventoryService.delete(inventory.getInventoryID());
            assertTrue(success);
            System.out.println("Deleted: " + success);
        }

        @Order(3)
        @Test
        void getAll() {
            System.out.println(inventoryService.getAll());
        }
    }

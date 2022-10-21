/*SupplierFactoryTest.java
 * Factory Test class for Supplier
 * Author: Ilyaas Davids (219466242)
 * Date: 12 Oct 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {

    @Test
    @Order(1)
    void createSupplier() {
        Supplier supplier = SupplierFactory.createSupplier("7","ChemReacts");
        Assertions.assertNotNull(supplier);
        System.out.println(supplier);
    }
    @Test
    @Order(2)
    void createSupplierError() {
        Supplier supplier = SupplierFactory.createSupplier("","ChemReacts");
        Assertions.assertNotNull(supplier);
        System.out.println(supplier);
    }
}
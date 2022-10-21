/*MedicationFactoryTest.java
 * Factory Test class for Medication
 * Author: Ilyaas Davids (219466242)
 * Date: 12 Oct 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Medication;

import static org.junit.jupiter.api.Assertions.*;

class MedicationFactoryTest {

    @Test
    @Order(1)
    void createMedication() {
            Medication medication = MedicationFactory.createMedication("5","Allergex","Adcock Ingram","7");
            Assertions.assertNotNull(medication);
            System.out.println(medication);
        }
    @Test
    @Order(1)
    void createMedicationError() {
        Medication medication = MedicationFactory.createMedication("5","","Adcock Ingram","");
        Assertions.assertNotNull(medication);
        System.out.println(medication);
    }

    }


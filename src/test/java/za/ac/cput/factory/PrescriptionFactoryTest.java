package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Prescription;

import static org.junit.jupiter.api.Assertions.*;

class PrescriptionFactoryTest {

    @Test
    void testCreatePrescription() {
        Prescription prescription = PrescriptionFactory.createPrescription("001", "pain reliever", "2");
        Assertions.assertNotNull(prescription);
        System.out.println(prescription);
    }

    @Test
    void testCreatePrescriptionWithError() {
        Prescription prescription = PrescriptionFactory.createPrescription("001", "", "2");
        Assertions.assertNotNull(prescription);
        System.out.println(prescription);
    }
}
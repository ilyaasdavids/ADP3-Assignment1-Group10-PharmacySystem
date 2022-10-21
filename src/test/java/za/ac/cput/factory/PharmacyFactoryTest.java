package za.ac.cput.factory;

/* PharmacyFactoryTest.java
FactoryTest for the Pharmacy
Author: Waseem Dollie (216040566)
Date: 13 October 2022 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Pharmacy;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PharmacyFactoryTest {

        @Test
        @Order(1)
        public void buildWithError(){
            Exception exception = Assertions.assertThrows(IllegalArgumentException.class,()->
                    PharmacyFactory.build("123","DolliePharm","22", "32"));
            String exceptionMessage = exception.getMessage();
            System.out.println(exceptionMessage);
        }


        @Test
        @Order(2)
        public void buildWithSuccess(){
            Pharmacy pharmacy = PharmacyFactory.build("123", "DolliePharm", "22", "32");
            Assertions.assertNotNull(pharmacy);
            System.out.println(pharmacy);
        }
    }

package za.ac.cput.controller;
////
/* PharmacyControllerTest.java
ControllerTest for the Pharmacy
Author: Waseem Dollie (216040566)
Date: 15 October 2022 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.factory.PharmacyFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PharmacyControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private PharmacyController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private Pharmacy pharmacy;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        this.pharmacy = PharmacyFactory.build("123","DolliePharm","22", "32");
        this.baseUrl = "http://localhost:" + this.port + "/PharmacySystem/pharmacy/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Pharmacy> response = this.restTemplate
                .postForEntity(url, this.pharmacy, Pharmacy.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.pharmacy.getPharmId();
        System.out.println(url);
        ResponseEntity<Pharmacy>response=
                this.restTemplate.getForEntity(url,Pharmacy.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.pharmacy.getPharmId();
        System.out.println(url);
        this.restTemplate.delete(url,controller.delete(url));
    }

    @Order(3)
    @Test
    void findAll() {

        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Pharmacy[]>response=
                this.restTemplate.getForEntity(url,Pharmacy[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertTrue(response.getBody().length==1)
        );
    }
}

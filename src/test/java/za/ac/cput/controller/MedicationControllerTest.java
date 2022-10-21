package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Medication;
import za.ac.cput.factory.MedicationFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MedicationControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MedicationController medicationController;

    @Autowired
    private TestRestTemplate restTemplate;

    private String id;
    Medication medication;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.medication = MedicationFactory.createMedication("2","Allergex", "Adcock","7");
        this.baseUrl = "http://localhost:" + this.port + "/PharmacySystem/medication";
    }

    @Test
    @Order(3)
    void getAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        ResponseEntity<Medication[]> response=
                this.restTemplate.getForEntity(url,Medication[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        id = this.medication.getMedId();
        String url = baseUrl + "/find/" + id ;
        System.out.println(url);
        ResponseEntity<Medication> response = this.restTemplate.getForEntity(url, Medication.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
                );
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Medication> response = this.restTemplate
                .postForEntity(url,this.medication,Medication.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void update() {
    }

    @Test
    @Order(5)
    void delete() {
        id = this.medication.getMedId();
        String url = baseUrl + "/delete/" + id;
        System.out.println(url);
        this.restTemplate.delete(url,medicationController.delete(url));
    }
}
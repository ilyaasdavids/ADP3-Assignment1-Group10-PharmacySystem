package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.SupplierContact;
import za.ac.cput.factory.SupplierContactFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierContactControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private SupplierContactController supplierContactController;

    @Autowired
    private TestRestTemplate restTemplate;

    private String id;

    SupplierContact supplierContact;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.supplierContact = SupplierContactFactory.createSupplierContact("7","0846543214","219466424@mycput.ac.za");
        this.baseUrl = "http://localhost:" + this.port + "/PharmacySystem/supplier";
    }

    @Test
    @Order(3)
    void getAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        ResponseEntity<SupplierContact[]> response=
                this.restTemplate.getForEntity(url,SupplierContact[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        id = this.supplierContact.getSuppId();
        String url = baseUrl + "/find/" + id ;
        System.out.println(url);
        ResponseEntity<SupplierContact> response = this.restTemplate.getForEntity(url,SupplierContact.class);
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
        ResponseEntity<SupplierContact> response = this.restTemplate
                .postForEntity(url,this.supplierContact,SupplierContact.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void update() {
    }

    @Test
    @Order(5)
    void delete() {
        id = this.supplierContact.getSuppId();
        String url = baseUrl + "/delete/" + id;
        System.out.println(url);
        this.restTemplate.delete(url,supplierContactController.delete(url));
    }
}
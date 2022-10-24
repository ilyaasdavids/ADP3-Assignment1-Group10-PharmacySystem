package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CustomerControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private CustomerController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private Customer customer;

    private String baseUrl;

    @BeforeEach
    void setUp(){
        this.customer = CustomerFactory.createCustomer("220296006", "male", "Thabiso", "Patrick", "Matsaba");
        this.baseUrl = "http://localhost:" + this.port + "/PharmacySystem/customer/";
    }
    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Customer> response = this.restTemplate
                .postForEntity(url, this.customer, Customer.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.customer.getCustomerId();
        System.out.println(url);
        ResponseEntity<Customer>response=
                this.restTemplate.getForEntity(url,Customer.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.customer.getCustomerId();
        System.out.println(url);
        this.restTemplate.delete(url,controller.delete(url));
    }

    @Order(3)
    @Test
    void findAll() {

        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Customer[]>response=
                this.restTemplate.getForEntity(url,Customer[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertTrue(response.getBody().length==1)
        );
    }
}
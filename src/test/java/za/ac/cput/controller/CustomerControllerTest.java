package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.NameFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {CustomerControllerTest.class})
class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CustomerController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private Customer customer;
    private Name name;

    private String baseUrl;

    @BeforeEach
    void setup(){
        this.name = NameFactory.build("Thabiso", "Patrick", "Matsaba");
        this.customer = CustomerFactory.build("CUS101", name);
        this.baseUrl = "http://localhost:" + this.port + "/PharmacySystem/customer";
        assertNotNull(controller);

    }
    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Customer> response = this.restTemplate
                .postForEntity(url, this.customer, Customer.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url= baseUrl +"/read"+ customer.getCustomerId();
        System.out.println("URL: "+url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url,Customer.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

//    @Test
//    @Order(3)
//    void update(){
//        Customer updated = new Customer.Builder().copy(customer).customerId("CUS103").build();
//        String url= baseUrl +"/update";
//        System.out.println("URL: "+url);
//        System.out.println("Post data: "+updated);
//        ResponseEntity<Customer> response=restTemplate.postForEntity(url,updated,Customer.class);
//        assertNotNull(response.getBody());
//    }

    @Test
    @Order(3)
    void delete() {
        String url= baseUrl +"/delete/"+ customer.getCustomerId();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url= baseUrl +"/findAll";
        System.out.println(url);
        ResponseEntity<Customer[]> response = this.restTemplate.getForEntity(url, Customer[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
}
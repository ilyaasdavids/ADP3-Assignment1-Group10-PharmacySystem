/*EmployeeContactControllerTest.java
 *Test for the EmployeeContactController
 * Author: Daniella Burgess 219446482
 * Date: 17 October 2022
 */

package za.ac.cput.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.factory.EmployeeContactFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeContactControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private EmployeeContact employeeContact;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        this.employeeContact = EmployeeContactFactory.build("07", "0672664466", "2199446482@mycput.ac.za");
        this.baseUrl = "http://localhost:" + this.port + "/PharmacySystem/employeeContact/";
    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<EmployeeContact> response = this.restTemplate
                .postForEntity(url, this.employeeContact, EmployeeContact.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
       String url = baseUrl + "read/" + this.employeeContact.getStaffId();
        System.out.println(url);
        ResponseEntity<EmployeeContact>response = this.restTemplate.getForEntity(url, EmployeeContact.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.employeeContact.getStaffId();
        System.out.println(url);
        this.restTemplate.delete(url, controller.delete(url));
    }

    @Order(3)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<EmployeeContact[]>response = this.restTemplate.getForEntity(url, EmployeeContact[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertTrue(response.getBody().length==1)
        );
    }

}

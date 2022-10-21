///**
// * Author: Siphosethu Feni
// * Student Number: 217237614
// *  *  Group: 10
// * CustomerContactControllerTest.java
// */
//
//package za.ac.cput.Controller;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import za.ac.cput.domain.CustomerContact;
//import za.ac.cput.factory.CustomerContactFactory;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class CustomerContactControllerTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private final String BASE_URL = "http://localhost:8080/customer-contact";
//    private static CustomerContact customerContact = CustomerContactFactory.createCustomerContact("TW02", "M11");
//    private static String username = "siphosethu";
//    private static String password = "feni";
//
//    @Test
//    void a_save() {
//        System.out.println("Initial CustomerContact: " + customerContact);
//        String url = BASE_URL + "/save";
//        System.out.println("URL: "+url);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth(username, password);
//        HttpEntity<CustomerContact> entity = new HttpEntity<>(customerContact, headers);
//        ResponseEntity<CustomerContact> postResponse = restTemplate.exchange(url, HttpMethod.POST, entity, CustomerContact.class, headers);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
//        customerContact = postResponse.getBody();
//        assertEquals("M11", postResponse.getBody().getContactId());
//        System.out.println("Created: " + postResponse.getBody());
//    }
//
//    @Test
//    void b_find() {
//        String url = BASE_URL + "/find/" + customerContact.getId();
//        System.out.println("URL: " + url);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth(username, password);
//        HttpEntity<CustomerContact> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<CustomerContact> response = restTemplate.exchange(url, HttpMethod.GET, entity, CustomerContact.class);
//        assertNotNull(response);
//       // assertNotNull(response.getBody());
//        System.out.println("Read: " + response);
//        //System.out.println( "Read"  +   response.getBody());
//
//
//    }
//
//    @Test
//    void c_update() {
//        CustomerContact update = new CustomerContact.Builder().copy(customerContact).setContactId("911").build();
//        String url = BASE_URL + "/update";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth(username, password);
//        HttpEntity<CustomerContact> entity = new HttpEntity<>(update, headers);
//        ResponseEntity<CustomerContact> response = restTemplate.exchange(url, HttpMethod.POST, entity, CustomerContact.class);
//        assertNotNull(response);
//        assertNotNull(response.getBody());
//        System.out.println("Updated: " + response.getBody());
//    }
//
//    @Test
//    void d_delete() {
//        String url = BASE_URL + "/delete";
//        System.out.println("URL: " + url);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth(username, password);
//        HttpEntity<CustomerContact> entity = new HttpEntity<>(customerContact, headers);
//        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, Boolean.class);
//        assertNotNull(response);
//        assertNotNull(response.getBody());
//        System.out.println("Read: " + response.getBody());
//    }
//}
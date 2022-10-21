/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * ICustomerContactService.java
 */

package za.ac.cput.service;

import za.ac.cput.domain.CustomerContact;

import java.util.List;

public interface CustomerContactService extends IService<CustomerContact, String> {
    List<CustomerContact> getAll();
}

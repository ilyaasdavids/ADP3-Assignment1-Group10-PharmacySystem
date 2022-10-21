/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * CustomerContactFactory.java
 */

package za.ac.cput.factory;

import za.ac.cput.domain.CustomerContact;
import za.ac.cput.util.StringHelper;

public class CustomerContactFactory {
    public static CustomerContact createCustomerContact(String customerId, String contactId){

        if(StringHelper.isNullorEmpty(customerId) || StringHelper.isNullorEmpty(contactId))
            throw new IllegalArgumentException("Customer ID or Email is null or empty");

        return new CustomerContact.Builder().setCustomerId(customerId)
                .setContactId(contactId)
                .build();
    }
}

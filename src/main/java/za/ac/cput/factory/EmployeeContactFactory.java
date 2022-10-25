/**EmployeeContactFactory.java
 * Factory class for EmployeeContact domain
 * Author: Daniella Burgess (219446482)
 * Date: 29 September 2022
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.util.StringHelper;

public class EmployeeContactFactory {
    public static EmployeeContact build(String staffId, String contactNumber, String email)
    {
        if (StringHelper.isNullorEmpty(staffId))
            throw new IllegalArgumentException("Staff id is null or empty");

       Contact contact = ContactFactory.build(contactNumber, email);
       if (contact == null)
           throw new IllegalArgumentException("Contact number or email is null or empty");

        return new EmployeeContact.Builder().setStaffId(staffId)
                .setContact(contact)
                .build();
    }
}


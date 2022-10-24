package za.ac.cput.repository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/* CustomerRepository.java
 * IRepository for the Customer
 * Thabiso Matsaba 220296006
 * 08 April 2022
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
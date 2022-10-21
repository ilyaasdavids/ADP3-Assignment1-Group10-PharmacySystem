/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * IInventoryRepository.java
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {
}

/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * IInventoryService.java
 */

package za.ac.cput.service;


import za.ac.cput.domain.Inventory;

import java.util.List;

public interface InventoryService extends IService<Inventory, String> {
    List<Inventory> getAll();
}

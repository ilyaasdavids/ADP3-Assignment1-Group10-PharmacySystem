/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * InventoryController.java
 */

package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.service.InventoryServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/inventory")
@Slf4j
public class InventoryController {

    private final InventoryServiceImpl inventoryService;

    @Autowired
    public InventoryController(InventoryServiceImpl inventoryService){
        this.inventoryService = inventoryService;
    }

    @PostMapping("save")
    public ResponseEntity<Inventory> save(@Valid @RequestBody Inventory inventory){
        log.info("save request:{}", inventory);
        Inventory save = inventoryService.save(inventory);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{inventoryID}")
    public ResponseEntity<Inventory> read (@PathVariable String inventoryID){

        log.info("read request:{}", inventoryID);
        Inventory inventory = this.inventoryService.read(inventoryID);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("delete/{inventoryID}")
    public ResponseEntity<Inventory>delete(@PathVariable String inventoryID)
    {
        log.info("Read request:{}", inventoryID);
        this.inventoryService.delete(inventoryID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Inventory>>findAll(){
        List<Inventory>inventoryList = this.inventoryService.getAll();
        return ResponseEntity.ok(inventoryList);
    }

}

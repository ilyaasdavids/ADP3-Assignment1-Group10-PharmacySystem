package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository)
    {this.inventoryRepository = inventoryRepository;}

    @Override
    public Inventory save(Inventory inventory) {return this.inventoryRepository.save(inventory);}

    @Override
    public Inventory read(String s) {return this.inventoryRepository.findById(s).orElse(null);}

    @Override
    public boolean delete(String s) {
        if (this.inventoryRepository.existsById(s)) {
            this.inventoryRepository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Inventory> getAll() {return this.inventoryRepository.findAll();}
}

/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * Inventory.java
 */
package za.ac.cput.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Inventory implements Serializable {

    @Id
    private String inventoryID;
    private String tableStockAmount;
    private String medicineStockAmount;

    @Embedded
    private CustomerContact customerContact;

    protected Inventory(){}

    private Inventory(Builder builder) {
        this.inventoryID = builder.inventoryID;
        this.tableStockAmount = builder.tableStockAmount;
        this.medicineStockAmount = builder.medicineStockAmount;
    }

    public String getInventoryID() {
        return inventoryID;
    }

    public String getTableStockAmount() {
        return tableStockAmount;
    }

    public String getMedicineStockAmount() {
        return medicineStockAmount;
    }

    public CustomerContact getCustomerContact(){return customerContact;}

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", tableStockAmount=" + tableStockAmount +
                ", medicineStockAmount=" + medicineStockAmount +
                '}';
    }

    public static class Builder{
        private String inventoryID, tableStockAmount, medicineStockAmount;
        private CustomerContact customerContact;

        public Builder inventoryID(String inventoryID){
            this.inventoryID = inventoryID;
            return this;
        }

        public Builder tableStockAmount(String tableStockAmount){
            this.tableStockAmount = tableStockAmount;
            return this;
        }

        public Builder medicineStockAmount(String medicineStockAmount){
            this.medicineStockAmount = medicineStockAmount;
            return this;
        }

        public Builder customerContact(CustomerContact customerContact){
            this.customerContact= customerContact;
            return this;
        }

        public Inventory build(){
            return new Inventory(this);
        }
    }}

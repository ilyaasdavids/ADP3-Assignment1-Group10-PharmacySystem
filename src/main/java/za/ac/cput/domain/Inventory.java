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
    private String tabletStockAmount;
    private String medicineStockAmount;


    protected Inventory(){}

    private Inventory(Builder builder) {
        this.inventoryID = builder.inventoryID;
        this.tabletStockAmount = builder.tabletStockAmount;
        this.medicineStockAmount = builder.medicineStockAmount;
    }

    public String getInventoryID() {
        return inventoryID;
    }

    public String getTtabletStockAmount() {
        return tabletStockAmount;
    }

    public String getMedicineStockAmount() {
        return medicineStockAmount;
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", tabletStockAmount=" + tabletStockAmount +
                ", medicineStockAmount=" + medicineStockAmount +
                '}';
    }

    public static class Builder{
        private String inventoryID, tabletStockAmount, medicineStockAmount;

        public Builder inventoryID(String inventoryID){
            this.inventoryID = inventoryID;
            return this;
        }

        public Builder tabletStockAmount(String tabletStockAmount){
            this.tabletStockAmount = tabletStockAmount;
            return this;
        }

        public Builder medicineStockAmount(String medicineStockAmount){
            this.medicineStockAmount = medicineStockAmount;
            return this;
        }


        public Inventory build(){
            return new Inventory(this);
        }
    }}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_1;

import java.util.Objects;

/**
 *
 * @author Kasper
 */
public class ProductSaleLine {
    private Product products;
    private Integer amount;
    private Double totalCost;

    public ProductSaleLine(Product prod) {
        products = prod;
        amount = 1;
        totalCost = prod.getCost();
    }
    
    public void incProduct(){
        amount++;
        totalCost+= products.getCost();
    }

    public Product getProducts() {
        return products;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.products);
        hash = 17 * hash + Objects.hashCode(this.amount);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductSaleLine other = (ProductSaleLine) obj;
        if (!Objects.equals(this.products, other.products)) {
            return false;
        }
        return true;
    }
}

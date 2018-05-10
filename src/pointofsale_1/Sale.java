/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_1;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

/**
 *
 * @author Kasper
 */
public class Sale {
    private HashMap<Integer, ProductSaleLine> products;
    private Double totalCost;

    public Sale() {
        products = new HashMap<>();
        totalCost = 0.0;
    }

    public HashMap<Integer, ProductSaleLine> getProducts() {
        return products;
    }

    public Double getTotalCost() {
        return totalCost;
    }
    
    public void addProduct(Product prod){
        if(products.containsKey(prod.getCode())){
            products.get(prod.getCode()).incProduct();
        }
        else{
            ProductSaleLine saleLine = new ProductSaleLine(prod);
            products.put(saleLine.getProducts().getCode(), saleLine);
        }
        totalCost += prod.getCost();
    }
    
    public void clear(){
        products.clear();
        totalCost = 0.0;
    }
}

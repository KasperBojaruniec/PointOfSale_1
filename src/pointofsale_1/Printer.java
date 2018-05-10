/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_1;

import java.text.DecimalFormat;

/**
 *
 * @author Kasper
 */
public class Printer {
    public static String print(Sale sale){
        String result = "";
        for (ProductSaleLine prod : sale.getProducts().values()) {
            result += prod.getProducts().getName() + " x " + prod.getAmount() + "  cost:  " + prod.getProducts().getCost() + " x " + prod.getAmount() + " = " + Math.ceil(prod.getTotalCost()*100)/100 + "\n";
        }
        result += "Total cost: " + Math.ceil(sale.getTotalCost()*100)/100;
        return result;
    }
}

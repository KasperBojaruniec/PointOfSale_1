/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasper
 */
public class PrinterTest {
    
    public PrinterTest() {
    }

    /**
     * Test of print method, of class Printer.
     */
    @Test
    public void testPrint_1() {
        System.out.println("print_1");
        Sale sale = new Sale();
        String expResult = "Total cost: 0.0";
        String result = Printer.print(sale);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrint_2() {
        System.out.println("print_1");
        Sale sale = new Sale();
        sale.addProduct(new Product(1.0, "mango", 1));
        String expResult = "mango x 1  cost:  1.0 x 1 = 1.0\nTotal cost: 1.0";
        String result = Printer.print(sale);
        assertEquals(expResult, result);
    }
    
}

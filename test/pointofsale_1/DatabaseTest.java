/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_1;

import java.util.HashMap;
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
public class DatabaseTest {
    
    public DatabaseTest() {
    }

    /**
     * Test of findProductByID method, of class Database.
     */
    @Test
    public void testFindProductByID_1() throws Exception {
        System.out.println("findProductByID_1");
        String id = "1";
        Database instance = new Database();
        instance.addProduct(1, new Product(1.0, "", 1));
        try{
            assertEquals(instance.findProductByID(id), new Product(1.0, "", 1));
        }catch(AssertionError e){
            fail("testFindProductByID_1 failed");
        }
    }
    
    @Test
    public void testFindProductByID_2() throws Exception {
        System.out.println("findProductByID_2");
        String id = "";
        Database instance = new Database();
        instance.addProduct(1, new Product(1.0, "", 1));
        try{
            assertEquals(instance.findProductByID(id), new Product(1.0, "", 1));
            fail( "Should have thrown an exception" );
        }catch(Exception e){
            assertEquals(e.getMessage(), Database.INVALID_BARCODE_MESSEGE);
        }
    }
    
    @Test
    public void testFindProductByID_3() throws Exception {
        System.out.println("findProductByID_3");
        String id = "900091";
        Database instance = new Database();
        instance.addProduct(1, new Product(1.0, "", 1));
        try{
            assertEquals(instance.findProductByID(id), new Product(1.0, "", 1));
            fail( "Should have thrown an exception" );
        }catch(Exception e){
            assertEquals(e.getMessage(), Database.PRODUCT_NOT_FOUND_MESSEGE);
        }
    }
}

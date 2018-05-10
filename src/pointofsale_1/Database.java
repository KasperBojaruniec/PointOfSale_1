/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Kasper
 */
public class Database {
    
    public static final String INVALID_BARCODE_MESSEGE = "Invalid bar-code";
    public static final String DATABASE_FILENAME = "database.txt";
    public static final String PRODUCT_NOT_FOUND_MESSEGE = "Product not found";
    
    private HashMap<Integer, Product> data;

    public Product findProductByID(String id) throws Exception{
        if(id.equals("") || !(id.matches("[0-9]*"))){
            throw new Exception(INVALID_BARCODE_MESSEGE);
        }
        Integer id_int = Integer.parseInt(id);
        if(data.containsKey(id_int)){
            return data.get(id_int);
        }
        else{
            throw new Exception(PRODUCT_NOT_FOUND_MESSEGE);
        }
    }
    
    public Database() {
        data = new HashMap<>();
    }
    
    public void addProduct(Integer code, Product prod){
        data.put(code, prod);
    }

    public HashMap<Integer, Product> getData() {
        return data;
    }

    public void setData(HashMap<Integer, Product> data) {
        this.data = data;
    }
    
    public void loadData() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILENAME));
        String line;
        String[] info;
        while((line = reader.readLine())!= null){
            info = line.split(" ");
            Product prod = new Product(Double.parseDouble(info[1]), info[2].replace("_", " "), Integer.parseInt(info[0]));
            addProduct(prod.getCode(), prod);
        }
        reader.close();
    }
}

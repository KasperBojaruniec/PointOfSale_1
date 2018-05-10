/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Kasper
 */
public class FXMLprintController implements Initializable{

    @FXML
    private Label printLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
    public void init(String text){
        System.out.println(text);
        printLabel.setText(text);
    }
}

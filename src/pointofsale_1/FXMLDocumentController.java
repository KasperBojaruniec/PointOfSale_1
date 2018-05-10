/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Kasper
 */
public class FXMLDocumentController implements Initializable {
    private Database database;
    private Sale actualSale;
    private ObservableList data;
    public static final String VALID_INPUT_MESSEGE = "Product added";
            
    @FXML
    private Label label;
    @FXML
    private TextField id_input;
    @FXML
    private ListView list;
    @FXML
    private Label totalCostLabel;
    
    @FXML
    private void handlePrintAction(ActionEvent event) throws IOException {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLprint.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene((Pane) loader.load()));
            FXMLprintController controller = loader.<FXMLprintController>getController();
            controller.init(Printer.print(actualSale));
            stage.show();
            data.clear();
            actualSale.clear();
            totalCostLabel.setText("Total Cost: ");
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void handleScanAction(ActionEvent event) {
        try{
            actualSale.addProduct(database.findProductByID(id_input.getText()));
            data.add(database.findProductByID(id_input.getText()).getName() + " : " + database.findProductByID(id_input.getText()).getCost());
            label.setText(VALID_INPUT_MESSEGE);
            totalCostLabel.setText("Total Cost: " + (Math.ceil(actualSale.getTotalCost()*100)/100) + " PLN");
        }catch(Exception e){
            label.setText(e.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database = new Database();
        actualSale = new Sale();
        data = FXCollections.observableArrayList();
        list.setItems(data);
        try {
            database.loadData();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}



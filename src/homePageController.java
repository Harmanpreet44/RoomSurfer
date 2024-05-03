

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;


public class homePageController {

    @FXML
    private AnchorPane holderPane;
    AnchorPane home;
    @FXML
    void btnAddProperty(ActionEvent event) {
        holderPane.getChildren().clear();
        try
        {
           home=FXMLLoader.load(getClass().getResource("addPropertyController.fxml"));
           holderPane.getChildren().add((Node) home); 
        }catch(Exception ee){}
    }

    @FXML
    void btnAddClient(ActionEvent event){
        holderPane.getChildren().clear();
        try
        {
           home=FXMLLoader.load(getClass().getResource("AddClientController.fxml"));
           holderPane.getChildren().add((Node) home); 
        }catch(Exception ee){}

    }
    @FXML
    void btnBookProperty(ActionEvent event) {
        holderPane.getChildren().clear();
        try
        {
           home=FXMLLoader.load(getClass().getResource("bookingFormController.fxml"));
           holderPane.getChildren().add((Node) home); 
        }catch(Exception ee){}


    }

    @FXML
    void btnSearchProperty(ActionEvent event) {
        holderPane.getChildren().clear();
        try
        {
           home=FXMLLoader.load(getClass().getResource("searchController.fxml"));
           holderPane.getChildren().add((Node) home); 
        }catch(Exception ee){}

    }

}

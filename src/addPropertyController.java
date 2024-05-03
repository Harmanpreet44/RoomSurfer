import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class addPropertyController implements Initializable{

    @FXML
    private ComboBox<String> cmbLocation;

    @FXML
    private ComboBox<String> cmbPType;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtPropertyName;

    @FXML
    void btnSave(ActionEvent event) {
        try{
            Connection cn;
            PreparedStatement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking","root","");
            st=cn.prepareStatement("insert into rent_property(pname,location,address,property_type,price) values(?,?,?,?,?)");
            st.setString(1,txtPropertyName.getText());
            st.setString(2,cmbLocation.getSelectionModel().getSelectedItem().toString());
            st.setString(3,txtAddress.getText());
            st.setString(4,cmbPType.getSelectionModel().getSelectedItem().toString());
        
            st.setDouble(5,Double.parseDouble(txtPrice.getText()));
            int rs=st.executeUpdate();
            if(rs>0)
            {
               // System.out.println("You are succesfully Sign up");
            Alert x=new Alert(Alert.AlertType.INFORMATION);
            x.setHeaderText(null);
            x.setContentText("Property added Successfully");
            x.show();
            }
            else
            {
                Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText("Something went wrong while adding property");
                x.show();
            }
        }
        catch(Exception ee)
        {
            Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText(ee.getMessage());
                x.show();
          
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
        cmbLocation.getItems().addAll("Toronto","Brampton","Missuaga");
        cmbPType.getItems().addAll("Room","Houses","Basement");
    }

}

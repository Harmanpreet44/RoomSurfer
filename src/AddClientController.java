
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

public class AddClientController implements Initializable {

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtCName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhone;

    @FXML
    void btnSave(ActionEvent event) {
        try{
            Connection cn;
            PreparedStatement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking","root","");
            st=cn.prepareStatement("insert into client(cname,gender,phone,email,address) values(?,?,?,?,?)");
            st.setString(1,txtCName.getText());
            st.setString(2,cmbGender.getSelectionModel().getSelectedItem().toString());
            st.setString(3,txtPhone.getText());
            st.setString(4,txtEmail.getText());
        
            st.setString(5,txtAddress.getText());
            int rs=st.executeUpdate();
            if(rs>0)
            {
               // System.out.println("You are succesfully Sign up");
            Alert x=new Alert(Alert.AlertType.INFORMATION);
            x.setHeaderText(null);
            x.setContentText("Clien successfully Added");
            x.show();
            }
            else
            {
                Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText("Unable to Add Client");
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
      
        cmbGender.getItems().addAll("Male","Female");
        
    }

}

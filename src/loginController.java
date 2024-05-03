import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

public class loginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    void btnSignin(ActionEvent event) {

        try{
            Connection cn;
            PreparedStatement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking","root","");
            st=cn.prepareStatement("select * from users where email=? and password=?");
            st.setString(1,txtEmail.getText());
            st.setString(2,txtPassword.getText());
                      
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {  
                Stage st1= (Stage)txtEmail.getScene().getWindow();
                st1.hide();
              try{
                Stage stg=new Stage();
                Parent root=FXMLLoader.load(getClass().getResource("homePageController.fxml"));
                Scene sc=new Scene(root);
                stg.setScene(sc);
                stg.show();
                }catch(Exception ee){}
        
            }               
            
            else
            {
                Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText("Invalid UserName or password");
                x.show();
               
            }
        }
        catch(Exception ee)
        {  Alert x=new Alert(Alert.AlertType.ERROR);
            x.setHeaderText(null);
            x.setContentText(ee.getMessage());
            x.show();
          
        }


    }

    @FXML
    void btnSignup(ActionEvent event) {
      Stage st= (Stage)txtEmail.getScene().getWindow();
        st.hide();
      try{
        Stage stg=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("signupController.fxml"));
        Scene sc=new Scene(root);
        stg.setScene(sc);
        stg.show();
        }catch(Exception ee){}

    }

}

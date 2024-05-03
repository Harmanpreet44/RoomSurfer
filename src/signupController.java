import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
public class signupController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFname;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtPhone;
    @FXML
    private PasswordField pass;
    @FXML
    void btnSignup(ActionEvent event) {
        try{
            Connection cn;
            PreparedStatement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking","root","");
            st=cn.prepareStatement("insert into users(fname,lname,phone,email,location,password) values(?,?,?,?,?,?)");
            st.setString(1,txtFname.getText());
            st.setString(2,txtLName.getText());
            st.setString(3,txtPhone.getText());
            st.setString(4,txtEmail.getText());
            st.setString(5,txtLocation.getText());
            st.setString(6,pass.getText());
            int rs=st.executeUpdate();
            if(rs>0)
            {
               // System.out.println("You are succesfully Sign up");
            Alert x=new Alert(Alert.AlertType.INFORMATION);
            x.setHeaderText(null);
            x.setContentText("You are successfully Sign Up");
            x.show();
            }
            else
            {
                Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText("Signup process failed");
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

}

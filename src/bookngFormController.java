import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.Date;
public class bookngFormController {
    private int cid,pid;
    @FXML
    private TextArea txtCAddress;

    @FXML
    private TextField txtClientName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextArea txtPAddress;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtPropertyName;

    @FXML
    private TextField txtPropertyType;

    @FXML
    void btnClientSearch(ActionEvent event) {
        try{
            Connection cn;
            PreparedStatement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking","root","");
            st=cn.prepareStatement("select * from client where cname=?");
            st.setString(1,txtClientName.getText());
            
        
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {  cid=rs.getInt("cid");
               txtEmail.setText(rs.getString("email"));
               txtPhone.setText(rs.getString("phone"));
               txtCAddress.setText(rs.getString("address"));
            
            }
            else
            {
                Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText("Client Not Found");
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

    @FXML
    void btnPropertySearch(ActionEvent event) {
        try{
            Connection cn;
            PreparedStatement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking","root","");
            st=cn.prepareStatement("select * from rent_property where pname=?");
            st.setString(1,txtPropertyName.getText());
            
        
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {  pid=rs.getInt("pid");
               txtPropertyType.setText(rs.getString("property_type"));
               txtLocation.setText(rs.getString("location"));
               txtPAddress.setText(rs.getString("address"));
               txtPrice.setText(rs.getString("price"));
            
            }
            else
            {
                Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText("Property Not Found");
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

    @FXML
    void btnSave(ActionEvent event) {
Date d=new Date();
String dob=d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);


        try{
            Connection cn;
            PreparedStatement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking","root","");
            st=cn.prepareStatement("insert into booking(cid,pid,dob) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setInt(1,cid);
            st.setInt(2,pid);
            st.setString(3,dob);
           
            int rs=st.executeUpdate();
            ResultSet rs2=st.getGeneratedKeys();
            int bid=0;
            if(rs2.next())
            {
                bid=rs2.getInt(1);
            }
            if(rs>0)
            {
               // System.out.println("You are succesfully Sign up");
            Alert x=new Alert(Alert.AlertType.INFORMATION);
            x.setHeaderText(null);
            x.setContentText("Booking successfull your Booking id is "+bid);
            x.show();
            }
            else
            {
                Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText("Something went wrong while booking !");
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

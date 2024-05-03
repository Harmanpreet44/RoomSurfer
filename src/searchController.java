import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;


public class searchController implements Initializable{

    @FXML
    private TextField txtSearch;

    @FXML
    void btnSearch(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /*    data = FXCollections.observableArrayList();
        try{
            Connection cn;
            PreparedStatement st;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking","root","");
            st=cn.prepareStatement("select * from rent_property");
                   
            ResultSet rs=st.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                  final int j=1;
                  TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
                 col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param){
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }});
    
                tableview.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
         
           
        }
        catch(Exception ee)
        {
            Alert x=new Alert(Alert.AlertType.ERROR);
                x.setHeaderText(null);
                x.setContentText(ee.getMessage());
                x.show();
          
        }
        
        
*/
        
    }

}

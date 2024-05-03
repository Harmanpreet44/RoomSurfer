import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class App extends Application{
    public void start(Stage stg) throws Exception{

        Parent root=FXMLLoader.load(getClass().getResource("loginController.fxml"));
           Scene sc=new Scene(root);
           stg.setScene(sc);
           stg.show();
       }
    public static void main(String ap[])
    {
    launch(ap);
    }
    
}
package vista;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login_Excepcions extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    
    public static String retornaNom(TextField campTextUsuari) throws ExcepcioCampTextUsuari {
        String nom = campTextUsuari.getText();
        if (nom.length() == 0) {
            throw new ExcepcioCampTextUsuari();
        }
        return nom;
    }
    
     private static class ExcepcioCampTextUsuari extends Exception {
        String missatge = "El camp Usuari no pot estar buit!";
        public String getMissatge() {
            return missatge;
        }
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Login");
        GridPane graella = new GridPane();
        graella.setAlignment(Pos.CENTER);
        graella.setHgap(10);
        graella.setVgap(10);

        Text titolEscena = new Text("Login");
        titolEscena.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        graella.add(titolEscena, 0, 0, 2, 1);

        Label etiquetaUsuari = new Label("nom usuari:");
        graella.add(etiquetaUsuari, 0, 1);

        final TextField campTextUsuari = new TextField();
        graella.add(campTextUsuari, 1, 1);

        Label etiquetaPassword = new Label("Password:");
        graella.add(etiquetaPassword, 0, 2);

        final PasswordField campPassword = new PasswordField();
        graella.add(campPassword, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        graella.add(hbBtn, 1, 4);

        final Text textMissatge = new Text();
        graella.add(textMissatge, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                
                String nom = null;
                
                try {
                    nom = retornaNom(campTextUsuari);
                    textMissatge.setText("nom: " + nom);
                    System.out.println("\nnom: " + nom);
                } catch (ExcepcioCampTextUsuari ex) {
                    textMissatge.setText(ex.getMissatge());
                    System.err.println(ex.getMissatge());
                }
                
            }

        });

        Scene escena = new Scene(graella, 300, 275);
        stage.setScene(escena);
        stage.show();
    }

   
    
}

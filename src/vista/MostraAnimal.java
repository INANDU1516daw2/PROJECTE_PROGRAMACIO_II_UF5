package vista;

import controlador.XML_a_ArrayList;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Animal;

public class MostraAnimal extends Application {
    
    Stage window;
    Scene scene;
    Button btn;
    ListView <String> listView;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        final List <Animal> llistaMamifers = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);
        
        final List <Animal> llistaReptils = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Reptil", llistaReptils);
        
        final List <Animal> llistaAmfibis = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Amfibi", llistaAmfibis);
        
        final List <Animal> llistaPeixos = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Peixo", llistaPeixos);
        
        final List <Animal> llistaAus = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Au", llistaAus);
        
        final List <Animal> llistaArtropodes = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Artropode", llistaArtropodes);
        
        window = primaryStage;
        window.setTitle("Busca Animals");
        
        
        Label tipus_label = new Label("Tipus: ");
        final ChoiceBox <String> choiceBox = new ChoiceBox <>();
        choiceBox.getItems().addAll("Mamifer","Reptil","Amfibi","Au","Artropode","Peix");
        choiceBox.setValue("Mamifer");

        Label id_label = new Label("ID animal");
        final TextField id = new TextField();
        
        final Text nom = new Text();
        final Text raça = new Text();
        final Text edat = new Text();
        final Text sexe = new Text();
        final Text pes = new Text();
        final Text esp_vida = new Text();
        final Text vertebrat = new Text();
        final Text alimentacio = new Text();
        final Text reproduccio = new Text();
        final Text ecosistema = new Text();
        final Text vacuna_id = new Text();
        final Text seccio = new Text();
        
        String img_path = null;
        final Image img;
        ImageView imgView;
        
        btn = new Button("Ok");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                int ID = Integer.parseInt(id.getText());
                
                List <Animal> llista = null;
                
                String tipus = choiceBox.getValue();
                
        
                switch (tipus) {
                    case "Mamifer":
//                        img_path = "file:images/mamifer/";
                        llista = llistaMamifers;
                        break;
                    case "Reptil":
//                        img_path = "file:images/reptil/";
                        llista = llistaReptils;
                        break;
                    case "Amfibi":
//                        img_path = "file:images/amfibi/";
                        llista = llistaAmfibis;
                        break;
                    case "Au": 
//                        img_path = "file:images/au/";
                        llista = llistaAus;
                        break;
                    case "Artropode":
//                        img_path = "file:images/artropode/";
                        llista = llistaArtropodes;
                        break;
                    case "Peix":
//                        img_path = "file:images/peix/";
                        llista = llistaPeixos;
                        break;
                        
                }
//                    img = new Image("file:images/mamifer/" + id.getText() + ".jpg", 100, 100, true, true);
                
                nom.setText("Nom:   " + llista.get(ID).getNom());
                raça.setText("Raça:     " + llista.get(ID).getRaça());
                edat.setText("Edat:     " + String.valueOf(llista.get(ID).getEdat()));
                sexe.setText("Sexe:     " + llista.get(ID).getFemeni());
                pes.setText("Pes    " + String.valueOf(llista.get(ID).getPes()));
                esp_vida.setText("Esp_vida:     " + String.valueOf(llista.get(ID).getEsp_vida()));
                vertebrat.setText("Vertebrat:   " + llista.get(ID).getVertebrat());
                alimentacio.setText("Alimentacio:   " + llista.get(ID).getAlimentacio());
                reproduccio.setText("Reproduccio:   " + llista.get(ID).getReproduccio());
                ecosistema.setText("Ecosistema  " + llista.get(ID).getEcosistema());
                vacuna_id.setText("Vacuna-Id:   " + llista.get(ID).getVacuna_id());
                seccio.setText("Seccio:     " + String.valueOf(llista.get(ID).getSeccio()));
            }

        });
        
//        img_path = "file:images/mamifer/";
                
        img = new Image("file:images/mamifer/2.jpg", 100, 100, true, true);
        imgView = new ImageView(img);
        
        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(
                tipus_label, choiceBox, id_label, imgView, id, btn, nom, raça, edat, sexe, pes, 
                esp_vida, vertebrat, alimentacio, reproduccio, vacuna_id, seccio
        );
        
        scene = new Scene(layout, 250, 550);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

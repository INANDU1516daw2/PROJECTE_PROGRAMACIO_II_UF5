package vista;

import model.Animal;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import controlador.XML_a_ArrayList;
import java.util.LinkedList;
import javafx.scene.layout.VBox;
import static org.omg.IOP.CodecPackage.InvalidTypeForEncodingHelper.id;




public class  reproduirAnimalsFX extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    Stage window;
    Scene scene;
    Button btn;
    ListView <String> listView;

    @Override
    public void start(Stage primaryStage) {
        
        final Encarregat encargat_1 = new Encarregat("Morote", "E1", 1, 1700);
        Encarregat encargat_2 = new Encarregat("Ingemar", "E2", 2, 1600);
        Encarregat encargat_3 = new Encarregat("Marta", "E3", 3, 1900);
        Encarregat encargat_4 = new Encarregat("Yolo", "E4", 4, 1200);

        List <Encarregat> empleats = new LinkedList<>();
        
        empleats.add(encargat_1);   //sou: 1700
        empleats.add(encargat_2);   //sou: 1600
        empleats.add(encargat_3);   //sou: 1900
        empleats.add(encargat_4);   //sou: 1200
        
        
        
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
        window.setTitle("Reproduir Animals");
        
        
        Label tipus_label = new Label("Tipus: ");
        final ChoiceBox <String> choiceBox = new ChoiceBox <>();
        choiceBox.getItems().addAll("Mamifer","Reptil","Amfibi","Au","Artropode","Peix");
        choiceBox.setValue("Mamifer");

        Label id_pare = new Label("ID Pare");
        final TextField id_p = new TextField();
        
        Label id_mare = new Label("ID Mare");
        final TextField id_m = new TextField();
        
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
        
//        
        btn = new Button("Reproduir");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                int ID_p = Integer.parseInt(id_p.getText());
                int ID_m = Integer.parseInt(id_m.getText());
                
                List <Animal> llista = null;
                
                String tipus = choiceBox.getValue();
                
        
                switch (tipus) {
                    case "Mamifer":
                        llista = llistaMamifers;
                        break;
                    case "Reptil":
                        llista = llistaReptils;
                        break;
                    case "Amfibi":
                        llista = llistaAmfibis;
                        break;
                    case "Au": 
                        llista = llistaAus;
                        break;
                    case "Artropode":
                        llista = llistaArtropodes;
                        break;
                    case "Peix":
                        llista = llistaPeixos;
                        break;
                }
                
                encargat_1.reproduir(tipus, llista.get(ID_p), llista.get(ID_m), (ArrayList<Animal>) llista, "NouAnimal");
                
                System.out.println("tipus: "+tipus+"\nID_p: "+ID_p+" \nID_m: "+ID_m);
                System.out.println("nou animal id: " + (llista.size()-1) );
                
//              img = new Image("file:images/mamifer/" + id.getText() + ".jpg", 100, 100, true, true);
                
                nom.setText("Nom:   " + llista.get(llista.size()-1).getNom());
                raça.setText("Raça:     " + llista.get(llista.size()-1).getRaça());
                edat.setText("Edat:     " + String.valueOf(llista.get(llista.size()-1).getEdat()));
                sexe.setText("Sexe:     " + llista.get(llista.size()-1).getFemeni());
                pes.setText("Pes    " + String.valueOf(llista.get(llista.size()-1).getPes()));
                esp_vida.setText("Esp_vida:     " + String.valueOf(llista.get(llista.size()-1).getEsp_vida()));
                vertebrat.setText("Vertebrat:   " + llista.get(llista.size()-1).getVertebrat());
                alimentacio.setText("Alimentacio:   " + llista.get(llista.size()-1).getAlimentacio());
                reproduccio.setText("Reproduccio:   " + llista.get(llista.size()-1).getReproduccio());
                ecosistema.setText("Ecosistema  " + llista.get(llista.size()-1).getEcosistema());
                vacuna_id.setText("Vacuna-Id:   " + llista.get(llista.size()-1).getVacuna_id());
                seccio.setText("Seccio:     " + String.valueOf(llista.get(llista.size()-1).getSeccio()));
            }

        });
        
//        img_path = "file:images/mamifer/";
                
        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(
                tipus_label, choiceBox, id_pare, id_p, id_mare, id_m, btn,
                nom, raça, edat, sexe, pes,  esp_vida, vertebrat, alimentacio,
                reproduccio, vacuna_id, seccio
        );
        
        scene = new Scene(layout, 250, 550);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
            
            
}
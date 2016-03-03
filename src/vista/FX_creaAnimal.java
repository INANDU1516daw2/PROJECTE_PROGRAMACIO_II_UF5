package vista;

import controlador.CrearAnimal;
import model.Animal;
import controlador.XML_a_ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Mamifer;
import model.*;
import vista.Principal;
import controlador.CrearAnimal;
import controlador.XML_a_ArrayList;
import java.util.TreeSet;



/**
 * Inserció d'un nou animal a XML i a la llista amb JavaFX. La ID s'autoincrementa respecte a l'última id afegida.
 */
public class  FX_creaAnimal extends Application {
   
    TabPane mSuperior, mLateral;
    Tab sup1,sup2,lat1,lat2;
    GridPane dadesEditar,dadesVeure;
    SplitPane pDividit;
    
    Button guardar,esborrar;
    RadioButton masculi,femeni,vertebrat, invertebrat;
    TextField ID,nom,raça,edat,pes,esp_vida,seccio;
    ChoiceBox<String> ecosistema,alimentacio,reproduccio;
    ToggleGroup genere,tipusVertebrat;
    CheckBox rabia, colera, sifilis, parkinson;
   
    
    
    
    
    public static final ObservableList animals = FXCollections.observableArrayList();
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Creació dels elements propis del JavaFX aisí com la funcionalitat del codi
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        
        String node;
        mSuperior = new TabPane();
        mLateral = new TabPane();
        dadesEditar = new GridPane();
        final ListView llista = new ListView(animals);
       
        Group pSuperior = new Group();
        final ArrayList <Animal> llistaMamifers = new ArrayList <>();

            
            XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);
            
            final Encarregat encargat_1 = new Encarregat("Morote", "E1", 1, 1700);
            
             TreeSet <Vacuna> llistaVacunes = new TreeSet <>(new CuantitatVacunaComparator());
        Scene escena = new Scene(mSuperior,500,700);
        
        
        primaryStage.setTitle("Aplicació");
        primaryStage.setScene(escena);
        primaryStage.setResizable(true);
        primaryStage.show();
            System.out.println();
            sup1 = new Tab();
            sup1.setText("Tab 1");

            
            dadesEditar.setPadding(new Insets(10,10,10,10));
            dadesEditar.setVgap(8); 
            dadesEditar.setHgap(10); 
       
            
             final ChoiceBox tipus = new ChoiceBox<>();
                Label etiquetaTipus = new Label("Tipus");

                tipus.getItems().add("Amfibi");
                tipus.getItems().add("Artropode");
                tipus.getItems().add("Au");
                tipus.getItems().add("Mamifer");
                tipus.getItems().add("Peix");
                tipus.getItems().add("Reptil");


                GridPane.setConstraints(etiquetaTipus, 0, 1);
                GridPane.setConstraints(tipus, 1, 1);
                dadesEditar.getChildren().addAll(etiquetaTipus,tipus);

                
                final TextField nom = new TextField();
                nom.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaNom = new Label("Nom");
                nom.setEditable(true);
                GridPane.setConstraints(etiquetaNom, 0, 2);
                GridPane.setConstraints(nom, 1, 2);
                dadesEditar.getChildren().addAll(etiquetaNom, nom);


                final TextField raça = new TextField();
                raça.setAlignment(Pos.CENTER_RIGHT); 
                Label etiquetaRaça = new Label("Raça");
                raça.setEditable(true);
                GridPane.setConstraints(etiquetaRaça, 0, 3);
                GridPane.setConstraints(raça, 1, 3);
                dadesEditar.getChildren().addAll(etiquetaRaça, raça);
                

                final TextField edat = new TextField();
                edat.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaEdat = new Label("Edat");
                edat.setEditable(true);
                GridPane.setConstraints(etiquetaEdat, 0, 4);
                GridPane.setConstraints(edat, 1, 4);
                dadesEditar.getChildren().addAll(etiquetaEdat, edat);

                final TextField pes = new TextField();
                pes.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaPes = new Label("Pes");
                pes.setEditable(true);
                GridPane.setConstraints(etiquetaPes, 0, 5);
                GridPane.setConstraints(pes, 1, 5);
                dadesEditar.getChildren().addAll(etiquetaPes, pes);

                final ToggleGroup tipusVertebrat = new ToggleGroup();
                Label etiquetaVertebrat = new Label("Es vertebrat?");

                RadioButton vertebrat = new RadioButton("Vertebrat");
                vertebrat.setToggleGroup(tipusVertebrat);
                vertebrat.setUserData("vertebrat");

                RadioButton invertebrat = new RadioButton("Invertebrat");
                invertebrat.setToggleGroup(tipusVertebrat);
                invertebrat.setUserData("invertebrat");


                GridPane.setConstraints(etiquetaVertebrat, 0, 6);
                GridPane.setConstraints(vertebrat, 1, 6);
                GridPane.setConstraints(invertebrat, 2, 6);        
                dadesEditar.getChildren().addAll(etiquetaVertebrat,vertebrat,invertebrat);

                final TextField esp_vida = new TextField();
                esp_vida.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaEsp_vida = new Label("Esperança de Vida");
                esp_vida.setEditable(true);
                GridPane.setConstraints(etiquetaEsp_vida, 0, 7);
                GridPane.setConstraints(esp_vida, 1, 7);
                dadesEditar.getChildren().addAll(etiquetaEsp_vida, esp_vida);

                final TextField seccio = new TextField();
                seccio.setAlignment(Pos.CENTER_RIGHT);
                Label etiquetaSeccio = new Label("Seccio");
                seccio.setEditable(true);
                GridPane.setConstraints(etiquetaSeccio, 0, 8);
                GridPane.setConstraints(seccio, 1, 8);
                dadesEditar.getChildren().addAll(etiquetaSeccio, seccio);

                final ToggleGroup genere = new ToggleGroup();
                Label etiquetaGenere = new Label("Genere");

                final RadioButton femeni = new RadioButton("Femení");
                femeni.setToggleGroup(genere);
                femeni.setUserData("Femeni");

                final RadioButton masculi = new RadioButton("Masculí");
                masculi.setToggleGroup(genere);
                masculi.setUserData("Masculí");


                GridPane.setConstraints(etiquetaGenere, 0, 9);
                GridPane.setConstraints(femeni, 1, 9);
                GridPane.setConstraints(masculi, 2, 9);        
                dadesEditar.getChildren().addAll(etiquetaGenere,femeni,masculi);

                  
                final ChoiceBox alimentacio = new ChoiceBox<>();
                Label etiquetaAlimentacio = new Label("Alimentacio");

                alimentacio.getItems().add("Herbívor");
                alimentacio.getItems().add("Carnívor");
                alimentacio.getItems().add("Omnívor");

                alimentacio.setValue("Omnívor");

                GridPane.setConstraints(etiquetaAlimentacio, 0, 10);
                GridPane.setConstraints(alimentacio, 1, 10);
                dadesEditar.getChildren().addAll(etiquetaAlimentacio,alimentacio);

                final ChoiceBox  ecosistema = new ChoiceBox<>();
                Label etiquetaEcosistema = new Label("Ecosistema");

                ecosistema.getItems().add("Terrestre");
                ecosistema.getItems().add("Aeri");
                ecosistema.getItems().add("Aquàtic");

                ecosistema.setValue("Terrestre");

                GridPane.setConstraints(etiquetaEcosistema, 0, 11);
                GridPane.setConstraints(ecosistema, 1, 11);
                dadesEditar.getChildren().addAll(etiquetaEcosistema,ecosistema);

                final ChoiceBox  reproduccio = new ChoiceBox<>();
                Label etiquetaReproduccio = new Label("Reproducció");

                reproduccio.getItems().add("Ovíper");
                reproduccio.getItems().add("Vivíper");

                reproduccio.setValue("Vivíper");

                GridPane.setConstraints(etiquetaReproduccio, 0, 12);
                GridPane.setConstraints(reproduccio, 1, 12);
                dadesEditar.getChildren().addAll(etiquetaReproduccio,reproduccio);

                Label etiquetaVacunacio = new Label("Vacunes");

                rabia = new CheckBox("Rabia");
                colera = new CheckBox("Colera");
                sifilis = new CheckBox("Sifilis");
                parkinson = new CheckBox("Parkinson");

                GridPane.setConstraints(etiquetaVacunacio, 0, 13);
                GridPane.setConstraints(rabia, 1, 13);
                GridPane.setConstraints(colera, 1, 14);
                GridPane.setConstraints(sifilis, 1, 15);
                GridPane.setConstraints(parkinson, 1, 16);
                dadesEditar.getChildren().addAll(etiquetaVacunacio,rabia,colera,sifilis,parkinson);


                guardar= new Button("Guardar");
                esborrar = new Button("Esborrar");
               
                /**
                 * Codi resultant de premer el botó Guardar
                 */
                guardar.setOnAction(new EventHandler<ActionEvent>() {
                    
    
                    @Override public void handle(ActionEvent e) {
                        
                    
                        String fTipus=String.valueOf(tipus.getSelectionModel().selectedItemProperty().getValue());
                        String node=String.valueOf(tipus.getSelectionModel().selectedItemProperty().getValue())+"s";
                        String fNom=String.valueOf(nom.getCharacters());
                        String fEdat=String.valueOf(edat.getCharacters());
                        String fRaça=String.valueOf(raça.getCharacters());
                        String fPes=String.valueOf(pes.getCharacters());
                        String fVertebrat=tipusVertebrat.getSelectedToggle().getUserData().toString();
                        String fEspVida=String.valueOf(esp_vida.getCharacters());
                        String fSeccio=String.valueOf(seccio.getCharacters());
                        String fGenere=genere.getSelectedToggle().getUserData().toString();
                        String fAlimentacio=String.valueOf(alimentacio.getSelectionModel().selectedItemProperty().getValue());
                        String fEcosistema=String.valueOf(ecosistema.getSelectionModel().selectedItemProperty().getValue());
                        String fReproduccio=String.valueOf(reproduccio.getSelectionModel().selectedItemProperty().getValue());
                        String fId = String.valueOf(llistaMamifers.size());
                        String fVacuna = "M"+fId;
                        
                        
                        System.out.println(fTipus);
                        System.out.println(fRaça);
                        System.out.println(fEdat);
                        System.out.println(fPes);
                        System.out.println(fVertebrat);
                        System.out.println(fEspVida);
                        System.out.println(fSeccio);
                        System.out.println(fGenere);
                        System.out.println(fAlimentacio);
                        System.out.println(fEcosistema);
                        System.out.println(fReproduccio);
                        
                        System.out.println("Rabia: "+rabia.isSelected());
                        System.out.println("Coelra: "+colera.isSelected());
                        System.out.println("Sífilis: "+sifilis.isSelected());
                        System.out.println("Párkinson: "+parkinson.isSelected());

                        CrearAnimal.CrearAnimal(node, fTipus, String.valueOf(fId), fNom, fRaça, fEdat, fGenere, fPes, fEspVida, fVertebrat, fAlimentacio, fReproduccio, fEcosistema, fVacuna, fSeccio);
                        if(rabia.isSelected()){
                            encargat_1.Vacunar("Vacunes", "Vacuna", fVacuna, "rabia");
                        }
                        if(colera.isSelected()){
                            encargat_1.Vacunar("Vacunes", "Vacuna", fVacuna, "colera");
                        }
                        if(sifilis.isSelected()){
                            encargat_1.Vacunar("Vacunes", "Vacuna", fVacuna, "sifilis");
                        }
                        if(parkinson.isSelected()){
                            encargat_1.Vacunar("Vacunes", "Vacuna", fVacuna, "parkinson");
                        }
                        
                        
                        
    }
});
                
                GridPane.setConstraints(guardar, 1, 17);
                GridPane.setConstraints(esborrar, 2, 17);
                dadesEditar.getChildren().addAll(guardar,esborrar);
                
            sup1.setContent(dadesEditar); 
            mSuperior.getTabs().add(sup1);
                     
            sup2 = new Tab();
            sup2.setText("Tab 2");
            
            dadesVeure = new GridPane();
           
            
        }
            
       
    
    }




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




public class  reproduirAnimalsFX extends Application {
   
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
        final int fId = llistaMamifers.size();
        final String fVacuna = "M"+fId;
        
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
       
                final ChoiceBox mascle = new ChoiceBox<>();
                Label etiquetaMascle = new Label("Mascle");
                
                final ChoiceBox femella = new ChoiceBox<>();
                Label etiquetaFemella = new Label("Femella");
                int countM=0;
                int countF=0;
                for(int i=0;i<llistaMamifers.size();i++){
                    if("M".equals(llistaMamifers.get(i).getFemeni())){
                        countM++;
                    }
                    else if("F".equals(llistaMamifers.get(i).getFemeni())){
                        countF++;
                    }
                }
                String[] masculins = new String[countM];
                String[] femenins = new String[countF];
                
                
                for(int i=0, numM=0, numF=0;i<llistaMamifers.size();i++){
                    if("M".equals(llistaMamifers.get(i).getFemeni())){
                        masculins[numM]=llistaMamifers.get(i).getNom();
                        mascle.getItems().add(masculins[numM]);
                        numM++;
                    
                    }
                    else if("F".equals(llistaMamifers.get(i).getFemeni())){
                        femenins[numF]=llistaMamifers.get(i).getNom();
                        femella.getItems().add(femenins[numF]);
                        numF++;
                    }
                    
                }              

                
                GridPane.setConstraints(etiquetaMascle, 0, 10);
                GridPane.setConstraints(mascle, 0, 11);
                dadesEditar.getChildren().addAll(etiquetaMascle,mascle);
                GridPane.setConstraints(etiquetaFemella, 6, 10);
                GridPane.setConstraints(femella, 6, 11);
                dadesEditar.getChildren().addAll(etiquetaFemella,femella);

                guardar= new Button("Guardar");
                esborrar = new Button("Esborrar");
                esborrar.setOnAction(new EventHandler<ActionEvent>() {
                    
    
                    @Override public void handle(ActionEvent e) {
                        
                    /////////////////////////////////////////////////////////////////////////////////////////////////
                        //Esto guarda en String mare el nombre de la femella seleccionada. Hay que recuperar todos los
                        //datos del animal con nombre "mare", para que el hijo los herede.
                        String mare=String.valueOf(femella.getSelectionModel().selectedItemProperty().getValue());
                        System.out.println(mare);
                
                
                
                    }
                });
                
                guardar.setOnAction(new EventHandler<ActionEvent>() {
                    
    
                    @Override public void handle(ActionEvent e) {
                        //String mare=
                    
                        //String fTipus=String.valueOf(tipus.getSelectionModel().selectedItemProperty().getValue());
                        //String node=String.valueOf(tipus.getSelectionModel().selectedItemProperty().getValue())+"s";
//                       String fNom=String.valueOf(nom.getCharacters());
//                        String fEdat=String.valueOf(edat.getCharacters());
//                        //String fRaça=String.valueOf();
//                        String fPes=String.valueOf(pes.getCharacters());
//                        String fVertebrat=tipusVertebrat.getSelectedToggle().getUserData().toString();
//                        String fEspVida=String.valueOf(esp_vida.getCharacters());
//                        String fSeccio=String.valueOf(seccio.getCharacters());
//                        String fGenere=genere.getSelectedToggle().getUserData().toString();
//                        String fAlimentacio=String.valueOf(alimentacio.getSelectionModel().selectedItemProperty().getValue());
//                        String fEcosistema=String.valueOf(ecosistema.getSelectionModel().selectedItemProperty().getValue());
//                        String fReproduccio=String.valueOf(reproduccio.getSelectionModel().selectedItemProperty().getValue());
//                        
//                       
//                        //System.out.println(fTipus);
//                        //System.out.println(fRaça);
//                        System.out.println(fEdat);
//                        System.out.println(fPes);
//                        System.out.println(fVertebrat);
//                        System.out.println(fEspVida);
//                        System.out.println(fSeccio);
//                        System.out.println(fGenere);
//                        System.out.println(fAlimentacio);
//                        System.out.println(fEcosistema);
//                        System.out.println(fReproduccio);
//                        
//                        System.out.println("Rabia: "+rabia.isSelected());
//                        System.out.println("Coelra: "+colera.isSelected());
//                        System.out.println("Sífilis: "+sifilis.isSelected());
//                        System.out.println("Párkinson: "+parkinson.isSelected());
//                       
                       // CrearAnimal.CrearAnimal("Mamifers", "Mamifer", String.valueOf(fId), "Nuevo", fRaça, fEdat, fGenere, fPes, fEspVida, fVertebrat, fAlimentacio, fReproduccio, fEcosistema, fVacuna, fSeccio);
                        
                        
                        
                        
    }
});
                GridPane.setConstraints(guardar, 1, 17);
                GridPane.setConstraints(esborrar, 2, 17);
                dadesEditar.getChildren().addAll(guardar,esborrar);
//final contingut tab1
                
            sup1.setContent(dadesEditar); // contingut de la tab1
            mSuperior.getTabs().add(sup1); //afegeix la tab1 al panell d tabs
//inici contingut tab2
                     
            sup2 = new Tab();
            sup2.setText("Tab 2");
            
            dadesVeure = new GridPane();
            
            // Se crea un panel dividido verticalmente
            pDividit = new SplitPane(llista,dadesVeure);
        
            //Inic contingut esquerra llista
            
            //Creacio ArrayList buit
           
            
            
        }
           

    
    }




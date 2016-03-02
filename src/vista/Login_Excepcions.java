package vista;

import controlador.CrearAnimal;
import controlador.Lectura_per_ID;
import controlador.XML_a_ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Animal;
import model.Encarregat;
import model.Vacuna;
import static vista.Interficie.animals;

public class Login_Excepcions extends Application {
    public static final ObservableList animals = FXCollections.observableArrayList();
    Scene scene2;
    public static void main(String[] args) {
        launch(args);
    }

    //******************* Clases Excepcions Personalitzades ******************/
    
    public static boolean validacioLogin(TextField user, PasswordField password) throws ExcepcioCampTextUsuari, ExcepcioCampTextPassword {
        boolean valid = true;
        String nom = user.getText();
        String pass = password.getText();
        
        if (nom.length() == 0) {
            valid = false;
            throw new ExcepcioCampTextUsuari();
        }
        if (pass.length() == 0) {
            valid = false;
            throw new ExcepcioCampTextPassword();
        }
        
        return valid;
    }
    
    
     private static class ExcepcioCampTextUsuari extends Exception {
        String missatge = "El camp Usuari no pot estar buit!";
        public String getMissatge() {
            return missatge;
        }
    }
    
    private static class ExcepcioCampTextPassword extends Exception {
        String missatge = "El camp Password no pot estar buit!";
        public String getMissatge() {
            return missatge;
        }
   }
     
    //********************************* FX *************************************/

    @Override
    public void start(final Stage stage) {
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
                
                try {

                    boolean loginValid = validacioLogin(campTextUsuari, campPassword);
                    if (loginValid){
                        System.out.println("Validacio correcte !");
                        //textMissatge.setText("Validacio correcte !");
                         stage.setScene(scene2);
                       
                    }else{
                        System.out.println("Validacio incorrecte !");
                        textMissatge.setText("Validacio incorrecte !");
                    }

                } catch (ExcepcioCampTextUsuari ex) {
                    textMissatge.setText(ex.getMissatge());
                    System.err.println(ex.getMissatge());
                } catch (ExcepcioCampTextPassword ex) {
                    textMissatge.setText(ex.getMissatge());
                    System.err.println(ex.getMissatge());
                }
                
            }

        });
//
StackPane fons = new StackPane();
TabPane tabs = new TabPane();
GridPane dadesEditar = new GridPane();
 
ArrayList <Animal> llistaMamifers = new ArrayList <>();
ArrayList <Animal> llistaArtropodes = new ArrayList <>();
ArrayList <Animal> llistaAus = new ArrayList <>();
ArrayList <Animal> llistaAmfibis = new ArrayList <>();
ArrayList <Animal> llistaPeixos = new ArrayList <>();
ArrayList <Animal> llistaReptils = new ArrayList <>();
  
   
//Per vuere la llista de mamifers
//Creacio coleccio objectes mamifers a partir de la lectura Mamifers.xml
XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);
XML_a_ArrayList.RecuperaDades("Artropode", llistaArtropodes);
XML_a_ArrayList.RecuperaDades("Au", llistaAus);
XML_a_ArrayList.RecuperaDades("Amfibi", llistaAmfibis);
XML_a_ArrayList.RecuperaDades("Reptil", llistaReptils);
XML_a_ArrayList.RecuperaDades("Peix", llistaPeixos);

        final int fId = llistaMamifers.size();
        final String fVacuna = "M"+fId;
        
final Encarregat encargat_1 = new Encarregat("Morote", "E1", 1, 1700);
            
TreeSet <Vacuna> llistaVacunes = new TreeSet <>(new CuantitatVacunaComparator());

dadesEditar.setPadding(new Insets(10,10,10,10));
dadesEditar.setVgap(8); //Vertial spacing
dadesEditar.setHgap(10); //Horizontal spacing

//////////// crea els camps de Texts
final ChoiceBox tipus = new ChoiceBox<>();
Label etiquetaTipus = new Label("Tipus");

//getItems returns the Observable object wich u can add items to
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
                raça.setAlignment(Pos.CENTER_RIGHT); //alinea el text a la dreta dins del TextField
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
                
                 //////////// radiobutton sexe
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

                //////////// radiobutton sexe
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

                  
                //////////// crea desplegable i etiqueta
                final ChoiceBox alimentacio = new ChoiceBox<>();
                Label etiquetaAlimentacio = new Label("Alimentacio");

                //getItems returns the Observable object wich u can add items to
                alimentacio.getItems().add("Herbívor");
                alimentacio.getItems().add("Carnívor");
                alimentacio.getItems().add("Omnívor");

                //Set default value
                alimentacio.setValue("Omnívor");

                GridPane.setConstraints(etiquetaAlimentacio, 0, 10);
                GridPane.setConstraints(alimentacio, 1, 10);
                dadesEditar.getChildren().addAll(etiquetaAlimentacio,alimentacio);
                
               //////////// crea desplegable i etiqueta
                final ChoiceBox  ecosistema = new ChoiceBox<>();
                Label etiquetaEcosistema = new Label("Ecosistema");

                //getItems returns the Observable object wich u can add items to
                ecosistema.getItems().add("Terrestre");
                ecosistema.getItems().add("Aeri");
                ecosistema.getItems().add("Aquàtic");

                //Set default value
                ecosistema.setValue("Terrestre");

                GridPane.setConstraints(etiquetaEcosistema, 0, 11);
                GridPane.setConstraints(ecosistema, 1, 11);
                dadesEditar.getChildren().addAll(etiquetaEcosistema,ecosistema);

                //////////// crea desplegable i etiqueta
                final ChoiceBox  reproduccio = new ChoiceBox<>();
                Label etiquetaReproduccio = new Label("Reproducció");

                //getItems returns the Observable object wich u can add items to
                reproduccio.getItems().add("Ovíper");
                reproduccio.getItems().add("Vivíper");

                //Set default value
                reproduccio.setValue("Vivíper");

                GridPane.setConstraints(etiquetaReproduccio, 0, 12);
                GridPane.setConstraints(reproduccio, 1, 12);
                dadesEditar.getChildren().addAll(etiquetaReproduccio,reproduccio);
                
               ////////////radiobutton vacuna
                //vacunacio = new Check<>();
                Label etiquetaVacunacio = new Label("Vacunes");

                final CheckBox rabia = new CheckBox("Rabia");
                final CheckBox colera = new CheckBox("Colera");
                //colera.setSelected(true); //per defecte aquesta apareix marcada
                final CheckBox sifilis = new CheckBox("Sifilis");
                final CheckBox parkinson = new CheckBox("Parkinson");

                GridPane.setConstraints(etiquetaVacunacio, 0, 13);
                GridPane.setConstraints(rabia, 1, 13);
                GridPane.setConstraints(colera, 1, 14);
                GridPane.setConstraints(sifilis, 1, 15);
                GridPane.setConstraints(parkinson, 1, 16);
                dadesEditar.getChildren().addAll(etiquetaVacunacio,rabia,colera,sifilis,parkinson);

//////////// Crea botons i els hi aplica el seu símbol
 Button guardar= new Button("Guardar");
Button esborrar = new Button("Esborrar");

            //Per vuere la llista de mamifers
            //Creacio coleccio objectes mamifers a partir de la lectura Mamifers.xml
            //XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);
                
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
                        
                        /*if (String.valueOf(tipus.getSelectionModel().selectedItemProperty().getValue())==null ||
                                String.valueOf(tipus.getSelectionModel().selectedItemProperty().getValue())+"s"==null ||
                                String.valueOf(nom.getCharacters())==null ||
                                String.valueOf(edat.getCharacters())==null ||
                                String.valueOf(raça.getCharacters())==null ||
                                String.valueOf(pes.getCharacters())==null ||
                                tipusVertebrat.getSelectedToggle().getUserData().toString()==null ||
                                String.valueOf(esp_vida.getCharacters())==null||
                                String.valueOf(seccio.getCharacters())==null ||
                                genere.getSelectedToggle().getUserData().toString()==null ||
                                String.valueOf(alimentacio.getSelectionModel().selectedItemProperty().getValue())==null ||
                                String.valueOf(ecosistema.getSelectionModel().selectedItemProperty().getValue()) == null ||
                                String.valueOf(reproduccio.getSelectionModel().selectedItemProperty().getValue())==null) {
                            System.out.println("Falten dades");
                    }else{*/
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
                        //}
    //XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);
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


Tab tab1 = new Tab("Crear Animal");
tab1.setContent(dadesEditar); // contingut de la tab1
tabs.getTabs().add(tab1); //afegeix la tab1 al panell d tabs

// Se crea un panel dividido verticalmente
GridPane cercaAnimal = new GridPane();
final ListView llista = new ListView(animals);
SplitPane pDividit = new SplitPane(llista,cercaAnimal);
        
//Inic contingut esquerra llista
            
//Iterador per poder recorrer l'ArrayList
Iterator <Animal> mamifer_iterador = llistaMamifers.iterator();
Iterator <Animal> artropode_iterador = llistaArtropodes.iterator();
Iterator <Animal> au_iterador = llistaAus.iterator();
Iterator <Animal> amfibi_iterador = llistaAmfibis.iterator();
Iterator <Animal> reptil_iterador = llistaReptils.iterator();
Iterator <Animal> peix_iterador = llistaPeixos.iterator();
llista.setEditable(false);

            
            while(mamifer_iterador.hasNext()){

            animals.add("Mamifer "+mamifer_iterador.next().getId());
            //animals.add("Mamifer"+mamifer_iterador.next().getId());
            //llista.setCellFactory(ComboBoxListCell.forListView(cursos));
        }
                        while(artropode_iterador.hasNext()){

            animals.add("Artropode "+artropode_iterador.next().getId());
            //animals.add("Mamifer"+mamifer_iterador.next().getId());
            //llista.setCellFactory(ComboBoxListCell.forListView(cursos));
            
        }
            while(au_iterador.hasNext()){

            animals.add("Au "+au_iterador.next().getId());
            //animals.add("Mamifer"+mamifer_iterador.next().getId());
            //llista.setCellFactory(ComboBoxListCell.forListView(cursos));
            
        }
            while(amfibi_iterador.hasNext()){

            animals.add("Amfibi "+amfibi_iterador.next().getId());
            //animals.add("Mamifer"+mamifer_iterador.next().getId());
            //llista.setCellFactory(ComboBoxListCell.forListView(cursos));
            
        }
            while(peix_iterador.hasNext()){

            animals.add("Peix "+peix_iterador.next().getId());
            //animals.add("Mamifer"+mamifer_iterador.next().getId());
            //llista.setCellFactory(ComboBoxListCell.forListView(cursos));
            
        }
            while(reptil_iterador.hasNext()){

            animals.add("Reptil "+reptil_iterador.next().getId());
            //animals.add("Mamifer"+mamifer_iterador.next().getId());
            //llista.setCellFactory(ComboBoxListCell.forListView(cursos));
            
        }

            llista.setItems(animals);


Label eCercaId = new Label("Cerca ID: ");
TextField fCercaId = new TextField("Introdueix el ID a cercar");
Button bCercaId = new Button("Cercar");
GridPane.setConstraints(eCercaId, 0, 1);
GridPane.setConstraints(fCercaId, 1, 1);
GridPane.setConstraints(bCercaId, 2, 1);
cercaAnimal.getChildren().addAll(eCercaId,fCercaId,bCercaId);

///*****************************************************///
//AFEGIR AQUI CODI DE LECTURA I ESCRIPTURA DE DADES ANIMALS
///*****************************************************///
Tab tab2 = new Tab("Cercar Animals");
tab2.setContent(pDividit); // contingut de la tab1
tabs.getTabs().add(tab2); //afegeix la tab1 al panell d tabs

fons.getChildren().add(tabs);
scene2 = new Scene(fons, 500,700);
 //
 Scene escena = new Scene(graella, 500,700);
        stage.setScene(escena);
        stage.show();
    }
   

    
}

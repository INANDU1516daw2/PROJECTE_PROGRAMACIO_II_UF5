package vista;

import controlador.CrearAnimal;
import controlador.XML_a_Objeto_TreeSet;
import controlador.XML_a_ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        
        if(pass.equals("nolose")){
            valid = true;
        }else {
            valid = false;
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
        
        final Encarregat encargat_1 = new Encarregat("Morote", "E1", 1, 1700);
        Encarregat encargat_2 = new Encarregat("Ingemar", "E2", 2, 1600);
        Encarregat encargat_3 = new Encarregat("Marta", "E3", 3, 1900);
        Encarregat encargat_4 = new Encarregat("Yolo", "E4", 4, 1200);

        List <Encarregat> empleats = new LinkedList<>();
        
        empleats.add(encargat_1);   //sou: 1700
        empleats.add(encargat_2);   //sou: 1600
        empleats.add(encargat_3);   //sou: 1900
        empleats.add(encargat_4);   //sou: 1200
        
        
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
                        if(loginValid){
                             stage.setScene(scene2);
                        }
                       
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
 
final ArrayList <Animal> llistaMamifers = new ArrayList <>();
final ArrayList <Animal> llistaArtropodes = new ArrayList <>();
final ArrayList <Animal> llistaAus = new ArrayList <>();
final ArrayList <Animal> llistaAmfibis = new ArrayList <>();
final ArrayList <Animal> llistaPeixos = new ArrayList <>();
final ArrayList <Animal> llistaReptils = new ArrayList <>();
  
   
//Per vuere la llista de mamifers
//Creacio coleccio objectes mamifers a partir de la lectura Mamifers.xml
XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);
XML_a_ArrayList.RecuperaDades("Artropode", llistaArtropodes);
XML_a_ArrayList.RecuperaDades("Au", llistaAus);
XML_a_ArrayList.RecuperaDades("Amfibi", llistaAmfibis);
XML_a_ArrayList.RecuperaDades("Reptil", llistaReptils);
XML_a_ArrayList.RecuperaDades("Peixo", llistaPeixos);

        final int fId = llistaMamifers.size();
        final String fVacuna = "M"+fId;
        
   
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
                            Encarregat.Vacunar("Vacunes", "Vacuna", fVacuna, "rabia");
                        }
                        if(colera.isSelected()){
                            Encarregat.Vacunar("Vacunes", "Vacuna", fVacuna, "colera");
                        }
                        if(sifilis.isSelected()){
                            Encarregat.Vacunar("Vacunes", "Vacuna", fVacuna, "sifilis");
                        }
                        if(parkinson.isSelected()){
                            Encarregat.Vacunar("Vacunes", "Vacuna", fVacuna, "parkinson");
                        }
                        
                        
                        
    }
});
                

GridPane.setConstraints(guardar, 1, 17);
dadesEditar.getChildren().addAll(guardar);


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

///*****************************************************///
//AFEGIR AQUI CODI DE LECTURA I ESCRIPTURA DE DADES ANIMALS
Label tipus_label = new Label("Tipus: ");
final ChoiceBox <String> choiceBox = new ChoiceBox <>();
choiceBox.getItems().addAll("Mamifer","Reptil","Amfibi","Au","Artropode","Peix");
choiceBox.setValue("Mamifer");
GridPane.setConstraints(tipus_label, 0, 1);
GridPane.setConstraints(choiceBox, 1, 1);
cercaAnimal.getChildren().addAll(tipus_label,choiceBox);

Label id_label = new Label("ID animal");
final TextField id = new TextField();
        
        final Text nom_animal = new Text();
        final Text raça_animal = new Text();
        final Text edat_animal = new Text();
        final Text sexe_animal = new Text();
        final Text pes_animal = new Text();
        final Text esp_vida_animal = new Text();
        final Text vertebrat_animal = new Text();
        final Text alimentacio_animal = new Text();
        final Text reproduccio_animal = new Text();
        final Text ecosistema_animal = new Text();
        final Text vacuna_id_animal = new Text();
        final Text seccio_animal = new Text();
        
  

        String img_path = null;
        final Image img;
        ImageView imgView;
        
GridPane.setConstraints(id_label, 0, 2);
GridPane.setConstraints(id, 1, 2);
        
        btn = new Button("Ok");
GridPane.setConstraints(btn, 2, 2);  
cercaAnimal.getChildren().addAll(id_label,id,btn);



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
                
                nom_animal.setText("Nom:   " + llista.get(ID).getNom());
                raça_animal.setText("Raça:     " + llista.get(ID).getRaça());
                edat_animal.setText("Edat:     " + String.valueOf(llista.get(ID).getEdat()));
                sexe_animal.setText("Sexe:     " + llista.get(ID).getFemeni());
                pes_animal.setText("Pes    " + String.valueOf(llista.get(ID).getPes()));
                esp_vida_animal.setText("Esp_vida:     " + String.valueOf(llista.get(ID).getEsp_vida()));
                vertebrat_animal.setText("Vertebrat:   " + llista.get(ID).getVertebrat());
                alimentacio_animal.setText("Alimentacio:   " + llista.get(ID).getAlimentacio());
                reproduccio_animal.setText("Reproduccio:   " + llista.get(ID).getReproduccio());
                ecosistema_animal.setText("Ecosistema  " + llista.get(ID).getEcosistema());
                vacuna_id_animal.setText("Vacuna-Id:   " + llista.get(ID).getVacuna_id());
                seccio_animal.setText("Seccio:     " + String.valueOf(llista.get(ID).getSeccio()));
            }

        });
        
//        img_path = "file:images/mamifer/";
                
        img = new Image("file:images/mamifer/2.jpg", 100, 100, true, true);
        imgView = new ImageView(img);
        
       /* //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(
                tipus_label, choiceBox, id_label, imgView, id, btn, nom_animal, raça_animal, edat_animal,
                sexe_animal, pes_animal, 
                esp_vida_animal, vertebrat_animal, alimentacio_animal, reproduccio_animal,
                vacuna_id_animal, seccio_animal
        );*/
        
GridPane.setConstraints(nom_animal, 0, 3);
GridPane.setConstraints(raça_animal, 0, 4);
GridPane.setConstraints(edat_animal, 0, 5);
GridPane.setConstraints(sexe_animal, 0, 6);
GridPane.setConstraints(pes_animal, 0, 7);
GridPane.setConstraints(esp_vida_animal, 0, 8);
GridPane.setConstraints(vertebrat_animal, 0, 9);
GridPane.setConstraints(alimentacio_animal, 0, 10);
GridPane.setConstraints(reproduccio_animal, 0, 11);  
GridPane.setConstraints(vacuna_id_animal, 0, 12);
GridPane.setConstraints(seccio_animal, 0, 13);
GridPane.setConstraints(imgView, 0, 14);

cercaAnimal.getChildren().addAll(imgView,nom_animal, raça_animal, edat_animal,sexe_animal, pes_animal, esp_vida_animal, vertebrat_animal, alimentacio_animal, reproduccio_animal,vacuna_id_animal, seccio_animal);

///*****************************************************///


Tab tab2 = new Tab("Mostra Animals");
tab2.setContent(pDividit);
//tab2.setContent(layout); // contingut de la tab1
tabs.getTabs().add(tab2); //afegeix la tab1 al panell d tabs


        Label tipus_label3 = new Label("Tipus: ");
        final ChoiceBox <String> choiceBox3 = new ChoiceBox <>();
        choiceBox3.getItems().addAll("Mamifer","Reptil","Amfibi","Au","Artropode","Peix");
        choiceBox3.setValue("Mamifer");

        Label id_pare3 = new Label("ID Pare");
        final TextField id_p = new TextField();
        
        Label id_mare3 = new Label("ID Mare");
        final TextField id_m = new TextField();
        
        Label nouNom_label3 = new Label("Nou nom fill");
        final TextField nouNom = new TextField();
        
        final Text nom3 = new Text();
        final Text raça3 = new Text();
        final Text edat3 = new Text();
        final Text sexe3 = new Text();
        final Text pes3 = new Text();
        final Text esp_vida3 = new Text();
        final Text vertebrat3 = new Text();
        final Text alimentacio3 = new Text();
        final Text reproduccio3 = new Text();
        final Text ecosistema3 = new Text();
        final Text vacuna_id3 = new Text();
        final Text seccio3 = new Text();
        
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
                
                encargat_1.reproduir(tipus, llista.get(ID_p), llista.get(ID_m), (ArrayList<Animal>) llista, nouNom.getText());
                
                System.out.println("tipus: "+tipus+"\nID_p: "+ID_p+" \nID_m: "+ID_m);
                System.out.println("nou animal id: " + (llista.size()-1) );
                
                llista.get(llista.size()-1).setNom(nouNom.getText());
                
                nom3.setText("Nom:   " + llista.get(llista.size()-1).getNom());
                raça3.setText("Raça:     " + llista.get(llista.size()-1).getRaça());
                edat3.setText("Edat:     " + String.valueOf(llista.get(llista.size()-1).getEdat()));
                sexe3.setText("Sexe:     " + llista.get(llista.size()-1).getFemeni());
                pes3.setText("Pes    " + String.valueOf(llista.get(llista.size()-1).getPes()));
                esp_vida3.setText("Esp_vida:     " + String.valueOf(llista.get(llista.size()-1).getEsp_vida()));
                vertebrat3.setText("Vertebrat:   " + llista.get(llista.size()-1).getVertebrat());
                alimentacio3.setText("Alimentacio:   " + llista.get(llista.size()-1).getAlimentacio());
                reproduccio3.setText("Reproduccio:   " + llista.get(llista.size()-1).getReproduccio());
                ecosistema3.setText("Ecosistema  " + llista.get(llista.size()-1).getEcosistema());
                vacuna_id3.setText("Vacuna-Id:   " + llista.get(llista.size()-1).getVacuna_id());
                seccio3.setText("Seccio:     " + String.valueOf(llista.get(llista.size()-1).getSeccio()));
            }

        });
//Layout
        VBox reproduir = new VBox(10);
        reproduir.setPadding(new Insets(20, 20, 20, 20));
        reproduir.getChildren().addAll(
                tipus_label3, choiceBox, id_pare3, id_p, id_mare3, id_m, nouNom_label3, nouNom, btn,
                nom3, raça3, edat3, sexe3, pes3,  esp_vida3, vertebrat3, alimentacio3,
                reproduccio3, vacuna_id3, seccio3
        );



Tab tab3 = new Tab("Crear Animal");
tab3.setContent(reproduir); // contingut de la tab1
tabs.getTabs().add(tab3); //afegeix la tab1 al panell d tabs


fons.getChildren().add(tabs);
scene2 = new Scene(fons, 700,700);
 //
 Scene escena = new Scene(graella, 700,700);
        stage.setScene(escena);
        stage.show();
    }
   

    
}

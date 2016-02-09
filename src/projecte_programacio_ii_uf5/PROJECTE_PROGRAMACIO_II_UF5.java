package projecte_programacio_ii_uf5;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PROJECTE_PROGRAMACIO_II_UF5 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Mostra llistat Mamifers per consola");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ArrayList <Animal> llistaMamifers = new ArrayList <>();
                XML_a_Objetos.XML_a_Objeto("Mamifer", llistaMamifers);

                Iterator <Animal> mamifer_iterador = llistaMamifers.iterator();

                while(mamifer_iterador.hasNext()){
                    System.out.println(mamifer_iterador.next());
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

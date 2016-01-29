package projecte_programacio_ii_uf5;

import static projecte_programacio_ii_uf5.AfegirNode.AfegirNode;
import static projecte_programacio_ii_uf5.CrearAnimal.CrearAnimal;
import static projecte_programacio_ii_uf5.Lectura_By_ID.Lectura_By_ID;
import static projecte_programacio_ii_uf5.Modifica_NodeContent.Modifica_NodeContent;

public class Principal {
    
    public static void main(String[] args) {
        
//        Modifica_NodeContent("Mamifers", "M06", "nom", "Manny");
        Modifica_NodeContent("Peixos", "P01", "nom", "Gyarados");
//        Lectura_By_ID("Peixos", "P01");
        
//        AfegirNode("Mamifers", "M06", "vacuna", "si");
//        AfegirNode("Mamifers", "M02", "vacuna", "si");
        
        CrearAnimal(String fitxer, String NodeAnimal, String id, String nom, String raça, String edat,
            String sexe, String pes, String esp_vida, String vertebrat, String alimentacio, 
            String reproduccio, String ecosistema);
//        CrearAnimal("Mamifers", "Mamifer", "M01", "Pikachu", "rata-electrica", "66", "F", "20");
//        CrearAnimal("Reptils", "Reptil", "M01", "Pikachu", "rata-electrica", "66", "F", "20");
        
//        CrearAnimal("Peixos", "Peix", "M01", "Mobidyc", "rata-electrica", "66", "F", "20");
        
//        Lectura_By_ID("Mamifers", "M05");
//        Lectura_By_ID("Mamifers", "M02");
        
    }
    
}

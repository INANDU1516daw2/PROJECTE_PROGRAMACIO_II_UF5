package projecte_programacio_ii_uf5;

import java.util.ArrayList;
import java.util.Iterator;
import static projecte_programacio_ii_uf5.Lectura_By_ID.Lectura_By_ID;

public class Principal {
    
    public static void main(String[] args) {
        
        ArrayList <Animal> llistaMamifers = new ArrayList <>();
        
        XML_a_Objetos.XML_a_Objeto("Mamifers", llistaMamifers);
        
//        Lectura_By_ID_ALL.Lectura_By_ID("Mamifers");
        
//        printArrayList(llistaMamifers);
        
//        llistaMamifers.add(new Mamifer());
//        
        Iterator <Animal> mi_iterador = llistaMamifers.iterator();
        
        while(mi_iterador.hasNext()){
            System.out.println(mi_iterador.next());
        }
        
//        System.out.println(llistaMamifers.get(0));
        
        

        
//        Modifica_NodeContent("Mamifers", "M06", "nom", "Manny");
//        Modifica_NodeContent("Peixos", "P01", "nom", "Gyarados");
//        Lectura_By_ID("Peixos", "P01");
        
//        AfegirNode("Mamifers", "M06", "vacuna", "si");
//        AfegirNode("Mamifers", "M02", "vacuna", "si");
        
//        CrearAnimal("Mamifers", "Mamifer", "M01", "Pikachu", "rata-electrica", "66", "F", "20");
//        CrearAnimal("Reptils", "Reptil", "M01", "Pikachu", "rata-electrica", "66", "F", "20");
        
//        CrearAnimal("Peixos", "Peix", "M01", "Mobidyc", "rata-electrica", "66", "F", "20");
        
//        Lectura_By_ID("Mamifers", "M05");
//        Lectura_By_ID("Mamifers", "M02");
        
    }
    
}

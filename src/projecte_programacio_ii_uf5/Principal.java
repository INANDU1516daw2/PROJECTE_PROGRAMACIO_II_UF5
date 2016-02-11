package projecte_programacio_ii_uf5;

import java.util.ArrayList;
import java.util.Iterator;

public class Principal {
    
    public static void main(String[] args) {
        
        
        //Creacio ArrayList buit
        ArrayList <Animal> llistaMamifers = new ArrayList <>();
        
        //Creacio coleccio objectes mamifers a partir de la lectura Mamifers.xml
        XML_a_Objetos.XML_a_Objeto("Mamifer", llistaMamifers);
        
        //Iterador per poder recorrer l'ArrayList
        Iterator <Animal> mamifer_iterador = llistaMamifers.iterator();

        //Bucle per llegir el ArrayList
        while(mamifer_iterador.hasNext()){
            System.out.println(mamifer_iterador.next());
        }
        
        //Comparcio Mamifesrs (true / false)
        System.out.println(
                llistaMamifers.get(1).equals(llistaMamifers.get(0))
        );
        
        //Creacio Empleat Encarregat
        Encarregat Morote = new Encarregat();
        //Encarregat crida metode per repdroduir 2 mamifers de la collecio => llista.get(posicio)
        Morote.reproduir(llistaMamifers.get(1), llistaMamifers.get(0), llistaMamifers, "Inge");
        //VACUNA
        Morote.Vacunar("Vacunes", "Vacuna", "M0", "sifigils");
        Morote.Vacunar("Vacunes", "Vacuna", "M0", "diarrea");
        Morote.Vacunar("Vacunes", "Vacuna", "M1", "parkinson");
        
        //Creem un nou iterador
        mamifer_iterador = llistaMamifers.iterator();
        
        while(mamifer_iterador.hasNext()){
            System.out.println(mamifer_iterador.next());
        }
        
        
        /* Podem accedir directament a cualsevol objecte animal de la coleccio amb el seu index
         * ja que el valor posicio del arraylist correspon amb la id del node xml:
         * llistaMamifers[1] => llistaMamifers.get(1) = <Mamifer id="1">
        */
//        System.out.println("\n\n\nllistaMamifers["+ 2 +"]: " + llistaMamifers.get(2).toString());
        
        
//        Lectura_By_ID_ALL.Lectura_By_ID("Mamifers");
        
//        printArrayList(llistaMamifers);
        
//        llistaMamifers.add(new Mamifer());
//        
        
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

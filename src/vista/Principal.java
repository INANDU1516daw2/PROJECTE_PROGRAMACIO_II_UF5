package vista;

import controlador.NodeContent;
import controlador.XML_a_ArrayList;
import controlador.XML_a_Objeto_TreeSet;
import model.Animal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import static javafx.scene.input.KeyCode.T;
import model.Encarregat;
import model.Vacuna;

public class Principal {
    
    public static <T> void lecturaList (List <T> llista){
        Iterator <T> itr = llista.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
   
    public static void main(String[] args) {
        
        /* ----------------------------- ANIMALS -------------------------------
         * Cargem en memoria tots els animals existents inicialment dins els XML
         */
        
        List <Animal> llistaMamifers = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);
        
        List <Animal> llistaReptils = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Reptil", llistaReptils);
        
        List <Animal> llistaAmfibis = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Amfibi", llistaAmfibis);
        
        List <Animal> llistaPeixos = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Peixo", llistaPeixos);
        
        List <Animal> llistaAus = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Au", llistaAus);
        
        List <Animal> llistaArtropodes = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Artropode", llistaArtropodes);
        
        /*
         * ToString de cada objecte de la colecció d'animal creada
         */
        lecturaList(llistaReptils);
        
        /* Podem accedir directament a cualsevol objecte animal de la coleccio amb el seu index
         * ja que el valor posicio del arraylist correspon amb la id del node xml:
         * llistaReptils[1] => llistaReptils.get(1) = <Reptil id="1">
        */
//        System.out.println("\n\nllistaReptils["+ 1 +"]: " + llistaReptils.get(1).toString());
        
        /*
         * Podem llegir del XML un animal en concret segons la seva id
         */
        
        /*
         * Per modificar el campt d'un objecte hem d'usar aquest metode per a fer la modificació
         * tant en memoria com en el seu <node> XML
         */
        NodeContent.Modifica("Mamifers", llistaMamifers, 2, "nom", "PuesOks");
        
        //Comprovem el cambi...
//        Lectura_per_ID.Lectura("Mamifers", 2);
        
        
        /* ----------------------------- EMPLEATS ------------------------------
         * Creem els empleats només en memoria
         */
        
        Encarregat encargat_1 = new Encarregat("Morote", "E1", 1, 1700);
        Encarregat encargat_2 = new Encarregat("Ingemar", "E2", 2, 1600);
        Encarregat encargat_3 = new Encarregat("Marta", "E3", 3, 1900);
        Encarregat encargat_4 = new Encarregat("Yolo", "E4", 4, 1200);

        List <Encarregat> empleats = new LinkedList<>();
        
        empleats.add(encargat_1);   //sou: 1700
        empleats.add(encargat_2);   //sou: 1600
        empleats.add(encargat_3);   //sou: 1900
        empleats.add(encargat_4);   //sou: 1200
        
        
        lecturaList(empleats);
        
        //ordenem la llista per sou amb metode compareTo implementat a la classe Encarregat
        Collections.sort(empleats);
        
        System.out.println("LinkedList <Encarregat> sorted");
        
        Iterator <Encarregat> itr = empleats.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().getSou());
        }
        
        
        
        /*
         * Encarregat utilitza metode propi x repdroduir 2 mamifers de la colleció
         * Li pasem el nou nom, tot lo demés ho genera autom.
        */
//        encargat_1.reproduir("Mamifer", llistaMamifers.get(1), llistaMamifers.get(0), llistaMamifers, "NouMamifer");
//          encargat_1.reproduir("Reptil", llistaReptils.get(1), llistaReptils.get(0), llistaReptils, "NouReptil");
//        encargat_1.reproduir("Peixo", llistaPeixos.get(1), llistaPeixos.get(0), llistaPeixos, "NouPeix");
//        
//        System.out.println("\n\nNouMamifer " + llistaMamifers.get(llistaMamifers.size() - 1).toString());
//        System.out.println("\n\nNouPeix " + llistaPeixos.get(llistaPeixos.size() - 1).toString());
        
        
        /* ----------------------------- EMPLEATS ------------------------------*/
//        encargat_1.Vacunar("Vacunes", "Vacuna", "M0", "sifigils");
//        encargat_1.Vacunar("Vacunes", "Vacuna", "M0", "diarrea");
//        encargat_1.Vacunar("Vacunes", "Vacuna", "M1", "parkinson");
        
        /* Al crear el set li pasem el cobjecte que implementa Comparator que ordena per cuantitat vacuna
        */
        TreeSet <Vacuna> llistaVacunes = new TreeSet <>(new CuantitatVacunaComparator());
        
        //Creacio coleccio objectes vacunes a partir de la lectura Vacunes.xml
        XML_a_Objeto_TreeSet.XML_a_Objeto_TreeSet("Vacunes", llistaVacunes);
        System.out.println("");
        
        int v = 0;
        for(Vacuna p : llistaVacunes){
            System.out.println("llistaVacunes[" + v + "] = " + p.toString());
            v++;
        }
        

         
    }
    
}

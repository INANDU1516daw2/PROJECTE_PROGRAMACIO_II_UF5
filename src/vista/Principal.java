package vista;

import controlador.Lectura_per_ID;
import controlador.NodeContent;
import controlador.XML_a_ArrayList;
import controlador.XML_a_Objeto_TreeSet;
import model.Animal;
import model.Mamifer;
import model.Reptil;
import model.Peix;
import model.Au;
import model.Artropode;
import model.Amfibi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import model.Encarregat;
import model.Vacuna;

public class Principal {
    
    public static void lecturaArrayList (ArrayList <Animal> llista){
        Iterator <Animal> itr = llista.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    
    public static void main(String[] args) {
        
        /* ----------------------------- ANIMALS -------------------------------
         * Cargem en memoria tots els animals existents inicialment dins els XML
         */
        
        ArrayList <Animal> llistaMamifers = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Mamifer", llistaMamifers);
        
        ArrayList <Animal> llistaReptils = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Reptil", llistaReptils);
        
        ArrayList <Animal> llistaAmfibis = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Amfibi", llistaAmfibis);
        
        ArrayList <Animal> llistaPeixos = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Peixo", llistaPeixos);
        
        ArrayList <Animal> llistaAus = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Au", llistaAus);
        
        ArrayList <Animal> llistaArtropodes = new ArrayList <>();
        XML_a_ArrayList.RecuperaDades("Artropode", llistaArtropodes);
        
        /*
         * ToString de cada objecte de la colecció d'animal creada
         */
        lecturaArrayList(llistaAmfibis);
        
        /* Podem accedir directament a cualsevol objecte animal de la coleccio amb el seu index
         * ja que el valor posicio del arraylist correspon amb la id del node xml:
         * llistaReptils[1] => llistaReptils.get(1) = <Reptil id="1">
        */
        System.out.println("\n\nllistaReptils["+ 1 +"]: " + llistaReptils.get(1).toString());
        
        /*
         * Podem llegir del XML un animal en concret segons la seva id
         */
        Lectura_per_ID.Lectura("Mamifers", 2);
        
        /*
         * Per modificar el campt d'un objecte hem d'usar aquest metode per a fer la modificació
         * tant en memoria com en el seu <node> XML
         */
        NodeContent.Modifica("Mamifers", llistaMamifers, 2, "nom", "PuesOks");
        
        //Comprovem el cambi...
        Lectura_per_ID.Lectura("Mamifers", 2);
        
        
        /* ----------------------------- EMPLEATS ------------------------------
         * Creem els empleats només en memoria
         */
        
        Encarregat Morote = new Encarregat();
        
        /*
         * Encarregat utilitza metode propi x repdroduir 2 mamifers de la colleció
         * Li pasem el nou nom, tot lo demés ho genera autom.
        */
        Morote.reproduir("Mamifer", llistaMamifers.get(1), llistaMamifers.get(0), llistaMamifers, "NouMamifer");
        Morote.reproduir("Peixo", llistaPeixos.get(1), llistaPeixos.get(0), llistaPeixos, "NouPeix");
        
        System.out.println("\n\nNouMamifer " + llistaMamifers.get(llistaMamifers.size() - 1).toString());
        System.out.println("\n\nNouPeix " + llistaPeixos.get(llistaPeixos.size() - 1).toString());
        
        
        /* ----------------------------- EMPLEATS ------------------------------*/
        Morote.Vacunar("Vacunes", "Vacuna", "M0", "sifigils");
        Morote.Vacunar("Vacunes", "Vacuna", "M0", "diarrea");
        Morote.Vacunar("Vacunes", "Vacuna", "M1", "parkinson");
        
        //Creacio Collecció Vacunes ==> TreeSet és ordenat alfabeticament per defecte
        TreeSet <Vacuna> llistaVacunes = new TreeSet <>();
        
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

package projecte_programacio_ii_uf5;

import java.util.ArrayList;
import java.util.Random;
import static projecte_programacio_ii_uf5.CrearAnimal.CrearAnimal;



public class Peix extends Animal {
    
    public Peix(
                   String id,
                   String nom,
                   String raça,
                   String edat, 
                   String femeni, 
                   String pes,
                   String esp_vida,
                   String vertebrat,
                   String alimentacio,
                   String reproduccio,
                   String ecosistema,
                   String vacunacio,
                   String seccio) {
        
        this.id = Integer.parseInt(id);
        this.nom = nom;
        this.raça = raça;
        this.edat = Integer.parseInt(edat);
        this.femeni = femeni;
        this.pes = Integer.parseInt(pes);
        this.esp_vida = Integer.parseInt(esp_vida);
        this.vertebrat = vertebrat;
        this.alimentacio = alimentacio;
        this.reproduccio = reproduccio;
        this.ecosistema = ecosistema;
        this.vacunacio = vacunacio;
        this.seccio = Integer.parseInt(seccio);
    }
    
    //constructor buit amb camps per defecte
    public Peix(){
        this.id = 999;
        this.nom = "no-catalogat";
        this.raça = "no-catalogat";
        this.edat = 0;
        this.femeni = "0";
        this.pes = 0;
        this.esp_vida = 0;
        this.vertebrat = "0";
        this.alimentacio = "no-catalogat";
        this.reproduccio = "no-catalogat";
        this.ecosistema = "Terrestre";
        this.vacunacio = "no-catalogat";
        this.seccio = 00;
    }

    @Override
    public String toString() {
        return "\nPeix:{ ID: " + getId() + " | Nom: " + getNom() + " | Raça: "+ getRaça() + " | Edat: "+ getEdat() +" | Femeni: "+ getFemeni() +
                " | Pes: "+ getPes() +" | Esp_Vida: "+ getEsp_vida() +" | Alimentació: "+ getAlimentacio() +
                " \n\t | Reproducció: "+ getReproduccio() +" | Ecosistema: "+ getEcosistema() +" | Vacunació: "
                + getVacunacio() +" | Secció: "+ getSeccio() +" }\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //son de la mateixa classe els 2 objectes ?
        if (getClass() != obj.getClass()) {
            return false;
        }
        //DOWCASTING 
        final Peix other = (Peix) obj;
        //tenen el mateix nom ?
        if(getId() == other.getId()) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    
    @Override
    public void reproduir(Animal pare, Animal mare, ArrayList <Animal> llista) {
        if(!pare.femeni.equals(mare.femeni)){
            System.out.println("\n\nReproduint " + pare.getNom() + " amb " + mare.getNom());
            System.out.println("Diferent sexe, podem avançar");
            int ID_fill = llista.size();
            String Nom_fill = "Fill-test";
            String genere = null;
            Random rand = new Random();
            int randomGenere = rand.nextInt((1 - 0) + 1) + 0;
            if(randomGenere == 1){
                genere = "M";
            }else{
                genere = "F";
            }
            int randomPes = rand.nextInt((10 - 0) + 10) + 0;
            
            System.out.println("\nNova ID: " + ID_fill + "\nnom: "
                                + Nom_fill + "\ngenere: " + genere
                                + "\npes: " + randomPes
                            );
            
            /* 
             * Afegim nou animal creat a la colecció
            */
            llista.add( new Peix(
                                    String.valueOf(ID_fill),
                                    Nom_fill,
                                    mare.getRaça(),
                                    String.valueOf(0), 
                                    genere, 
                                    String.valueOf(randomPes),
                                    String.valueOf(pare.getEsp_vida()),
                                    pare.getVertebrat(),
                                    pare.getAlimentacio(),
                                    pare.getReproduccio(),
                                    pare.getEcosistema(),
                                    "no",
                                    String.valueOf(mare.getSeccio())
                                ) 
                   );
            
        /* 
        * Afegim nou animal creat al fitxer XML
        */
            CrearAnimal( "Peixos",
                        "Peix",
                        String.valueOf(ID_fill),
                        Nom_fill,
                        mare.getRaça(),
                        String.valueOf(0), 
                        genere, 
                        String.valueOf(randomPes),
                        String.valueOf(pare.getEsp_vida()),
                        pare.getVertebrat(),
                        pare.getAlimentacio(),
                        pare.getReproduccio(),
                        pare.getEcosistema(),
                        "no",
                        String.valueOf(mare.getSeccio())
                    );
            
        }else{
            System.out.println("Mateix sexe, no poden avançar");
        }
    }
    
}
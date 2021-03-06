package projecte_programacio_ii_uf5;

import java.util.ArrayList;
import java.util.Random;
import static projecte_programacio_ii_uf5.CrearAnimal.CrearAnimal;



public class Mamifer extends Animal {
    
    public Mamifer(
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
                   String vacuna_id,
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
        this.vacuna_id = vacuna_id;
        this.seccio = Integer.parseInt(seccio);
    }
    
    //constructor buit amb camps per defecte
    public Mamifer(){
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
        this.vacuna_id = "no-catalogat";
        this.seccio = 00;
    }

    @Override
    public String toString() {
        return "\nMamifer:{ ID: " + getId() + " | Nom: " + getNom() + " | Raça: "+ getRaça() + " | Edat: "+ getEdat() +" | Femeni: "+ getFemeni() +
                " | Pes: "+ getPes() +" | Esp_Vida: "+ getEsp_vida() +" | Alimentació: "+ getAlimentacio() +
                " \n\t | Reproducció: "+ getReproduccio() +" | Ecosistema: "+ getEcosistema() +" | Vacuna-id: "
                + getVacuna_id() +" | Secció: "+ getSeccio() +" }\n";
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
        final Mamifer other = (Mamifer) obj;
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
    
    
}
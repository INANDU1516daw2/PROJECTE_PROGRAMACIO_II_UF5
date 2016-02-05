package projecte_programacio_ii_uf5;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Creacio de la classe Au que hereta de Animal
 * 
 */
public class Au extends Animal {

    /**
     * Constructor amb parametres
     * @param nom
     * @param raça
     * @param ID
     * @param ID_pare
     * @param ID_mare
     * @param edat
     * @param femeni
     * @param pes
     * @param esp_vida
     * @param vertebrat
     * @param alimentacio
     * @param reproduccio
     * @param ecosistema
     * @param vacunacio
     * @param seccio 
     */
    public Au (String nom,String raça,String ID,String ID_pare,String ID_mare,int edat, boolean femeni,float pes,int esp_vida,boolean vertebrat,String alimentacio,String reproduccio,String ecosistema,String vacunacio,String seccio){
        this.nom = nom;
        this.raça = raça;
        this.ID = ID;
        this.ID_pare = ID_pare;
        this.ID_mare = ID_mare; 
        this.edat = edat;
        this.femeni = femeni;
        this.pes = pes;
        this.esp_vida = esp_vida;
        this.vertebrat = vertebrat;
        this.alimentacio = alimentacio;
        this.reproduccio = reproduccio;
        this.ecosistema = ecosistema;
        this.vacunacio = vacunacio;
        this.seccio = "SECCIÓ 04";
    }
    
    /**
     * Constructor per defecte, amb valors per defecte
     */
    public Au(){
        this.nom = "no-catalogat";
        this.raça = "no-catalogat";
        this.ID = "AU00";
        this.ID_pare = "AU00";
        this.ID_mare = "AU00"; 
        this.edat = 0;
        this.femeni = true;
        this.pes = 0;
        this.esp_vida = 0;
        this.vertebrat = true;
        this.alimentacio = "no-catalogat";
        this.reproduccio = "no-catalogat";
        this.ecosistema = "Volador";
        this.vacunacio = "no-catalogat";
        this.seccio = "SECCIÓ 04";
    }
    
    /**
     * @see Animal
     */
    @Override
    public void reproduir (String ID_pare, String raça_p, String ID_mare, String raça_m, String ID_fill) {
        String raça_f;
        if(raça_p != raça_m){
            Random rnd = new Random();
            int r = (int)(rnd.nextDouble() * 2 + 1);
                if(r==1){
                    this.setRaça(raça_p);
                    
                }else if(r==2){
                     this.setRaça(raça_m);
                }
        }else{
            this.setRaça(raça_m);
        }
            this.setID_pare(ID_pare);
            this.setID_mare(ID_mare);
            this.setID(ID_fill);
            this.setEdat(1);
            
            Date data = new Date();
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(data);
            
        System.out.println("El creuament entre "+ID_pare+" de raça " + raça_p+" i "+ID_mare+" de raça "+raça_m
        +" ha nascut un "+this.getRaça()+" en el dia "+gc.get(Calendar.DAY_OF_MONTH) +" en el mes "
        +gc.get(Calendar.MONTH)+" de "+gc.get(Calendar.YEAR) + " a las "+gc.get(Calendar.HOUR_OF_DAY)
        +":"+gc.get(Calendar.MINUTE)+":"+gc.get(Calendar.SECOND));
    }
    
    /**
     * Reimplementacio de la cadena toString()
     */
    @Override
    public String toString() {
        return "\nAu: { Nom: " + getNom() + " | Raça: "+ getRaça() +" | ID: "+ getID() +" | ID_Mare: "+ getID_mare() +
                " | ID_Pare: "+getID_pare()+" | Edat: "+ getEdat() +" | Femeni: "+ isFemeni() +
                " | Pes: "+ getPes() +" | Esp_Vida: "+ getEsp_vida() +" | Alimentació: "+ getAlimentacio() +
                " \n\t | Reproducció: "+ getReproduccio() +" | Ecosistema: "+ getEcosistema() +" | Vacunació: "
                + getVacunacio() +" | Secció: "+ getSeccio() +" }\n";
    }
    
    /**
     * Comprovacio si dos objectes son iguals
     * @param obj
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //son de la mateixa classe els 2 objectes ?
        if (getClass() != obj.getClass()) {
            return false;
        }
        //LOWCASTING 
        final Au other = (Au) obj;
        //tenen el mateix nom ?
        if(ID == other.ID) {
            return true;
        }else{
            return false;
        }
    }

     
}
    
    
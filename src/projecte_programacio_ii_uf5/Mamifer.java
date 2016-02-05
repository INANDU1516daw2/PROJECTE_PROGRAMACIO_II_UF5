package projecte_programacio_ii_uf5;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Mamifer extends Animal {

    public Mamifer(String nom,String raça,String ID,String ID_pare,
            String ID_mare, String edat, String femeni, String pes,
            String esp_vida, String vertebrat, String alimentacio,
            String reproduccio, String ecosistema,String vacunacio, String seccio){
        
        this.nom = nom;
        this.raça = raça;
//        this.ID = ID;
//        this.ID_pare = ID_pare;
//        this.ID_mare = ID_mare; 
        this.edat = edat;
        this.femeni = femeni;
        this.pes = pes;
        this.esp_vida = esp_vida;
        this.vertebrat = vertebrat;
        this.alimentacio = alimentacio;
        this.reproduccio = reproduccio;
        this.ecosistema = ecosistema;
        this.vacunacio = vacunacio;
        this.seccio = seccio;
    }
    
    public Mamifer(){
        this.nom = "no-catalogat";
        this.raça = "no-catalogat";
//        this.ID = "MA00";
//        this.ID_pare = "MA00";
//        this.ID_mare = "MA00"; 
        this.edat = "0";
        this.femeni = "0";
        this.pes = "0";
        this.esp_vida = "0";
        this.vertebrat = "0";
        this.alimentacio = "no-catalogat";
        this.reproduccio = "no-catalogat";
        this.ecosistema = "Terrestre";
        this.vacunacio = "no-catalogat";
        this.seccio = "01";
    }
    
//     public void reproduir (String ID_pare, String raça_p, String ID_mare, String raça_m, String ID_fill) {
//        String raça_f;
//        if(raça_p != raça_m){
//            Random rnd = new Random();
//            int r = (int)(rnd.nextDouble() * 2 + 1);
//                if(r==1){
//                    this.setRaça(raça_p);
//                    
//                }else if(r==2){
//                     this.setRaça(raça_m);
//                }
//        }else{
//            this.setRaça(raça_m);
//        }
//            this.setID_pare(ID_pare);
//            this.setID_mare(ID_mare);
//            this.setID(ID_fill);
//            this.setEdat(1);
//            
//            Date data = new Date();
//            GregorianCalendar gc = new GregorianCalendar();
//            gc.setTime(data);
//            
//        System.out.println("De el creuament entre "+ID_pare+" de raça " + raça_p+" i "+ID_mare+" de raça "+raça_m
//        +" ha nascut un "+this.getRaça()+" en el dia "+gc.get(Calendar.DAY_OF_MONTH) +" en el mes "
//        +gc.get(Calendar.MONTH)+" de "+gc.get(Calendar.YEAR) + " a las "+gc.get(Calendar.HOUR_OF_DAY)
//        +":"+gc.get(Calendar.MINUTE));
//    }
//    
//    @Override
//    public String toString() {
//        return "\nMamifer: { Nom: " + getNom() + " | Raça: "+ getRaça() +" | ID: "+ getID() +" | ID_Mare: "+ getID_mare() +
//                " | ID_Pare: "+getID_pare()+" | Edat: "+ getEdat() +" | Femeni: "+ isFemeni() +
//                " | Pes: "+ getPes() +" | Esp_Vida: "+ getEsp_vida() +" | Alimentació: "+ getAlimentacio() +
//                " \n\t | Reproducció: "+ getReproduccio() +" | Ecosistema: "+ getEcosistema() +" | Vacunació: "
//                + getVacunacio() +" | Secció: "+ getSeccio() +" }\n";
//    }
//    
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        //son de la mateixa classe els 2 objectes ?
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        //DOWCASTING 
//        final Mamifer other = (Mamifer) obj;
//        //tenen el mateix nom ?
//        if(ID == other.ID) {
//            return true;
//        }else{
//            return false;
//        }
//    }

    @Override
    public void reproduir(String ID_pare, String raça_p, String ID_mare, String raça_m, String ID_fill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
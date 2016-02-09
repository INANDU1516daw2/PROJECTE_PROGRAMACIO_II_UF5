package projecte_programacio_ii_uf5;

public class Peix extends Animal {
    
    public Peix(String nom,
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
        
        this.nom = nom;
        this.raça = raça;
        this.edat = Integer.parseInt(edat);
        this.femeni = femeni;
        this.pes = pes;
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
        this.nom = "no-catalogat";
        this.raça = "no-catalogat";
        this.edat = 0;
        this.femeni = "0";
        this.pes = "0";
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
        return "\nPeixos:{ Nom: " + getNom() + " | Raça: "+ getRaça() + " | Edat: "+ getEdat() +" | Femeni: "+ getFemeni() +
                " | Pes: "+ getPes() +" | Esp_Vida: "+ getEsp_vida() +" | Alimentació: "+ getAlimentacio() +
                " \n\t | Reproducció: "+ getReproduccio() +" | Ecosistema: "+ getEcosistema() +" | Vacunació: "
                + getVacunacio() +" | Secció: "+ getSeccio() +" }\n";
    }
}

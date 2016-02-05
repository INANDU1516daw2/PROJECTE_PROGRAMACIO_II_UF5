package projecte_programacio_ii_uf5;

/**
 * Creació de la classe diferida Animal
 */
public abstract class Animal {

protected String nom;
protected String raça;
protected String ID;
//protected String ID_pare;
//protected String ID_mare; 
protected String edat;
protected String femeni;
protected String pes;
protected String esp_vida;
protected String vertebrat;
protected String alimentacio;
protected String reproduccio;
protected String ecosistema;
protected String vacunacio;
protected String seccio;

/**
 * Passem 3 ID i les guarda amb un set
 * @param ID_pare
 * @param raça_p
 * @param ID_mare
 * @param raça_m
 * @param ID_fill
 */
public abstract void reproduir(String ID_pare, String raça_p, String ID_mare, String raça_m, String ID_fill);



  /**
     * Agafa nom
     * @return nom 
     */
    public String getNom() {
        return nom;
    }
    /**
     * Defineix nom
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Agafa raça
     * @return raça 
     */
    public String getRaça() {
        return raça;
    }
    /**
     * Defineix raça
     * @param raça 
     */
    public void setRaça(String raça) {
        this.raça = raça;
    }
    /**
     * Agafa ID
     * @return ID 
     */
    public String getID() {
        return ID;
    }
    /**
     * Defineix ID
     * @param ID 
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    /**
     * Agafa ID_pare
     * @return ID_pare 
     */
//    public String getID_pare() {
//        return ID_pare;
//    }
//    /**
//     * Defineix ID_pare
//     * @param ID_pare 
//     */
//    public void setID_pare(String ID_pare) {
//        this.ID_pare = ID_pare;
//    }
    /**
     * Agafa ID_mare
     * @return ID_mare 
     */
//    public String getID_mare() {
//        return ID_mare;
//    }
//    /**
//     * Defineix ID_mare
//     * @param ID_mare 
//     */
//    public void setID_mare(String ID_mare) {
//        this.ID_mare = ID_mare;
//    }
    /**
     * Agafa edat
     * @return edat 
     */
    public String getEdat() {
        return edat;
    }
    /**
     * Defineix edat
     * @param edat 
     */
    public void setEdat(String edat) {
        this.edat = edat;
    }
    /**
     * Agafa femeni
     * @return femeni 
     */
    public String isFemeni() {
        return femeni;
    }
    /**
     * Defineix femeni
     * @param femeni 
     */
    public void setFemeni(String femeni) {
        this.femeni = femeni;
    }
    /**
     * Agafa pes
     * @return pes 
     */
    public String getPes() {
        return pes;
    }
    /**
     * Defineix pes
     * @param pes 
     */
    public void setPes(String pes) {
        this.pes = pes;
    }
    /**
     * Agafa esp_vida
     * @return esp_vida 
     */
    public String getEsp_vida() {
        return esp_vida;
    }
    /**
     * Defineix esp_vida
     * @param esp_vida 
     */
    public void setEsp_vida(String esp_vida) {
        this.esp_vida = esp_vida;
    }
    /**
     * Agafa vertebrat
     * @return vertebrat 
     */
    public String isVertebrat() {
        return vertebrat;
    }
    /**
     * Defineix vertebrat
     * @param vertebrat 
     */
    public void setVertebrat(String vertebrat) {
        this.vertebrat = vertebrat;
    }
    /**
     * Agafa alimentacio
     * @return alimentacio 
     */
    public String getAlimentacio() {
        return alimentacio;
    }
    /**
     * Defineix alimentacio
     * @param alimentacio 
     */
    public void setAlimentacio(String alimentacio) {
        this.alimentacio = alimentacio;
    }
    /**
     * Agafa reproduccio
     * @return reproduccio 
     */
    public String getReproduccio() {
        return reproduccio;
    }
    /**
     * Defineix reproduccio
     * @param reproduccio 
     */
    public void setReproduccio(String reproduccio) {
        this.reproduccio = reproduccio;
    }
    /**
     * Agafa ecosistema
     * @return ecosistema 
     */
    public String getEcosistema() {
        return ecosistema;
    }
    /**
     * Defineix ecosistema
     * @param ecosistema 
     */
    public void setEcosistema(String ecosistema) {
        this.ecosistema = ecosistema;
    }
    /**
     * Agafa vacunacio
     * @return vacunacio 
     */
    public String getVacunacio() {
        return vacunacio;
    }
   /**
     * Defineix vacunacio
     * @param vacunacio 
     */
    public void setVacunacio(String vacunacio) {
        this.vacunacio = vacunacio;
    }
    /**
     * Agafa seccio
     * @return seccio 
     */
    public String getSeccio() {
        return seccio;
    }

}

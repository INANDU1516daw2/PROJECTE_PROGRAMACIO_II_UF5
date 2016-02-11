package projecte_programacio_ii_uf5;
/**
 * Interfície anomenada Veterinari
 */
public interface Veterinari {
    
   
    /**
     * Es tracta un animal
     * @param ID_encarregat
     * @param nom_encarregat
     * @param ID_animal
     * @param nom_animal 
     */
    public void tractar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal);
    
    
    
    public void Vacunar(String fitxer, String NodeVacuna, String vacuna_id, String nom);
}

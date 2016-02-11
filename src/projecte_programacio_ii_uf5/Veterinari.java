package projecte_programacio_ii_uf5;
/**
 * Interfície anomenada Veterinari
 */
public interface Veterinari {
    
    /**
     * Es vacuna un mamífer
     * @param encargat
     * @param mamifer
     * @param vacunacio 
     */
    public void vacunar_mamifer (Encarregat encarregat, Mamifer mamifer, String vacunacio);
    
    /**
     * Es vacuna un au
     * @param encargat
     * @param au
     * @param vacunacio 
     */
    public void vacunar_au (Encarregat encarregat, Au au, String vacunacio);
    
    /**
     * Es tracta un animal
     * @param ID_encarregat
     * @param nom_encarregat
     * @param ID_animal
     * @param nom_animal 
     */
    public void tractar(String ID_encarregat, String nom_encarregat, String ID_animal, String nom_animal);
    
}

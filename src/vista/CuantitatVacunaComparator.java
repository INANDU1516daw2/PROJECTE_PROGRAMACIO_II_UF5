package vista;

import java.util.Comparator;
import model.Vacuna;

/**
 * Comaprator 
 */
class CuantitatVacunaComparator implements Comparator <Vacuna> {
/**
 * Fa la comparació entre les quantitats de les vacunes
 * @param o1
 * @param o2
 */
    @Override
    public int compare(Vacuna o1, Vacuna o2) {
        return  Integer.parseInt(o1.getCuantitat()) - Integer.parseInt(o2.getCuantitat());
    }
    
}

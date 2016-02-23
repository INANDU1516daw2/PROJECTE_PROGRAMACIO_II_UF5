package vista;

import java.util.Comparator;
import model.Vacuna;

class CuantitatVacunaComparator implements Comparator <Vacuna> {

    @Override
    public int compare(Vacuna o1, Vacuna o2) {
        return  Integer.parseInt(o1.getCuantitat()) - Integer.parseInt(o2.getCuantitat());
    }
    
}

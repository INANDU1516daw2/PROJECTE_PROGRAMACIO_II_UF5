package projecte_programacio_ii_uf5;

public class Vacuna implements Comparable <Vacuna> {
    
    protected String nom;
    protected String data;
    
    @Override
 public int compareTo(Vacuna s){
    int result = this.nom.compareTo(s.getNom());
    if (result > 0) { 
        return 1; 
    }
    else if (result < 0){ 
        return -1; 
    }
    else { return 0; }
}

    public Vacuna(String nom, String data) {
        this.nom = nom;
        this.data = data;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "nom=" + nom + ", data=" + data + '}';
    }

}

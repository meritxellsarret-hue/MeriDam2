import java.io.Serializable;
public class Llibre implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titol;
    private String autor;
    private int anyPublicacio;
    private double preu;

    public Llibre(String titol, String autor, int anyPublicacio, double preu) {
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
        this.preu = preu;
    }
    //
    @Override
    public String toString() {
        return "Llibre{" +
        "titol='" + titol + '\'' +
        ", autor='" + autor + '\'' +
        ", anyPublicacio=" + anyPublicacio +
        ", preu=" + preu +
        '}';
    }
}
import java.io.bufferedwriter;
import java.io.FileWriter;
public class Escriurefitxertext{
    public static void main(String[] args){
        string[] linies = {"hola, primera linea.", "segona linea.", "Tercera linea."};
        try{
            Buffedwriter bw = new Buffedwriter(new filewriter("text.txt"));
            for(String linea : linea){
                bw.writer(linea);
                bw.newLine();
            }
            bw.close();
        }catch(Exception e){
            System.out.println("Error al escrivir" + e.getMessage());
        }
    }
}
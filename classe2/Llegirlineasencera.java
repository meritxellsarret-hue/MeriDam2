import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Llegirlineasencera{
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))){
            String linea;
            int n = 0;
            while((linea = br.readLine()) != null){
                n++;
                System.out.println("Linea" + n + ": " + linea);
            }
            br.close();
        }catch(IUEsception e){
            System.out.println("Error al leer archivo:" + e.getMessage());
        }
    }
}
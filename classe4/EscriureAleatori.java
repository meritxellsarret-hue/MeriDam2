import java.io.IOException;
import java.io.RandomAccessFile;
public class EscriureAleatori{
    public static void main(String[] args) {
        String[] nom = {"Pepe","Luis","Carmen"};
        int[] edad = {20,30,40};
        double[] salario = {1300,2200,6000};
        //
        try(RandomAccessFile f = new RandomAccessFile("empleados.dat","rw")){
            for (int i = 0; i < nom.length; i++) {
                StringBuffer buf = new StringBuffer(nom[i]);
                buf.setLength(10);
                f.writeInt(i);
                f.writeChars(buf.toString());
                f.writeInt(edad[i]);
                f.writeDouble(salario[i]);
            }
        //
        } catch (IOException e) {
            System.err.println("Error"+ e.getMessage());
        }
    }
}
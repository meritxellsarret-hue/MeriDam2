import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class GestioLlibres {
    public static void main(String[] args) {
        ArrayList<Llibre> llibres = new ArrayList<>();
        
        llibres.add(new Llibre("1984", "George Orwell", 1949, 15.5));
        llibres.add(new Llibre("El Hobbit", "J.R.R. Tolkien", 1937, 18.0));
        llibres.add(new Llibre("Dune", "Frank Herbert", 1965, 20.5));
        llibres.add(new Llibre("Dracula", "Bram Stoker", 1897, 12.0));
        llibres.add(new Llibre("Fundacio", "Isaac Asimov", 1951, 16.5));
        llibres.add(new Llibre("It","Stephen King", 1986, 25.0));
        // 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("llibres.dat"))) {
         
            oos.writeObject(llibres);
            System.out.println("ArrayList guardado correctamente.");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("llibres.dat"))) {
        
            ArrayList<Llibre> llibresLlegits= (ArrayList<Llibre>) ois.readObject();
            
            System.out.println("\nLlibres recuperados:");
            
            for (Llibre llibre : llibresLlegits) {
                System.out.println(llibre);
            }
        
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

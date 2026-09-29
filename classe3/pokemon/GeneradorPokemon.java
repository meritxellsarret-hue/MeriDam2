import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectStreamClass;
public class GeneradorPokemon{
    public static void main(String[] args) {
        String[]nombres = ("Pikachu", "Charmander", "snorlax", "Squirtel", "Jiggipuff");
        int[] vidas = (60, 100, 120, 80, 100);
        File fitxer = new File("FitxerPokemons.dat");
        //
        try(FileOutputStream out = new FileOutputStream(new FileOutputStream(fitxer))){
            for(int i = 0; i < nombre.length; i++){
                Pokemon pokemon = new Pokemon(nombres[i], vidas[i]);
                oos.writeObject(pokemon);
            }
        }catch(IOException e){
            System.err.println("Error !!!" + e.getMessage());
        }
    }
}
import java.io.File;
import java.io.FileReader;
public class Llegirfitxertext{
    public static void main(String[] args){
        File dir = new File("./text.txt");
        try{
            FileReader fr = new FileReader(dir);
            int i;
            while((i=fr.read())!=-1){
                System.out.print((char)i);
            } 
        }catch(Exception e){
            System.out.println("error" + e.getMessage());
        }
    }
}
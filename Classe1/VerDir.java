import java.io.File;
//
public class VerDir {
    public static void main(String[] args){
        String path = "./";
        File dir = new File(path);

        if(!dir.isDirectory()){
            System.out.println("No es un directori");
            return;
        }
    //
        System.out.println("Directori es:" + dir.getAbsolutePath());
        String [] files = dir.list();
        System.out.println("Numero de archivos:" + files.length);
    
        for(String file : files){
            System.out.println(file);
            File f = new File(dir, file);
            System.out.printf("\nEs un archiu? %b, tamany %d bytes\n", f.isFile(), f.length());
        }
    }
    //
    public static void  imprimirContenidoDentroCarpeta(File dir){
        String [] files = dir.list();
         for(String file : files){
            System.out.println(file);
            File f = new File(dir, file);
            System.out.printf("\nEs un archiu? %b, tamany %d bytes\n", f.isFile(), f.length());
            if(f.isDirectory()){
                imprimirContenidoDentroCarpeta(f);
            }
        }
    }
}
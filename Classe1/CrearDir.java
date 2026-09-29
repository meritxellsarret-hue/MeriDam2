import java.io.File;
public class CrearDir {
    public static void main(String[] args) {
        File dir = new File("./prueba");
        File archivo1 = new File(dir, "archivo1.txt");
        File archivo2 = new File(dir, "archivo2.txt");

        if(dir.exists()){
            System.out.println("El directorio ya existe");   
        } else {
            if(dir.mkdir())
            {
                System.out.println("carpeta creada");
            }
            else{
                System.out.println("error al crear el directorio");
            }
        }
    
     try{
            archivo1.createNewFile();
            archivo2.createNewFile();
        } catch (Exception e) {
            System.out.println("error al crear los archivos:" + e.getMessage());
        }
    }
}
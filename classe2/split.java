import java.io.BufferedReader;
import java.io.FileReader;
/*
public class split{

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new fileReader("contactes.txt"));
            String linea;
            while((linea = br.readLine()) != null){
                String[] palabras = linea.split(";");
                for(String palabra : palabras){
                    system.out.println(palabra);
                }
            }
            br.close();
        }catch(esception e){
            System.out.println("Error al leer" + e.getMessage());
        }
    }
}
*/
public class split{
    public void alumnosAprovados(){
        int totalAprovados = 0;
        for(int i = 0; i < alumnos.length; i++){
            if(Integer.parseInt(alumnos[i][1].trim()) >= 5){
                System.out.println("aprovado: " + alumnos[i][0] + ", Nota:" + alumnos[i][1]);
                totalAprovados++;
            }
        }
    }
    //
    public void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new FileReader("contactes.txt"));
            String alumnos[][] = new String[100][3];
            String linea;
            int i = 0;
            while((linea = br.readLine()) != null){
                alumnos[i] = linea.split(";");
                i++;
                System.out.println("Alumno: " + alumnos[i-1][0] + ", Nota: " + alumnos[i-1][1] + ", Minuto: " + alumnos[i-1][2]);
            }
        }
            br.close();
    }catch(Exception e){
        System.out.println("Error al leer" + e.getMessage());
    }
}
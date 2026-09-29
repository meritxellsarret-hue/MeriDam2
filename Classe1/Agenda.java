import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//
public class Agenda {
    String contactes[][] = new String[100][3];
    int totalContactes = 0;
    // Llegir els contactes quan comenca el programa
    public void carregarContactes() {

        File fitxer = new File("contactes.txt");

        // Si el fitxer no existeix, no passa res
        if (!fitxer.exists()) {
            System.out.println("El fitxer encara no existeix.");
            return;
        }

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("contactes.txt"));

            String linia;

            while ((linia = br.readLine()) != null) {

                String[] dades = linia.split(";");

                if (dades.length == 3 && totalContactes < 100) {

                    contactes[totalContactes][0] = dades[0];
                    contactes[totalContactes][1] = dades[1];
                    contactes[totalContactes][2] = dades[2];

                    totalContactes++;
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al llegir el fitxer.");
        }
    }
    // Afegir un contacte
    public void afegirContacte(Scanner scanner) {

        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();

        System.out.print("Correu: ");
        String correu = scanner.nextLine();

        try {

            // true vol dir que escrivim al final del fitxer
            FileWriter fw = new FileWriter("contactes.txt", true);

            fw.write(nom + ";" + telefon + ";" + correu);
            fw.write(System.lineSeparator());

            fw.close();

            // Guardem tambe el contacte a l'array
            contactes[totalContactes][0] = nom;
            contactes[totalContactes][1] = telefon;
            contactes[totalContactes][2] = correu;

            totalContactes++;

            System.out.println("Contacte afegit correctament.");

        } catch (IOException e) {
            System.out.println("Error al escriure el fitxer.");
        }
    }

    // Llistar contactes
    public void llistarContactes() {

        File fitxer = new File("contactes.txt");

        if (!fitxer.exists()) {
            System.out.println("No existeix cap fitxer de contactes.");
            return;
        }

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("contactes.txt"));

            String linia;

            System.out.println("\n--- CONTACTES ---");

            while ((linia = br.readLine()) != null) {

                String[] dades = linia.split(";");

                if (dades.length == 3) {

                    System.out.println("Nom: " + dades[0]);
                    System.out.println("Telefon: " + dades[1]);
                    System.out.println("Correu: " + dades[2]);
                    System.out.println("----------------");
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al llegir el fitxer.");
        }
    }

    // Cercar un contacte pel nom
    public void cercarPerNom(Scanner scanner) {

        System.out.print("Introdueix el nom: ");
        String nom = scanner.nextLine();

        boolean trobat = false;
        
        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("contactes.txt"));

            String linia;
            
            while ((linia = br.readLine()) != null) {

                String[] dades = linia.split(";");

                if (dades.length == 3 &&
                    dades[0].equalsIgnoreCase(nom)) {

                    System.out.println("\nContacte trobat:");
                    System.out.println("Nom: " + dades[0]);
                    System.out.println("Telefon: " + dades[1]);
                    System.out.println("Correu: " + dades[2]);

                    trobat = true;
                }
            }

            br.close();
            //Diferents errors
            if (!trobat) {
                System.out.println("Contacte no trobat.");
            }

        } catch (IOException e) {
            System.out.println("El fitxer encara no existeix.");
        }
    }

    //Menu principal
    public static void main(String[] args) {

        Agenda programa = new Agenda();
        Scanner scanner = new Scanner(System.in);

        // Carreguem els contactes en comencar
        programa.carregarContactes();

        int opcio;
        //Tot el que entra dins del menu com a tal
        do {

            System.out.println("\n===== AGENDA =====");
            System.out.println("1. Afegir contacte");
            System.out.println("2. Llistar contactes");
            System.out.println("3. Cercar per nom");
            System.out.println("4. Sortir");
            System.out.print("Opcio: ");

            opcio = Integer.parseInt(scanner.nextLine());
            //Menu de seleccio
            switch (opcio) {
                //Posar mes contactes
                case 1:
                    programa.afegirContacte(scanner);
                    break;
                //Veure els contactes
                case 2:
                    programa.llistarContactes();
                    break;
                //Buscar per nom
                case 3:
                    programa.cercarPerNom(scanner);
                    break;
                //Sortir
                case 4:
                    System.out.println("Programa finalitzat.");
                    break;
                //Variable incorrecta
                default:
                    System.out.println("Opcio incorrecta.");
            }
        //Finalitzar el bucle
        } while (opcio != 4);
        scanner.close();
    }
}
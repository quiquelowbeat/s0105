package n1exercici4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DirectoryTree {
	static BufferedWriter outTxt;
	public static void main(String[] args) throws NullPointerException, IOException {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		String pathToFile;
		
		do {
			
			System.out.println("\nEscoge una opción:"
					+ "\n1- Buscar ruta de directorio y escribir archivo .TXT con listado de archivos"
					+ "\n2- Buscar archivo .TXT y leer contenido por consola"
					+ "\n3- Salir");
			try {
				
				menu = sc.nextInt();
				sc.skip("\n");
				
				switch(menu) {
				
					case 1: 
						
						System.out.println("Introduce ruta de directorio:");
						File dir = new File(sc.nextLine()); // Lee la ruta del directorio que le pasamos por consola.
						
						try {
							
							System.out.println("Indica el nombre y ruta del archivo a guardar:");
							outTxt = new BufferedWriter(new FileWriter(sc.nextLine()));
							getListFiles(dir.listFiles()); // Devuelve array de Files[] de lo que hay dentro del directorio introducido. Mandamos a método getListFiles.
							System.out.println("Archivo guardado con éxito.\n");
							outTxt.close();
							
						} catch (NullPointerException e) {
							
							System.out.println("Directorio no encontrado.");
							
						} catch (IOException e) {
							
							System.out.println("Ruta incorrecta.\n");
							
						}
						
						break;
						
					case 2:	
					
						System.out.println("Introduce ruta del archivo a leer:");
						pathToFile = sc.nextLine();
						readFile(pathToFile);  // Método para leer archivos. 
						System.out.println("Archivo leído con éxito.\n");
						
						break;
						
					case 3:
						
						System.out.println("\nPrograma finalizado.");
						
						break;
				
			}
			
			} catch (InputMismatchException e) {
				
				System.out.println("Opción incorrecta: debes introducir un número.");
				sc.nextLine();
			} 
			
		
		} while (menu < 1 || menu > 3);
		
	}	
	
	 public static void getListFiles(File[] dir) throws NullPointerException, IOException {
		 
		 DateFormat milliToDate = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z"); // Indicamos el formato de la fecha que vamos a representar con los milisegundos. 
		 Arrays.sort(dir); // Ordenamos el array de Files[] por orden alfabético.
		 
		 for(File f : dir) { // Navegamos por el array.
			 
			 Date milli = new Date(f.lastModified()); // Pasamos de milisegundos a formato Date.
			 
			 try {
				 
				 if(f.isDirectory()) {
					 
					 System.out.println(f.getAbsolutePath() + " (D)");
					 outTxt.write(f.getAbsolutePath() + " (D) - Última modificación: " + milliToDate.format(milli)  + "\n");
					 getListFiles(f.listFiles()); // Hacemos la función recursiva para que "navegue" entre el resto de directorios.
					 
				 } else {
					 
					 System.out.println(f.getAbsolutePath() + " (F) - Última modificación: " + milliToDate.format(milli));
					 outTxt.write(f.getAbsolutePath() + " (F) - Última modificación: " + milliToDate.format(milli) + "\n");
				 }
				 
			 } catch (NullPointerException | IOException e) {
				 
				 e.printStackTrace();
				 
			 } 
			 
		}
		 
	 }
	 
	 public static void readFile(String pathToFile) throws IOException {
		 
		 BufferedReader out = null;
		 String stringLine;
		 
		 try {
			 
			out = new BufferedReader(new FileReader(pathToFile));
			
			System.out.println("\nLeyendo archivo...\n");
			
			while((stringLine = out.readLine()) != null) {
				
				System.out.println(stringLine);
				
			}
			
			System.out.println("\n");
			
		} catch (IOException e) {
			
			System.out.println("Archivo no encontrado.\n");
			
		} finally {
			
			if(out != null) {
				
				out.close();
				
			}
			
		}
		 
	 }

}


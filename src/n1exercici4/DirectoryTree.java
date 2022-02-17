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
			
			menu = sc.nextInt();
			sc.skip("\n");
			
			switch(menu) {
			
				case 1: 
					
					System.out.println("Introduce ruta de directorio:");
					File dir = new File(sc.nextLine());
					
					try {
						
						System.out.println("Indica el nombre y ruta del archivo a guardar:");
						outTxt = new BufferedWriter(new FileWriter(sc.nextLine()));
						getListFiles(dir.listFiles());
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
					readFile(pathToFile);
					
					break;
			
			}
		
		} while (menu != 3);
		
	}	
	
	 public static void getListFiles(File[] dir) throws NullPointerException, IOException {
		 
		 DateFormat milliToDate = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
		 Arrays.sort(dir);
		 
		 for(File f : dir) {
			 
			 Date milli = new Date(f.lastModified());
			 
			 try {
				 
				 if(f.isDirectory()) {
					 
					 System.out.println(f.getAbsolutePath() + " (D)");
					 outTxt.write(f.getAbsolutePath() + " (D) - Última modificación: " + milliToDate.format(milli)  + "\n");
					 getListFiles(f.listFiles());
					 
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
		 String strCurrentLine;
		 
		 try {
			 
			out = new BufferedReader(new FileReader(pathToFile));
			
			System.out.println("\nLeyendo archivo...\n");
			
			while((strCurrentLine = out.readLine()) != null) {
				
				System.out.println(strCurrentLine);
				
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


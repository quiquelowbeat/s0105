package n1exercici3;

import java.io.BufferedWriter;
import java.io.File;
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
		System.out.println("Introduce el directorio:");
		
		File dir = new File(sc.nextLine());
		
		try {
			outTxt = new BufferedWriter(new FileWriter("/Users/quiquesanchezsuarez/eclipse-workspace/S0105/test/output.txt"));
			getListFiles(dir.listFiles());
			System.out.println("Fin de la búsqueda.");
			outTxt.close();
			
		} catch (NullPointerException e) {
			
			System.out.println("Directorio no encontrado.");
			
		} catch (IOException e) {
			
			System.out.println("Ruta incorrecta.");
			
		}
		
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
}

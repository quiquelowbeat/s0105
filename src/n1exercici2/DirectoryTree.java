package n1exercici2;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DirectoryTree {

	public static void main(String[] args) throws NullPointerException {
		
		System.out.println("Introduce el directorio:");
		
		Scanner sc = new Scanner(System.in);
		
		File dir = new File(sc.nextLine());
		
		try {
			
			listFiles(dir.listFiles());
			System.out.println("Fin de la búsqueda.");
			
		} catch (NullPointerException e) {
			
			System.out.println("Directorio no encontrado.");
			
		} 

	}	
	
	 public static void listFiles(File[] dir) throws NullPointerException {
		 
		 DateFormat milliToDate = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
		 Arrays.sort(dir);
		 
		 for(File f : dir) {
			 
			 try {
				 
				 if(f.isDirectory()) {
					 
					 System.out.println(f.getAbsolutePath() + " (D)");
					 listFiles(f.listFiles());
					 
				 } else {
					 
					 Date milli = new Date(f.lastModified()); 
					 System.out.println(f.getAbsolutePath() + " (F) - Última modificación: " + milliToDate.format(milli));
					 
				 }
				 
			 } catch (NullPointerException e) {
				 
				 e.getMessage();
				 
			 }
			 
		}
		 
	 }
}

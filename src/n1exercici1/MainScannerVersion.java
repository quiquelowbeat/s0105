package n1exercici1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MainScannerVersion {

	public static void main(String[] args) throws NullPointerException {
		
		Scanner sc = new Scanner(System.in);
		
		try {
	
			String[] files;
			
			System.out.println("Introduce la ruta del directorio que quieres listar:");
			
			File f = new File(sc.nextLine());
			
			files = f.list();
			
			Arrays.sort(files);
			
			for(String pathsFiles : files) {
				
				System.out.println(pathsFiles);
				
			}
			
			
		} catch (NullPointerException e) {
			
			System.out.println("Directorio no encontrado.");
			
		} finally {
			
			if(sc != null) {
				
				sc.close();
				
			}
			
		}
		
	}

}

package n1exercici1;

import java.io.File;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws NullPointerException {
		
		try {
	
			String[] files;
			
			File f = new File(JOptionPane.showInputDialog("Introduce la ruta del directorio que quieres listar:"));
			
			files = f.list();
			
			Arrays.sort(files);
			
			JOptionPane.showMessageDialog(null, files, "Lista de archivos", JOptionPane.PLAIN_MESSAGE);
			
		} catch (NullPointerException e) {
			
			JOptionPane.showMessageDialog(null, "Directorio no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
		
	}

}

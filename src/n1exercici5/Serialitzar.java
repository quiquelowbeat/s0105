package n1exercici5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Serialitzar {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Alumno> students = new ArrayList<>();
		
		students.add(new Alumno("Enric", "Pérez", "FDLP", 2021, 12, 23));
		students.add(new Alumno("Josep", "Roca", "Backend Java", 2022, 2, 2));
		students.add(new Alumno("Miriam", "Ballester", "Fullstack PHP", 2021, 10, 11));
		
		try {
			
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("/Users/quiquesanchezsuarez/eclipse-workspace/S0105/test/serializable.ser"));
			output.writeObject(students);
			output.close();
			
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("/Users/quiquesanchezsuarez/eclipse-workspace/S0105/test/serializable.ser"));
			ArrayList<Alumno> studentsFile = (ArrayList<Alumno>) input.readObject();
			input.close();	
			
			for(Alumno s : studentsFile ) {
				
				System.out.println(s);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}

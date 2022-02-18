package n1exercici5;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Alumno implements Serializable {
	
	private String name;
	private String lastName;
	private String course;
	private String membershipDate;
	private SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
	
	public Alumno(String name, String lastname, String course, int year, int month, int day) {
		
		this.name = name;
		this.lastName = lastname;
		this.course = course;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		this.membershipDate = formattedDate.format(calendar.getTime());
		
	}
	
	public String toString() {
		
		return "Nombre: " + this.name + "\nApellido: " + this.lastName + "\nCurso: "  + this.course + "\nFecha de alta: " + this.membershipDate + "\n";
		
	}
	

}

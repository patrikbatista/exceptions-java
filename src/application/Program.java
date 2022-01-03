package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { //neste momento estou propagando a excessao, posteriormente irei trata-la
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next()); // transforma o scanner no formato de data requerido
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)){//testa se o checkout vem depois do checkin
		
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation " + reservation);
					
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			
				
			String error = reservation.updateDates(checkin, checkout);
			if (error != null) {
				System.out.println("Error in Reservartion: " + error);
			}
			else {
				System.out.println("Reservation " + reservation);
			}
			
		}
		
		
		
		sc.close();

	}

}

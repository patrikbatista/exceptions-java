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
			
			//agora para fazer atualizacao da reserva
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next()); // transforma o scanner no formato de data requerido
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			//tratamento de erro para data de atualizacao, essa forma é a considerada incorreta, posteriormente vai ser alterada, apenas fins didaticos
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for updates must be future dates");
			}
			else if(!checkout.after(checkin)) {//testa se o checkout vem depois do checkin
				
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				
				//agora que li as novas datas, é hora de atualizar, usando o método updateDate
				
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation " + reservation);
			
			}
		}
		
		
		
		sc.close();

	}

}

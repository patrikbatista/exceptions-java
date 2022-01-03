package model.entites;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkin, checkout;
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	public long duration() {
		long diff = this.checkout.getTime() - this.checkin.getTime(); //transforma em milesegundos para depois converter em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte diff em dias usando a classe TimeUnit
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.setCheckin(checkin);
		this.setCheckout(checkout);
	}
	
	
}
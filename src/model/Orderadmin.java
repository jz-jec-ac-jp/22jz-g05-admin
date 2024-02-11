package model;

import java.time.LocalDateTime;

public class Orderadmin {
	String UserName;
	int ItemSUM;
	int PriceSUM;
	LocalDateTime Payment_date;
	int user_id;

	public String getUserName() {
		return UserName;
	}
	public int getItemSUM() {
		return ItemSUM;
	}
	public int getPriceSUM() {
		return PriceSUM;
	}
	public  LocalDateTime getPayment_date() {
		return Payment_date;
	}
	public int getUser_id() {
		return user_id;
	}
	
	public Orderadmin(String UserName, int ItemSUM, int PriceSUM,LocalDateTime PaymentStatus) {
		this.UserName = UserName;
		this.ItemSUM = ItemSUM;
		this.PriceSUM = PriceSUM;
		this.Payment_date = PaymentStatus;
	}

	public Orderadmin(int user_id2, int item_id, LocalDateTime date) {
		this.user_id = user_id2;
		this.ItemSUM = item_id;
		this.Payment_date = date;
	}
}

package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Ph implements Serializable{
	private int id;
	private LocalDateTime purchase_date;
	private User user;
	private Item itemlist;
	private LocalDateTime addDate;
	private LocalDateTime upDate;
	private Itemsize size;
	private Itemcolor color;
	private Item item;
	
	public Item getItem() {
		return item;
	}
	
	public Itemsize getSize() {
		return size;
	}
	public Itemcolor getColor() {
		return color;
	}
	public LocalDateTime getPurchase_date() {
		return purchase_date;
	}
	public int getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public Item getItemlist() {
		return itemlist;
	}
	public LocalDateTime getAddDate() {
		return addDate;
	}
	public LocalDateTime getUpDate() {
		return upDate;
	}
	
	
	
	
	public Ph(int id, LocalDateTime purchase_date, User user, Item itemlist,  Itemsize size, Itemcolor color) {
		this.id = id;
		this.purchase_date = purchase_date;
		this.user = user;
		this.itemlist = itemlist;
		this.size = size;
		this.color = color;
	}
	public Ph() {
		
	}
	
}

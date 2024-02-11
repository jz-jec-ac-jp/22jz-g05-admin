package model;

import java.time.LocalDateTime;

public class Itemcolor {
	private int id;
	private String itemColor;
	private LocalDateTime addDate;
	private LocalDateTime upDate;
	private int itemID;
	public int getId() {
		return id;
	}
	public String getItemColor() {
		return itemColor;
	}
	public LocalDateTime getAddDate() {
		return addDate;
	}
	public LocalDateTime getUpDate() {
		return upDate;
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public Itemcolor(int id, String itemColor, LocalDateTime addDate, LocalDateTime upDate, int itemID) {
		this.id = id;
		this.itemColor = itemColor;
		this.addDate = addDate;
		this.upDate = upDate;
		this.itemID = itemID;
	}
	public Itemcolor() {
	}
}

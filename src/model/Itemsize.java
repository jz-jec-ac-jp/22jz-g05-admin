package model;

import java.time.LocalDateTime;

public class Itemsize {
	private int id;
	private String itemSize;
	private LocalDateTime addDate;
	private LocalDateTime upDate;
	private int itemID;
	public int getId() {
		return id;
	}
	public String getItemSize() {
		return itemSize;
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
	
	public Itemsize(int id, String itemSize, LocalDateTime addDate, LocalDateTime upDate, int itemID) {
		this.id = id;
		this.itemSize = itemSize;
		this.addDate = addDate;
		this.upDate = upDate;
		this.itemID = itemID;
	}
	public Itemsize() {
	
	}
}

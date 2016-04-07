package test.beans;

import java.io.Serializable;

public class ItemData 
implements Serializable {
	private static final long serialVersionUID = 8414977271238533234L;
	
	private String title;
	private int year;
	private int month;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	
}

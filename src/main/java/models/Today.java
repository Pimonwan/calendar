/* 5810405207 Pimonwan Sutmee */

package models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Today {
	Calendar calendar;
	private int year;
	private int month;
	private int day;
		
	
	public Today() {
		this.calendar = new GregorianCalendar();
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);	
	}
	
	 
	 public boolean isLeap(int year) {
		 if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
		     return true;
		  return false;
	 }
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;	
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String toString(int num) {
		return num+"";
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

}


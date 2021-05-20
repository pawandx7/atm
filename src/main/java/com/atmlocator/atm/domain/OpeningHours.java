package com.atmlocator.atm.domain;

import java.util.List;

public class OpeningHours {
	
	private int dayOfWeek;
	List<Hours> hours;
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public List<Hours> getHours() {
		return hours;
	}
	public void setHours(List<Hours> hours) {
		this.hours = hours;
	}
	
}

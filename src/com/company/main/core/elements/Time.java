package com.company.main.core.elements;

public class Time {
	private Integer hours;
	private Integer minutes;
	private Integer seconds;

	public Time(Integer seconds) {
		this(0, 0, seconds);
	}

	public Time(Integer minutes, Integer seconds) {
		this(0, minutes, seconds);
	}

	public Time(Integer hours, Integer minutes, Integer seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
}

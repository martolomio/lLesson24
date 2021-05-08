package com.homework.cinema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//this is main class of task 
public class Time implements Comparable<Time>{

	private int hour;
	private int min;
	
	public Time(int hour,int min ) {
		this.min = min;
		this.hour = hour;
		if(hour>=24) {
		hour=hour-24+1;
		}else if(min>=60) {
		min= min-60;
		hour= hour+1;
		}
	}
	public int getHour() {
			return hour;
	}

	public int getMin() {
		return min;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}	
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public static Time inputTime(){
		
		Scanner scanner = new Scanner(System.in);
		List<Integer> time = new ArrayList<Integer>(Arrays.asList(null, null));

		System.out.print("Example : 22 22 : \n"+"Enter the time: ");
		for (int i = 0; scanner.hasNextInt(); i++) {
			if (scanner.hasNextInt())
				time.add(i, scanner.nextInt());
			
		}
		if (time.size() - 2 < 2)
			System.err.println("This time is wrong ");

		int hour = Optional.ofNullable(time.get(0)).orElse(0);
		int min = Optional.ofNullable(time.get(1)).orElse(0);
		
		return new Time(hour, min);
	}
	public static Integer timeToMinutes(Time time) {
		return time.getHour() * 60 + time.getMin();
	}

	public static Time minutesToTime(Integer minutes){
		int hour = minutes / 60;
		int min = minutes - hour * 60;

		return new Time(hour, min);
	}

	public static Time sumTime(Time time1, Time time2){
		int hour = time1.getHour() + time2.getHour();
		int min = time1.getMin() + time2.getMin();

		if (min >= 60) {
			hour = hour + 1;
			min = min - 60;
		} else if (hour >= 24) {
			hour = hour - 24;
		}

		return new Time(hour, min);
	}
	public static final Time getMinValue(){
		return new Time(0, 0);
	}

	public static final Time getMaxValue(){
		return new Time(23, 59);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Time hour=" + hour + " min=" + min ;
	}
	@Override
	public int compareTo(Time o) {
		if(this.hour > o.hour) return 1;
		if(this.hour < o.hour) return -1;
		if(this.min > o.min) return 1;
		if(this.min < o.min) return -1;
		return 0;
	}
}

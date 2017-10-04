package com.ubs.opsit.interviews;

public class BerlinClock implements TimeConverter{

	@Override
	public String convertTime(String aTime) {
		Time time = Time.parse(aTime);
    	ClockState clockState = show(time);
    	return clockState.toString();
	}

	public static ClockState show(Time time){
    	return new ClockState(time);
    }
	
	public static void main(String[] args) {
		BerlinClock bc = new BerlinClock();
		System.out.println(bc.convertTime("24:00:00"));
	}
}

package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.ValidateUtils.validateMatchesPattern;
import static com.ubs.opsit.interviews.ValidateUtils.validateRangeFromZeroUntil;
import static com.ubs.opsit.interviews.ValidateUtils.validateRangeFromZeroUpTo;
import static org.apache.commons.lang.math.NumberUtils.toInt;

import org.apache.commons.lang.Validate;

/**
 * Immutable Time encapsulates hour, minute and second of a day.
 */
public class Time {

	final int hour;
	final int minutes;
	final int seconds;

	public Time(int hour, int minutes, int seconds){
		validateRangeFromZeroUpTo(24, hour, "hour"); 
		validateRangeFromZeroUntil(60, minutes, "minutes"); 
		validateRangeFromZeroUntil(60, seconds, "seconds"); 
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
	 * Parses given string as a {@link Time}.
	 * @param aTime time string in HH:mm:ss format
	 */
	public static Time parse(String aTime){
		Validate.notNull(aTime,"Time.parse() `aTime` argument should not be null");
    	validateMatchesPattern("\\d\\d:\\d\\d:\\d\\d", aTime, "aTime");
    	String[] parts = aTime.split(":");
    	int hour = toInt(parts[0]);
    	int minutes = toInt(parts[1]);
    	int seconds = toInt(parts[2]);
    	return new Time(hour, minutes, seconds);
	}

	@Override
	public String toString(){
		return String.format("%02d:%02d:%02d",hour,minutes,seconds);
	}
}

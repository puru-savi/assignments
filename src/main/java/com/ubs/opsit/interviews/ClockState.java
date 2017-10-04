package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrBuilder;

/**  
 * Immutable ClockState represents clock's lights visible state.
 * State of each of rows is encoded as a String consisting of characters 'R','Y' and 'O'.
 */
public class ClockState {

	final String second;
	final String hour1;
	final String hour2;
	final String minutes1;
	final String minutes2;

	ClockState(Time time) {
		this.second = formatSecondsRow(time.seconds);
		this.hour1 = formatHours1Row(time.hour);
		this.hour2 = formatHours2Row(time.hour);
		this.minutes1 = formatMinutes1Row(time.minutes);
		this.minutes2 = formatMinutes2Row(time.minutes);
	}

	@Override
	public String toString(){
    	return new StrBuilder()
    		.appendWithSeparators(
    			new String[]{ second, hour1, hour2, minutes1, minutes2 }, 
    			System.lineSeparator()
    		).toString();
	}

    private String formatSecondsRow(int seconds){
    	if(seconds%2==0) return "Y"; else return "O";
    }

    private String formatHours1Row(int hour){
    	int numberOfRedCells = hour / 5;
    	return formatRow("R", numberOfRedCells, 4);
    }

    private String formatHours2Row(int hour){
    	int numberOfRedCells = hour % 5;
    	return formatRow("R", numberOfRedCells, 4);
    }

    private String formatMinutes1Row(int minutes){
    	char[] row = formatRow("Y", minutes / 5, 11).toCharArray();
    	changeToRedIfYellow(row, 2);
    	changeToRedIfYellow(row, 5);
    	changeToRedIfYellow(row, 8);
    	return new String(row);
    }

    private String formatMinutes2Row(int minutes){
    	int numberOfRedCells = minutes % 5;
    	return formatRow("Y", numberOfRedCells, 4);
    }

    private String formatRow(String light, int times, int length){
    	return StringUtils.repeat(light, times) + StringUtils.repeat("O", length - times);
    }

    private void changeToRedIfYellow(char[] row, int index){
    	if(row[index]=='Y') row[index] = 'R';
    }
}

package appointmentCalendar;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TimePicker extends JFrame
{
    private String input, hours, minutes, input1, input2, hours1, hours2, minutes1, minutes2;
	private String[] times1 = new String[2];
	private String[] times2 = new String[2];
    private int hour, minute, hour1, minute1, hour2, minute2;
    boolean isCorrect = true;
 
    public boolean TimePicker (String g)
    {
    	//split the string into hours and minutes
    	input = g;
    	String[] times = input.split(":");
    	hours = times[0];
    	
    	//check for invalid input
    	if (times[1] == null)
    		return false;
    	
    	
    	minutes = times[1];
    	
    	//change string into integers
    	hour = Integer.parseInt(hours);
    	minute = Integer.parseInt(minutes);
    	
    	//check #2
    	if(hour < 24 && hour >= 0 && minute < 60 && minute >= 0)
    		return(isCorrect);
    	
    	else
    	{
    		isCorrect = false;
    		return isCorrect;
    	}
    }
    
    //see if time1 is earlier than time2
    public boolean TimeIsTrue (String g, String h)
    {
    	input1 = g;
    	input2 = h;
    	times1 = input1.split(":");
    	times2 = input2.split(":");
    	
    	hours1 = times1[0];
    	minutes1 = times1[1];
    	hours2 = times2[0];
    	minutes2 = times2[1];
    	
    	hour1 = Integer.parseInt(hours1);
    	minute1 = Integer.parseInt(minutes1);
    	hour2 = Integer.parseInt(hours2);
    	minute2 = Integer.parseInt(minutes2);
    	if (hour1 < hour2)
    		return (true);
    	else if (minute1 < minute2)
    		return (true);
    	else
    		return (false);
    }
}
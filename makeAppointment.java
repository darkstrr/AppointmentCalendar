package appointmentCalendar;

import java.awt.EventQueue;

public class makeAppointment {
	
	public void makeAppointment()
	{
	EventQueue.invokeLater(new Runnable()
	{	
		
		public void run()
		{
			
			try // try block 
			{
			     //create frame object
			     DatePickerExample frame = new DatePickerExample();
			     frame.setVisible(true);//set visible true
		    }
		    catch (Exception e) //catch the exception
		    {
		         e.printStackTrace();
		    }
	     }          
     });
	}
}
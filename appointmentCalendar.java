package appointmentCalendar;

import java.awt.EventQueue;

public class appointmentCalendar{

	public static void main(String[] args)// main method
	{
		//run main program
		EventQueue.invokeLater(new Runnable()
		{	
			
			public void run()
			{
				
				try // try block 
				{
				     //create frame object
				     Add frame = new Add();
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
package appointmentCalendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class DatePickerExample extends JFrame {
	// add JPanel to the contentPane
	private JPanel contentPane;

	// declare variable
	private JTextField txtDate;
	private JTextField txtTime1;
	private JTextField txtTime2;
	private JTextField name;
	private JTextField removal;
	private String date = "";
	private String time1 = "";
	private String time2 = "";
	private String events = "";
	private String re = "";
	JLabel label1, label2, label3;
	boolean ok1, ok2, ok3;
	boolean Entered = false;
	static private ArrayList<String> appointments = new ArrayList<String>();

	/**
	 * Create the frame.
	 */
	// create constructor of class
	public DatePickerExample() {
		// set title
		setTitle("Appointment Picker ");
		// set close operation on frame
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		// set bounds of frame
		setBounds(100, 100, 486, 300);

		// create new JPanel in contentPane
		contentPane = new JPanel();

		// set border of frame
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		// set contentPane
		setContentPane(contentPane);

		// set layout null
		contentPane.setLayout(null);

		// create text field
		txtDate = new JTextField();

		// set bounds of text field
		txtDate.setBounds(101, 40, 86, 20);

		// add text field to contentPane
		contentPane.add(txtDate);
		txtDate.setText("Date -->");

		// set columns
		txtDate.setColumns(18);

		// create date button
		JButton DateButton = new JButton("Date");

		// perform action listener
		DateButton.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				// create frame new object f
				final JFrame f = new JFrame();
				// set text which is collected by date picker i.e. set date
				txtDate.setText(new DatePicker(f).setPickedDate());
				date = txtDate.getText();
			}
		});

		// set button bound
		DateButton.setBounds(223, 40, 96, 23);

		// add button in contentPane
		contentPane.add(DateButton);

		// create text field
		txtTime1 = new JTextField();

		// set bounds of text field
		txtTime1.setBounds(101, 80, 86, 20);

		// add text field to contentPane
		contentPane.add(txtTime1);
		label1 = new JLabel("Enter Times in 24 hour format");
		label1.setBounds(80, 10, 240, 23);
		txtTime1.setText("00:00");
		txtTime1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTime1.setText("");
			}
		});

		// set columns
		txtTime1.setColumns(18);

		// create time button
		JButton TimeButtonA = new JButton("Start Time");

		// perform action listener
		TimeButtonA.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				// set text which is collected by text box
				time1 = txtTime1.getText();
				TimePicker times1 = new TimePicker();
				ok1 = times1.TimePicker(time1);
			}
		});
		// set button bound
		TimeButtonA.setBounds(223, 80, 96, 23);

		// add button in contentPane
		contentPane.add(TimeButtonA);
		contentPane.add(label1);

		// create end time text field
		txtTime2 = new JTextField();

		// set bounds of text field
		txtTime2.setBounds(101, 120, 86, 23);

		// add text field to contentPane
		contentPane.add(txtTime2);
		txtTime2.setText("00:00");

		// set columns
		txtTime2.setColumns(18);
		
		//clear text field when clicked
		txtTime2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTime2.setText("");
			}
		});

		// create date button
		JButton TimeButtonB = new JButton("End Time");

		// perform action listener
		TimeButtonB.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				// set text which is collected by text box
				time2 = txtTime2.getText();

			}
		});
		// set button bound
		TimeButtonB.setBounds(223, 120, 96, 23);

		// add button in contentPane
		contentPane.add(TimeButtonB);

		// create name text field
		name = new JTextField();

		// set bounds of text field
		name.setBounds(101, 160, 150, 20);

		// add text field to contentPane
		contentPane.add(name);
		name.setText("Type Event Name");

		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});

		// set columns
		name.setColumns(18);
		/*
		 * 
		 */
		JButton Enter = new JButton("Enter");

		// perform action listener
		Enter.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				// get the event typed
				events = name.getText();
				time2 = txtTime2.getText();
				time1 = txtTime1.getText();
				date = txtDate.getText();

				TimePicker times1 = new TimePicker();
				TimePicker times2 = new TimePicker();
				TimePicker times3 = new TimePicker();

				//check for errors in text boxes
				ok1 = times1.TimePicker(time1);
				ok2 = times2.TimePicker(time2);
				ok3 = times3.TimeIsTrue(time1, time2);

				String notok = "PLease enter correct times";
				String redo = "Incorrect Times";
				String exit1 = " Appointment set!\n Hit red X in top right to close appointment window";
				String exitmessage = "Exit Massage";
				
				//message for errors
				if (!ok3 || !ok1 || !ok2) {
					JOptionPane.showMessageDialog(null, notok, "InfoBox: " + redo, JOptionPane.INFORMATION_MESSAGE);
				}
				String appointment = events + " " + date + " " + time1 + " " + time2;
				getAppoint(appointment);

				if (ok1 && ok2 && ok3) {
					JOptionPane.showMessageDialog(null, exit1, "InfoBox: " + exitmessage,
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// set button bound
		Enter.setBounds(180, 200, 120, 20);

		// add button in contentPane
		contentPane.add(Enter);
	}
	
	//display appointments
	private void displayGUI() {
		JOptionPane.showMessageDialog(null, getPanel(), "Appointments : ", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//string all appointments into 1 string to print out
	private String getPanel() {
		String allAppoint = "";
		for (int i = 0; i < appointments.size(); i++) {
			if (i == 0)
				allAppoint = (1) + ". " + appointments.get(i) + "\n";
			else
				allAppoint = allAppoint + (i + 1) + ". " + appointments.get(i) + "\n";

		}
		return allAppoint;
	}
	//get all appointments set
	public void getAppointments() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				new DatePickerExample().displayGUI();
			}
		};
		EventQueue.invokeLater(runnable);
	}
	//add new appointments into appointments array list
	public void getAppoint(String hi) {
		String appointment = hi;
		appointments.add(appointment);
	}

	// remove appointments
	public void removeAppoint() {
		// set title
		setTitle("Appointment Remover ");
		// set close operation on frame
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		// set bounds of frame
		setBounds(100, 100, 486, 300);

		// create new JPanel in contentPane
		contentPane = new JPanel();

		// set border of frame
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		// set contentPane
		setContentPane(contentPane);

		// set layout null
		contentPane.setLayout(null);

		// create text field
		removal = new JTextField();

		// set bounds of text field
		removal.setBounds(90, 40, 130, 23);

		// add text field to contentPane
		contentPane.add(removal);
		removal.setText("Appointment Number");

		// set columns
		txtDate.setColumns(30);

		// create date button
		JButton Removes = new JButton("Remove");
		JButton display = new JButton("Appointments");

		removal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removal.setText("");
			}
		});
		// perform action listener
		Removes.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				String error = "Invalid Appointment Number \nEnter valid appointment number";
				String error1 = "Invalid Appointment Number";
				re = removal.getText();
				int number = 0;

				if (number > appointments.size()) {
					JOptionPane.showMessageDialog(null, error, "InfoBox: " + error1, JOptionPane.INFORMATION_MESSAGE);
				} else if (appointments.size() > 0) {
					try {
						number = Integer.parseInt(re);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, error, "InfoBox: " + error1,
								JOptionPane.INFORMATION_MESSAGE);
					}
					appointments.remove(Integer.parseInt(re) - 1);
					String yes = "Appointment Successfully Removed";
					String yes1 = "Appointment Removed";
					JOptionPane.showMessageDialog(null, yes, "InfoBox: " + yes1, JOptionPane.INFORMATION_MESSAGE);
				} else if (appointments.size() == 0) {
					String no = "No Appointments \nAdd Appointments";
					String no1 = "No Appointments";
					JOptionPane.showMessageDialog(null, no, "InfoBox: " + no1, JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});

		display.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				DatePickerExample s = new DatePickerExample();
				s.getAppointments();
			}
		});
		label2 = new JLabel("Enter Appointment Number to Remove");
		label2.setBounds(80, 10, 240, 23);
		label3 = new JLabel("Appointment Numbers");
		label3.setBounds(80, 70, 240, 23);
		// set button bound
		display.setBounds(180, 100, 140, 23);

		// add button in contentPane
		contentPane.add(display);

		// set button bound
		Removes.setBounds(223, 40, 96, 23);

		// add button in contentPane
		contentPane.add(Removes);
	}
}
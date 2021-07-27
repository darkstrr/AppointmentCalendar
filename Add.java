package appointmentCalendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Add extends JFrame {
	private JPanel contentPane;
	// declare variable
	private JTextField txtDate;

	/**
	 * Create the frame.
	 */
	// create constructor of class
	public Add() {
		// set title
		setTitle("Add Appointment");
		// set close operation on frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set bounds of frame
		setBounds(200, 200, 900, 600);

		// create new JPanel in contentPane
		contentPane = new JPanel();

		// set contentPane
		setContentPane(contentPane);

		// set layout null
		contentPane.setLayout(null);

		// set border of frame
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		// set contentPane
		setContentPane(contentPane);

		// set layout null
		contentPane.setLayout(null);

		// create button and the object
		JButton btnNewButton = new JButton("New Appointment");
		JButton addAppoint = new JButton("Display Appointments");
		JButton removeAppoint = new JButton("Remove Appointments");

		// perform action listener
		btnNewButton.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				makeAppointment b = new makeAppointment();
				b.makeAppointment();
			}
		});

		// set button bound
		btnNewButton.setBounds(600, 100, 180, 23);

		// add button in contentPane
		contentPane.add(btnNewButton);

		addAppoint.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				DatePickerExample s = new DatePickerExample();
				s.getAppointments();
			}
		});
		// set button bound
		addAppoint.setBounds(600, 130, 180, 23);

		// add button in contentPane
		contentPane.add(addAppoint);

		// set button action
		removeAppoint.addActionListener(new ActionListener() {
			// performed action
			public void actionPerformed(ActionEvent arg0) {
				DatePickerExample s = new DatePickerExample();
				s.setVisible(true);// set visible true
				s.removeAppoint();
			}
		});
		// set button bound
		removeAppoint.setBounds(600, 160, 180, 23);

		// add button in contentPane
		contentPane.add(removeAppoint);
	}
}
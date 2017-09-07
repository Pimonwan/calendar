/* 5810405207 Pimonwan Sutmee */

package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import models.Today;

public class CalendarView extends JPanel {
	private Today today;
	protected int yy, mm, dd;
	protected JButton labs[][];
	protected int leadGap = 0;
	Calendar calendar = new GregorianCalendar();
	protected final int thisYear = calendar.get(Calendar.YEAR);
	protected final int thisMonth = calendar.get(Calendar.MONTH);
	private JButton b0, addEventBtn;
	private JComboBox monthChoice, yearChoice;
	private JPanel calPanel, btnPanel;
	
	/**
	 * Construct a Cal, starting with today.
	 */
	public CalendarView() {
		calPanel = new JPanel();
		btnPanel = new JPanel();
		today = new Today();
		yy = today.getYear();
		mm = today.getMonth();
		dd = today.getDay();
		buildGUI();
		recompute();
	}

	private void buildGUI() {
		getAccessibleContext().setAccessibleDescription("Calendar not accessible yet. Sorry!");
		setBorder(BorderFactory.createEtchedBorder());

		setLayout(new BorderLayout());

		JPanel tp = new JPanel();
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		tp.add(monthChoice = new JComboBox(months));		
//		for (int i = 0; i < months.length; i++)
//			monthChoice.addItem(months[i]);
		monthChoice.setSelectedItem(months[mm]);
		monthChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int i = monthChoice.getSelectedIndex();
				if (i >= 0) {
					mm = i;
					// System.out.println("Month=" + mm);
					recompute();
				}
			}
		});
		monthChoice.getAccessibleContext().setAccessibleName("Months");
		monthChoice.getAccessibleContext().setAccessibleDescription("Choose a month of the year");

		tp.add(yearChoice = new JComboBox());
		yearChoice.setEditable(true);
		for (int i = yy - 10; i < yy + 20; i++)
			yearChoice.addItem(Integer.toString(i));
		yearChoice.setSelectedItem(Integer.toString(yy));
		yearChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int i = yearChoice.getSelectedIndex();
				if (i >= 0) {
					yy = Integer.parseInt(yearChoice.getSelectedItem().toString());
					// System.out.println("Year=" + yy);
					recompute();
				}
			}
		});
		calPanel.add(BorderLayout.CENTER, tp);

		JPanel bp = new JPanel();
		bp.setLayout(new GridLayout(7, 7));
		labs = new JButton[6][7]; // first row is days

		bp.add(b0 = new JButton("S"));
		bp.add(new JButton("M"));
		bp.add(new JButton("T"));
		bp.add(new JButton("W"));
		bp.add(new JButton("T"));
		bp.add(new JButton("F"));
		bp.add(new JButton("S"));

		// Construct all the buttons, and add them.
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++) {
				bp.add(labs[i][j] = new JButton(""));
				labs[i][j].setBackground(Color.yellow);
				if(j == 0 || j == 6) {
					labs[i][j].setBackground(Color.RED);
				}
			}

		calPanel.add(BorderLayout.SOUTH, bp);
		
		addEventBtn = new JButton("Add Event");
		btnPanel.add(addEventBtn);
		
		this.add(calPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}

	public final static int dom[] = { 31, 28, 31, 30, /* jan feb mar apr */
			31, 30, 31, 31, /* may jun jul aug */
			30, 31, 30, 31 /* sep oct nov dec */
	};

	protected void recompute() {
		if (mm < 0 || mm > 11)
			throw new IllegalArgumentException("Month " + mm + " bad, must be 0-11");
		calendar = new GregorianCalendar(yy, mm, dd);

		// Compute how much to leave before the first.
		// getDay() returns 0 for Sunday, which is just right.
		leadGap = new GregorianCalendar(yy, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;
		// System.out.println("leadGap = " + leadGap);

		int daysInMonth = dom[mm];
		if (isLeap(calendar.get(Calendar.YEAR)) && mm == 1)
			// if (isLeap(calendar.get(Calendar.YEAR)) && mm > 1)
			++daysInMonth;

		// Blank out the labels before 1st day of month
		for (int i = 0; i < leadGap; i++) {
			labs[0][i].setText("");
		}

		// Fill in numbers for the day of month.		
		for (int i = 1; i <= daysInMonth; i++) {
			JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
			b.setText(Integer.toString(i));
		}

		// 7 days/week * up to 6 rows
		for (int i = leadGap  + daysInMonth; i < 6 * 7; i++) {
			JButton b = labs[(i) / 7][(i) % 7];
			b.setText("");
			
		}
	}

	// isLeap() returns true if the given year is a Leap Year.

	public boolean isLeap(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		return false;
	}
	
	public JButton getAddEventBtn() {
		return this.addEventBtn;
	}
	
	public Today getToday() {
		return this.today;
	}

}
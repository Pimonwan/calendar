/* 5810405207 Pimonwan Sutmee */

package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CalendarView extends JPanel {
	protected int inYear, inMonth, inDay;   //interested Year, Month, Day
	protected JButton labs[][]; //keep button to be day on calendar
	protected int leadGap = 0;
	Calendar calendar = new GregorianCalendar();
	protected final int thisYear = calendar.get(calendar.YEAR);
	protected final int thisMonth = calendar.get(calendar.MONTH);
	private JButton b0, addEventBtn;
	private JComboBox monthChoice, yearChoice;
	private JPanel calPanel, btnPanel, panel;

	public final static int dom[] = {31, 28, 31, 30, /* jan feb mar apr */
			31, 30, 31, 31, /* may jun jul aug */
			30, 31, 30, 31 /* sep oct nov dec */
	};
	/**
	 * Construct a Cal, starting with today.
	 */
	public CalendarView() {
		calPanel = new JPanel(new GridLayout(2,1));
		btnPanel = new JPanel();
		panel = new JPanel(new GridLayout(2,1,3,3));
		inYear = calendar.get(calendar.YEAR);
		inMonth = calendar.get(calendar.MONTH);
		inDay = calendar.get(calendar.DAY_OF_MONTH);

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

		monthChoice.setSelectedItem(months[inMonth]);
		monthChoice.getAccessibleContext().setAccessibleName("Months");
		monthChoice.getAccessibleContext().setAccessibleDescription("Choose a month of the year");

		tp.add(yearChoice = new JComboBox());
		yearChoice.setEditable(true);
		for (int i = inYear - 10; i < inYear + 20; i++)
			yearChoice.addItem(Integer.toString(i));
		yearChoice.setSelectedItem(Integer.toString(inYear));
		
		
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
			}

		calPanel.add(tp);
		
		addEventBtn = new JButton("Add Event");
		btnPanel.add(addEventBtn);

		panel.setLayout(new GridLayout(2,1));
		panel.add(bp);
		panel.add(btnPanel);

		this.add(calPanel, BorderLayout.NORTH);
		this.add(panel);
		
	}

	public void recompute() {
		
		if (inMonth < 0 || inMonth > 11)
			throw new IllegalArgumentException("Month " + inMonth + " bad, must be 0-11");
		calendar = new GregorianCalendar(inYear, inMonth, inDay);

		// Compute how much to leave before the first.
		// getDay() returns 0 for Sunday, which is just right.
		leadGap = new GregorianCalendar(inYear, inMonth, 1).get(Calendar.DAY_OF_WEEK) - 1;

		int daysInMonth = dom[inMonth];
		if (isLeap(calendar.get(Calendar.YEAR)) && inMonth == 1)
			++daysInMonth;

		// Blank out the labels before 1st day of month
		for (int i = 0; i < leadGap; i++) {
			labs[0][i].setText("");
			labs[0][i].setBackground(Color.gray);
		}

		// Fill in numbers for the day of month.
		for (int i = 1; i <= daysInMonth; i++) {
			JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
			b.setText(Integer.toString(i));
			b.setBackground(Color.yellow);
		}

		// 7 days/week * up to 6 rows
		for (int i = leadGap  + daysInMonth; i < 6 * 7; i++) {
			JButton b = labs[(i) / 7][(i) % 7];
			b.setText("");
			b.setBackground(new Color(128,128,128));
		}

		//set color of today
		if (thisYear == inYear && inMonth == thisMonth) {
			int today = calendar.get(calendar.DAY_OF_MONTH);
			JButton b = labs[(leadGap + today - 1) / 7][(leadGap + today - 1) % 7];
			b.setBackground(Color.red);
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
	public JButton[][] getLabs() { return this.labs; }
	public int getInYear() { return this.inYear; }
	public void setInYear(int year) { this.inYear = year; }
	public int getInMonth() { return this.inMonth; }
	public JComboBox getMonthChoice() { return this.monthChoice; }
	public void setInMonth(int month) { this.inMonth = month; }
	public JComboBox getYearChoice() { return  this.yearChoice; }
	public int getLeadGap() { return this.leadGap; }
}
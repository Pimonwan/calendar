/* 5810405207 Pimonwan Sutmee */

package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEventPage extends JPanel{
	private Calendar cal;
	
	private JPanel panel, topicPanel, datePanel, timePanel, placePanel, addBtnPanel, canBtnPanel, btnPanel;
	private JLabel titleText, topicText, dateOfEventText, timeText, toTimeText, placeText;
	
	private JTextField topicField, placeField, startTimeField, endTimeField;
	
	private JComboBox daysChoice, monthChoice, yearChoice;
	
	private JButton addBtn, cancleBtn;
	
	private String[] days = {"1","2","3","4","5","6","7","8","9","10","11"
			,"12","13","14","15","16","17","18","19","20","21","22"
			,"23","24","25","26","27","28","29","30","31"};
	private String[] months = { "January", "February", "March", "April", "May", "June",
		      "July", "August", "September", "October", "November", "December" }; 
	public AddEventPage() {
		this.cal = new GregorianCalendar();
		
		this.panel = new JPanel();
		this.topicPanel = new JPanel();
		this.datePanel = new JPanel();
		this.timePanel = new JPanel();
		this.placePanel = new JPanel();
		this.addBtnPanel = new JPanel();
		this.canBtnPanel = new JPanel();
		this.btnPanel = new JPanel();
		
		
		this.titleText = new JLabel("*****  Add Event  *****");
		
		this.topicText = new JLabel("Topic : ");
		this.topicField = new JTextField(20);
		
		this.dateOfEventText = new JLabel("Date : ");
		this.daysChoice = new JComboBox(days);
		this.daysChoice.setSelectedItem(cal.get(Calendar.DAY_OF_MONTH)+"");
		
		this.monthChoice = new JComboBox(months);
		this.monthChoice.setSelectedItem(months[cal.get(Calendar.MONTH)]);
		
		this.yearChoice = new JComboBox();
		for(int i = cal.get(Calendar.YEAR)-10 ; i <= cal.get(Calendar.YEAR)+10 ;i = i + 1) {
			this.yearChoice.addItem(Integer.toString(i));
		}
		this.yearChoice.setSelectedItem(cal.get(Calendar.YEAR)+"");
		
		this.timeText = new JLabel("Time (hh:mm) : ");
		this.toTimeText = new JLabel("  to  ");

		this.startTimeField = new JTextField(7);
		this.endTimeField = new JTextField(7);
		
				
		this.placeText = new JLabel("Place : ");
		this.placeField = new JTextField(20);
		
		this.setAddBtn(new JButton("Add"));
		getAddBtn().setBackground(Color.green);
		this.setCancleBtn(new JButton("Cancle"));
		getCancleBtn().setBackground(Color.red);
		
	}
	
	public void render() {
		panel.add(titleText);
		
		topicPanel.add(topicText);
		topicPanel.add(topicField);
		
		datePanel.add(dateOfEventText);
		datePanel.add(daysChoice);
		datePanel.add(monthChoice);
		datePanel.add(yearChoice);
		
		timePanel.add(timeText);
		timePanel.add(startTimeField);
		timePanel.add(toTimeText);
		timePanel.add(endTimeField);
		
		placePanel.add(placeText);
		placePanel.add(placeField);
		
		btnPanel.setLayout(new GridLayout(1,2,0,0));
		addBtnPanel.add(getAddBtn());
		canBtnPanel.add(getCancleBtn());
		
		btnPanel.add(addBtnPanel);
		btnPanel.add(canBtnPanel);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new GridLayout(6,1,10,10));
		this.add(panel);
		this.add(topicPanel);
		this.add(datePanel);
		this.add(timePanel);
		this.add(placePanel);
		this.add(btnPanel);

	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	public JButton getCancleBtn() {
		return cancleBtn;
	}

	public void setCancleBtn(JButton cancleBtn) {
		this.cancleBtn = cancleBtn;
	}
	
	public String getTopicField() {
		return this.topicField.getText();
	}
	
	public void setTopicField(String s) {
		this.topicField.setText(s);
	}
	
	public String getPlaceField() {
		return this.placeField.getText();
	}
	
	public void setPlaceField(String s) {
		this.placeField.setText(s);
	}

	public int getDaysChoice() {
		String s = (String) this.daysChoice.getSelectedItem();
		return Integer.parseInt(s);
	}

	public void setDaysChoice() {
		this.daysChoice.setSelectedItem(cal.get(Calendar.DAY_OF_MONTH)+"");
	}

	public int getMonthChoice() {
		return this.monthChoice.getSelectedIndex()+1;
		
	}

	public void setMonthChoice() {
		this.monthChoice.setSelectedItem(months[cal.get(Calendar.MONTH)]);
	}

	public int getYearChoice() {
		String s = (String) this.yearChoice.getSelectedItem();
		return Integer.parseInt(s);
	}

	public void setYearChoice() {
		this.yearChoice.setSelectedItem(cal.get(Calendar.YEAR)+"");
	}

	public String getStartTimeField() {
		return startTimeField.getText();
	}

	public void setStartTimeField(String s) {
		this.startTimeField.setText(s);;
	}

	public String getEndTimeField() {
		return endTimeField.getText();
	}

	public void setEndTimeField(String s) {
		this.endTimeField.setText(s);;
	}

}


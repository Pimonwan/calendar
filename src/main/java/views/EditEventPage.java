package views;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EditEventPage extends JPanel{
    private Calendar cal;
    private JPanel panel, topicPanel, datePanel, timePanel, placePanel, addBtnPanel, canBtnPanel, btnPanel;
    private JLabel titleText, topicText, dateOfEventText, timeText, toTimeText, placeText;
    private JTextField topicField, placeField;
    private JComboBox startHourChoice, endHourChoice;
    private JComboBox daysChoice, monthChoice, yearChoice;
    private JButton editBtn, cancleBtn;
    private String[] days = {"1","2","3","4","5","6","7","8","9","10","11"
            ,"12","13","14","15","16","17","18","19","20","21","22"
            ,"23","24","25","26","27","28","29","30","31"};
    private String[] months = { "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };

    private String[] hours = {"1.0","2.0","3.0","4.0","5.0","6.0","7.0","8.0","9.0","10.0","11.0"
            ,"12.0","13.0","14.0","15.0","16.0","17.0","18.0","19.0","20.0","21.0","22.0"
            ,"23.0","24.0"};

    public EditEventPage() {
        this.cal = new GregorianCalendar();

        this.panel = new JPanel();
        this.topicPanel = new JPanel();
        this.datePanel = new JPanel();
        this.timePanel = new JPanel();
        this.placePanel = new JPanel();
        this.addBtnPanel = new JPanel();
        this.canBtnPanel = new JPanel();
        this.btnPanel = new JPanel();

        this.titleText = new JLabel("*****  Edit Event  *****");
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

        this.startHourChoice = new JComboBox(hours);
        this.startHourChoice.setSelectedItem("9.0");

        this.endHourChoice = new JComboBox(hours);
        this.endHourChoice.setSelectedItem("10.0");

        this.placeText = new JLabel("Place : ");
        this.placeField = new JTextField(20);

        this.editBtn = new JButton("Edit");
        getEditBtn().setBackground(Color.green);
        this.cancleBtn = new JButton("Cancle");
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
        timePanel.add(startHourChoice);
        timePanel.add(toTimeText);
        timePanel.add(endHourChoice);

        placePanel.add(placeText);
        placePanel.add(placeField);

        btnPanel.setLayout(new GridLayout(1,2));
        addBtnPanel.add(getEditBtn());
        canBtnPanel.add(getCancleBtn());

        btnPanel.add(addBtnPanel);
        btnPanel.add(canBtnPanel);

        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new GridLayout(6,1));
        this.setPreferredSize(new Dimension(500,200));
        this.add(panel);
        this.add(topicPanel);
        this.add(datePanel);
        this.add(timePanel);
        this.add(placePanel);
        this.add(btnPanel);

    }

    public JButton getEditBtn() {
        return editBtn;
    }
    public JButton getCancleBtn() {
        return cancleBtn;
    }
    public String getTopicField() {
        return this.topicField.getText();
    }
    public String getPlaceField() {
        return this.placeField.getText();
    }
    public int getDaysChoice() {
        String s = (String) this.daysChoice.getSelectedItem();
        return Integer.parseInt(s);
    }
    public int getMonthChoice() { return this.monthChoice.getSelectedIndex()+1;	}
    public int getYearChoice() {
        String s = (String) this.yearChoice.getSelectedItem();
        return Integer.parseInt(s);
    }
    public int getStartTime() { return this.startHourChoice.getSelectedIndex(); }
    public int getEndTime() { return  this.endHourChoice.getSelectedIndex(); }

    public void clear(){
        this.topicField.setText("");
        this.placeField.setText("");
        this.startHourChoice.setSelectedItem("9.0");
        this.endHourChoice.setSelectedItem("10.0");
        this.daysChoice.setSelectedItem(cal.get(Calendar.DAY_OF_MONTH)+"");
        this.monthChoice.setSelectedItem(months[cal.get(Calendar.MONTH)]);
        this.yearChoice.setSelectedItem(cal.get(Calendar.YEAR)+"");
    }

    public void setForUpdate(String topic, String day, String month, String year, String startTime, String endTime, String place){
        this.topicField.setText(topic);
        this.placeField.setText(day);
        this.startHourChoice.setSelectedItem(startTime);
        this.endHourChoice.setSelectedItem(endTime);
        this.daysChoice.setSelectedItem(day);
        this.monthChoice.setSelectedItem(month);
        this.yearChoice.setSelectedItem(year);
        this.placeField.setText(place);
    }

}

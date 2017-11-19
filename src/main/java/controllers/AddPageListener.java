/* 5810405207 Pimonwan Sutmee */
/* this class control about all buttons in add page */
package controllers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Database;
import views.MainView;
import javax.swing.*;

public class AddPageListener implements ActionListener{
	private MainView view;
	private Database database;
	
	public AddPageListener(MainView view, Database database) {
		this.view = view;
		this.database = database;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		//if "Add" button was clicked
		if(command.equals("Add")) {
			String topic = view.getAddEventPage().getTopicField();
			int day = view.getAddEventPage().getDaysChoice();
			int month = view.getAddEventPage().getMonthChoice();
			int year = view.getAddEventPage().getYearChoice();
			double startTime = view.getAddEventPage().getStartTime();
			double endTime = view.getAddEventPage().getEndTime();
			if(endTime < startTime){
				JOptionPane.showMessageDialog(view.getFrame(),
						"Wrong input time.",
						"Inane error",
						JOptionPane.ERROR_MESSAGE);
			}else {
				String place = view.getAddEventPage().getPlaceField();

				database.insert(topic, day, month, year, startTime, endTime, place);

				if (view.getCalendarView().getInMonth() + 1 == month && view.getCalendarView().getInYear() == year) {
					JButton b = view.getCalendarView().getLab(day);
					b.setBackground(new Color(0, 153, 76));
				}

				view.getFrame().remove(view.getAddEventPage());
				view.getFrame().pack();
			}

		}
		//if "Cancle" button was clicked
		else if (command.equals("Cancle")){
			view.getFrame().remove(view.getAddEventPage());
			view.getFrame().remove(view.getShowEventOfDay());
			view.getFrame().pack();
		}
	}
}
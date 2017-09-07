/* 5810405207 Pimonwan Sutmee */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.EventDatabase;
import views.MainView;

public class AddEventListener implements ActionListener{
	private MainView view;
	private EventDatabase eventDB;
	
	public AddEventListener(MainView view) {
		this.view = view;
		eventDB = new EventDatabase();
	}
	
	public void actionPerformed(ActionEvent e) {
		String topicEvent = view.getAddEventPage().getTopicField();
		int dayEvent = view.getAddEventPage().getDaysChoice();
		int monthEvent = view.getAddEventPage().getMonthChoice();
		int yearEvent = view.getAddEventPage().getYearChoice();
		String startTimeEvent = view.getAddEventPage().getStartTimeField();
		String endTimeEvent = view.getAddEventPage().getEndTimeField();
		String placeEvent = view.getAddEventPage().getPlaceField();
		
		eventDB.insertDB(topicEvent, dayEvent, monthEvent, yearEvent, startTimeEvent, endTimeEvent, placeEvent);
		
		view.getAddEventPage().setTopicField("");
		view.getAddEventPage().setPlaceField("");
		view.getAddEventPage().setStartTimeField("");
		view.getAddEventPage().setEndTimeField("");
		view.getAddEventPage().setDaysChoice();
		view.getAddEventPage().setMonthChoice();
		view.getAddEventPage().setYearChoice();
		
		view.getFrame().remove(view.getAddEventPage());
		view.getFrame().add(view.getCalendarView());
		view.getFrame().setSize(400, 300);
		
	}

}

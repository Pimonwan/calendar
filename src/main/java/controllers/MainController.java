/* 5810405207 Pimonwan Sutmee */

package controllers;

import models.GetEventDatabase;
import views.MainView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainController{
	private MainView view;
	private GetEventDatabase eventDB;
	
	public void startApplication() {
		view = new MainView();
		eventDB = new GetEventDatabase();
		view.initFrame();
		view.getCalendarView().getAddEventBtn().addActionListener(new EventListener(view));

		//add action to each day button on calendar
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				view.getCalendarView().getLabs()[i][j].addActionListener(new DayButtonListener(view, view.getCalendarView()));
			}
		}

		view.getCalendarView().getYearChoice().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int i = view.getCalendarView().getYearChoice().getSelectedIndex();
				if (i >= 0) {
					int year = Integer.parseInt(view.getCalendarView().getYearChoice().getSelectedItem().toString());
					view.getCalendarView().setInYear(year);
					view.getCalendarView().recompute();
					setEventDayOnCal();
				}
			}
		});

		view.getCalendarView().getMonthChoice().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = view.getCalendarView().getMonthChoice().getSelectedIndex();
				if(i >= 0){
					view.getCalendarView().setInMonth(i);
					view.getCalendarView().recompute();
					setEventDayOnCal();
				}
			}
		});

		setEventDayOnCal();
		view.getAddEventPage().getCancleBtn().addActionListener(new AddPageListener(view));
		view.getAddEventPage().getAddBtn().addActionListener(new AddPageListener(view));

	}

	//method to set day that have schedule
	public void setEventDayOnCal(){
		int month = view.getCalendarView().getInMonth() + 1 ;
		int year = view.getCalendarView().getInYear();
		JButton[][] labs = view.getCalendarView().getLabs();
		List<String> daysListTest = this.eventDB.getEventForMonth(month, year);
		for(String s : daysListTest){
			int leadGap = view.getCalendarView().getLeadGap();
			int day = Integer.parseInt(s);
			JButton b = labs[(leadGap + day - 1) / 7][(leadGap + day - 1) % 7];
			//(0,153,76) = green
			b.setBackground(new Color(0,153,76));
		}
	}
}


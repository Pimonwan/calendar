/* 5810405207 Pimonwan Sutmee */

package controllers;

import models.Database;
import views.MainView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainController{
	private MainView view;
	private Database database;
	
	public void startApplication() {
		view = new MainView();
		database = new Database();

		//add action to each day button on calendar
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				view.getCalendarView().getLabs()[i][j].addActionListener(new DayButtonListener(view, database));
			}
		}
		setEventDayOnCal();

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


		view.getCalendarView().getAddEventBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				view.getAddEventPage().clear();
				view.getFrame().remove(view.getShowEventOfDay());
				view.getFrame().add(view.getAddEventPage(), BorderLayout.EAST);
				view.getFrame().pack();
			}
		});

		view.getAddEventPage().getCancleBtn().addActionListener(new AddPageListener(view, database));
		view.getAddEventPage().getButton().addActionListener(new AddPageListener(view, database));
		view.getEditTable().getButton().addActionListener(new EditTableListener(view, database));
		view.getEditTable().getCancleButt().addActionListener(new EditTableListener(view, database));
		view.getShowEventOfDay().getEditButt().addActionListener(new ShowEventPageListener(view));
		view.getShowEventOfDay().getDeleteButt().addActionListener(new ShowEventPageListener(view));
		view.getDeleteTable().getCancleButt().addActionListener(new DeletePageListener(view, database));
		view.getDeleteTable().getButton().addActionListener(new DeletePageListener(view, database));
		view.initFrame();
	}

	//method to set day that have schedule
	public void setEventDayOnCal(){
		int month = view.getCalendarView().getInMonth() + 1 ;
		int year = view.getCalendarView().getInYear();
		List<String> daysListTest = this.database.getEventForMonth(month,year);
		for(String s : daysListTest){
			int day = Integer.parseInt(s);
			JButton b = view.getCalendarView().getLab(day);
			b.setBackground(new Color(0,153,76));  //(0,153,76) = green
		}
	}
}
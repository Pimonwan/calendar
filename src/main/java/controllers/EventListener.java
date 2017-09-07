/* 5810405207 Pimonwan Sutmee */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainView;

public class EventListener implements ActionListener{
	private MainView view;
	
	public EventListener(MainView view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		view.getFrame().remove(view.getCalendarView());
		view.getFrame().add(view.getAddEventPage());
		view.getFrame().pack();
			
	}

}
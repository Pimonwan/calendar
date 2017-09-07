/* 5810405207 Pimonwan Sutmee */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainView;

public class CancleAddEventListener implements ActionListener{
	private MainView view;
	
	public CancleAddEventListener(MainView view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		view.getFrame().remove(view.getAddEventPage());
		view.getFrame().add(view.getCalendarView());
		view.getFrame().setSize(400, 300);
	}

}
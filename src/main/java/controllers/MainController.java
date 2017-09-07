/* 5810405207 Pimonwan Sutmee */

package controllers;

import views.MainView;

public class MainController{
	private MainView view;
	
	public void startApplication() {
		view = new MainView();
		view.initFrame();
		
		view.getCalendarView().getAddEventBtn().addActionListener(new EventListener(view));
		view.getAddEventPage().getCancleBtn().addActionListener(new CancleAddEventListener(view));
		view.getAddEventPage().getAddBtn().addActionListener(new AddEventListener(view));
		
	}
}


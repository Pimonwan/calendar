/* 5810405207 Pimonwan Sutmee */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.GetEventDatabase;
import models.InsertDB;
import views.MainView;

public class AddPageListener implements ActionListener{
	private MainView view;
	private GetEventDatabase eventDB;
	private InsertDB insertDB;
	
	public AddPageListener(MainView view) {
		this.view = view;
		eventDB = new GetEventDatabase();
		insertDB = new InsertDB();
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		//if "Add" button was clicked
		if(command.equals("Add")) {
			System.out.println("ADD");
			String topic = view.getAddEventPage().getTopicField();
			int day = view.getAddEventPage().getDaysChoice();
			int month = view.getAddEventPage().getMonthChoice();
			int year = view.getAddEventPage().getYearChoice();
			String startTime = view.getAddEventPage().getStartTimeField();
			String endTime = view.getAddEventPage().getEndTimeField();
			String place = view.getAddEventPage().getPlaceField();

			insertDB.insertDB(topic,day,month,year,startTime,endTime,place);
			view.getFrame().remove(view.getAddEventPage());
			view.getFrame().pack();

		}
		//if "Cancle" button was clicked
		else if (command.equals("Cancle")){
			view.getFrame().remove(view.getAddEventPage());
			view.getFrame().remove(view.getShowEventOfDay());
			view.getFrame().pack();
		}
		
	}

}

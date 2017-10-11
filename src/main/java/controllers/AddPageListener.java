/* 5810405207 Pimonwan Sutmee */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.beans.property.adapter.JavaBeanBooleanProperty;
import models.GetEventDatabase;
import views.MainView;

import javax.swing.*;

public class AddPageListener implements ActionListener{
	private MainView view;
	private GetEventDatabase eventDB;
	
	public AddPageListener(MainView view) {
		this.view = view;
		eventDB = new GetEventDatabase();
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		//if "Add" button was clicked
		if(command.equals("Add")) {
			System.out.println("ADD");
		}
		//if "Cancle" button was clicked
		else if (command.equals("Cancle")){
			view.getFrame().remove(view.getAddEventPage());
			view.getFrame().remove(view.getShowEventOfDay());
			view.getFrame().pack();
		}
		
	}

}

/* 5810405207 Pimonwan Sutmee */
package controllers;

import models.Database;
import views.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPageListener implements ActionListener{
    private MainView view;
    private Database database;
    private int id;

	public EditPageListener(MainView view, Database database, int id) {
        this.view = view;
        this.database = database;
        this.id = id;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Edit")) {
            String topic = view.getEditPage().getTopicField();
            int day = view.getEditPage().getDaysChoice();
            int month = view.getEditPage().getMonthChoice();
            int year = view.getEditPage().getYearChoice();
            double startTime = view.getEditPage().getStartTime();
            double endTime = view.getEditPage().getEndTime();
            String place = view.getEditPage().getPlaceField();

            database.update(topic, day, month, year, startTime, endTime, place, id);

            view.getFrame().remove(view.getEditPage());
            view.getFrame().add(view.getPanel());
            view.getFrame().pack();
        }

		else if (command.equals("Cancle")) {
            view.getFrame().remove(view.getEditPage());
            view.getFrame().add(view.getPanel());
            view.getFrame().pack();
        }
    }

}

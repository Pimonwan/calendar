/* 5810405207 Pimonwan Sutmee */
package controllers;

import models.GetEventDatabase;
import views.CalendarView;
import views.MainView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DayButtonListener implements ActionListener {

    private MainView view;
    private CalendarView calView;
    private GetEventDatabase eventDB;

    public DayButtonListener(MainView view, CalendarView calView) {
        this.view = view;
        this.calView = calView;
        this.eventDB = new GetEventDatabase();
    }

    public void actionPerformed(ActionEvent e) {
        String num = e.getActionCommand();
        JButton btn = ((JButton) e.getSource());
        if (!num.equals("")) {
            int day = Integer.parseInt(num);
            if(btn.getBackground().equals(new Color(0,153,76))){
                view.getShowEventOfDay().getModel().setRowCount(0); // delete all schedules' s previous day
                view.getShowEventOfDay().updateTable(eventDB.getEventsForDate(day,calView.getInMonth() + 1,calView.getInYear()));
                eventDB.clearEvents(); //remove schedule in list schedule in DB

                view.getFrame().add(view.getShowEventOfDay(), BorderLayout.EAST);
                view.getFrame().pack();
            }
            else if(btn.getBackground().equals(Color.yellow)){
                view.getShowEventOfDay().getModel().setRowCount(0); // delete all schedules' s previous day
                eventDB.clearEvents(); //remove schedule in list schedule in DB

                JOptionPane.showMessageDialog(view.getFrame() ,"Nothing to do today.");
            }
        }
    }
}

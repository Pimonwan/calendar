/* 5810405207 Pimonwan Sutmee */
package controllers;

import models.Database;
import views.CalendarView;
import views.MainView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DayButtonListener implements ActionListener {
    private MainView view;
    private CalendarView calView;
    private Database database;

    public DayButtonListener(MainView view, Database database) {
        this.view = view;
        this.calView = view.getCalendarView();
        this.database = database;
    }

    public void actionPerformed(ActionEvent e) {
        String num = e.getActionCommand();
        JButton btn = ((JButton) e.getSource());
            if (!num.equals("")) {
                int day = Integer.parseInt(num);
                calView.setInDay(day);
                if(btn.getBackground().equals(new Color(0,153,76))){
                    database.clearEvents(); //remove schedule in list schedule in DB
                    view.getShowEventOfDay().getModel().setRowCount(0); // delete all schedules' s previous day
                    view.getShowEventOfDay().updateTable(database.getEventsForDate(day,calView.getInMonth() + 1,calView.getInYear()));

                    view.getFrame().add(view.getShowEventOfDay(), BorderLayout.EAST);
                    view.getFrame().pack();
                }
                else if(btn.getBackground().equals(new Color(255,255,51))){
                    view.getShowEventOfDay().getModel().setRowCount(0); // delete all schedules' s previous day
                    database.clearEvents(); //remove schedule in list schedule in DB

                    JOptionPane.showMessageDialog(view.getFrame() ,"Nothing to do today.");
                }
        }
    }
}

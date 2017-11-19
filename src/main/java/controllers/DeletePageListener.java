package controllers;

import models.Database;
import views.MainView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePageListener implements ActionListener {
    private MainView view;
    private Database database;

    public DeletePageListener(MainView view, Database database){
        this.view = view;
        this.database = database;
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Delete")){
            boolean checkSelect = false;
            DefaultTableModel model = view.getDeleteEventView().getModel();

            for(int i = 0 ; i < model.getRowCount() ; i++){
                checkSelect = Boolean.valueOf(model.getValueAt(i,0).toString());
                if(checkSelect){
                    database.delete(model.getValueAt(i,1),view.getCalendarView().getInDay(),view.getCalendarView().getInMonth() + 1,
                            view.getCalendarView().getInYear(), model.getValueAt(i,3), model.getValueAt(i,4),
                            model.getValueAt(i,5));

                    JButton b = view.getCalendarView().getLab(view.getCalendarView().getInDay());
                    b.setBackground(new Color(255,255,51));
                }
            }
            this.turnBack();
        }
        else if(command.equals("Cancle")){
            this.turnBack();
        }
    }

    public void turnBack(){
        view.getFrame().remove(view.getDeleteEventView());
        view.getFrame().add(view.getPanel());
        view.getFrame().pack();
    }
}
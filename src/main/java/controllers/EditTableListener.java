/* 5810405207 Pimonwan Sutmee */
package controllers;

import models.Database;
import views.MainView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTableListener implements ActionListener {
    private MainView view;
    private Database database;

    public EditTableListener(MainView view, Database database) {
        this.database = database;
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Edit")) {
            boolean checkSelect = false;
            DefaultTableModel model = view.getEditTable().getModel();

            int count = 0;
            int getIndex = -1;
            for (int i = 0; i < model.getRowCount(); i++) {
                checkSelect = Boolean.valueOf(model.getValueAt(i, 0).toString());
                if(checkSelect){
                    count++;
                    getIndex = i ;
                }

            }

            if(count > 1){
                JOptionPane.showMessageDialog(view.getFrame(),
                        "You can select just 1 choice",
                        "Inane warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if(count == 1){
                String topic = model.getValueAt(getIndex,1).toString();
                String[] date = model.getValueAt(getIndex, 2).toString().split("/");
                String day = date[0];
                String month = date[1];
                String year = date[2];
                String startTime = model.getValueAt(getIndex,3).toString();
                String endTime = model.getValueAt(getIndex,4).toString();
                String place = model.getValueAt(getIndex,5).toString();
                view.getEditPage().setForUpdate(topic,day,month,year,startTime,endTime,place);

                int id = database.getId(topic,day,month,year,startTime,endTime,place);
                view.getEditPage().getButton().addActionListener(new EditPageListener(view,database,id));
                view.getEditPage().getCancleBtn().addActionListener(new EditPageListener(view,database,id));

                view.getFrame().remove(view.getEditTable());
                view.getFrame().add(view.getEditPage());
                view.getFrame().setSize(500,400);

            }


        } else if (command.equals("Cancle")) {
            this.turnBack();
        }
    }

    public void turnBack() {
        view.getFrame().remove(view.getEditTable());
        view.getFrame().add(view.getPanel());
        view.getFrame().pack();
    }
}

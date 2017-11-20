/* 5810405207 Pimonwan Sutmee */
package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableView extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    private ShowEventOfDay showEventOfDay;
    private JButton button, cancleButt;

    public TableView(){
        scrollPane = new JScrollPane();
        scrollPane.setBounds(33, 41, 494, 90);
        button = new JButton("");
        cancleButt = new JButton("Cancle");
    }

    public void drawTable(ShowEventOfDay showEventOfDay){
        model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    case 6:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(model);

        model.addColumn("Select");
        model.addColumn("Topic");
        model.addColumn("Date");
        model.addColumn("Start Time");
        model.addColumn("End Time");
        model.addColumn("Place");

        DefaultTableModel model2 = showEventOfDay.getModel();
        for(int i = 0 ; i < showEventOfDay.getModel().getRowCount() ; i++){
            model.addRow(new Object[0]);
            model.setValueAt(false, i, 0);
            model.setValueAt(model2.getValueAt(i,0), i, 1);
            model.setValueAt(model2.getValueAt(i,1), i, 2);
            model.setValueAt(model2.getValueAt(i,2), i, 3);
            model.setValueAt(model2.getValueAt(i,3), i, 4);
            model.setValueAt(model2.getValueAt(i,4), i, 5);
        }
    }
    public void render(){
        this.add(this.scrollPane);
        this.add(button);
        this.add(cancleButt);
    }

    public JButton getCancleButt() { return cancleButt; }
    public JButton getButton() { return button; }
    public void setButton(String s) { this.button.setText(s); }
    public JTable getTable() { return table; }
    public DefaultTableModel getModel() { return model; }
}

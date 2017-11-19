package views;

import controllers.AddPageListener;
import controllers.EditListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEventView extends JPanel {
    //    private JScrollPane pane;
//    private JTable table;
//    private DefaultTableModel model;
//    private JButton cancleBtn;
//
//    public EditEventView(){
//        cancleBtn = new JButton("Cancle");
//        table = new JTable();
//        pane = new JScrollPane();
//    }
//
//    public void drawTable(ShowEventOfDay showEventOfDay){
//        DefaultTableModel modelL = showEventOfDay.getModel();
//        model = new DefaultTableModel();
//        model.addColumn("Topic");
//        model.addColumn("Date");
//        model.addColumn("Start Time");
//        model.addColumn("End Time");
//        model.addColumn("Place");
//        model.addColumn("Select");
//        for(int i = 0 ; i < modelL.getRowCount() ; i++){
//            model.addRow(new Object[0]);
//            model.setValueAt(false, i, 0);
//            model.setValueAt(modelL.getValueAt(i,0), i, 0);
//            model.setValueAt(modelL.getValueAt(i,1), i, 1);
//            model.setValueAt(modelL.getValueAt(i,2), i, 2);
//            model.setValueAt(modelL.getValueAt(i,3), i, 3);
//            model.setValueAt(modelL.getValueAt(i,4), i, 4);
//            model.setValueAt("Edit",i,5);
//        }
//        table.setModel(model);
//
//        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
//        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));
//        pane.setViewportView(table);
//    }
//
//    public JTable getTable(){ return this.table; }
//
//    public void render(){
//        this.add(this.pane);
//        this.add(this.cancleBtn);
//    }
//
//    public JButton getCancleBtn(){ return this.cancleBtn; }
//
//}
//
//class ButtonRenderer extends JButton implements TableCellRenderer{
//    public ButtonRenderer(){
//        setOpaque(true);
//    }
//
//
//    public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col){
//        setText((obj==null) ? "":obj.toString());
//        return this;
//    }
//}
//
//class ButtonEditor extends DefaultCellEditor{
//    protected JButton btn;
//    private String lbl;
//    private Boolean clicked;
//    private MainView frame;
//
//    public ButtonEditor(JTextField txt){
//        super(txt);
//        frame = new MainView();
//        btn = new JButton();
//        btn.addActionListener(new EditListener(frame));
//        btn.setOpaque(true);
////        btn.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                System.out.println("11click");
////                frame.getFrame().add(frame.getPanel());
////                //fireEditingStopped();
////            }
////        });
//    }
//
//    @Override
//    public Component getTableCellEditorComponent(JTable table, Object obj, boolean isSelected, int row, int column) {
//        lbl=(obj==null) ? "":obj.toString();
//        btn.setText(lbl);
//        clicked = true;
//        return btn;
//    }
//
//    @Override
//    public Object getCellEditorValue(){
//        if(clicked) {
//            frame.getFrame().add(frame.getPanel());
//        }
//
//        clicked = false;
//        return new String(lbl);
//    }
//
//    @Override
//    public boolean stopCellEditing(){
//        clicked = false;
//        return super.stopCellEditing();
//    }
//
//    @Override
//    protected void fireEditingStopped(){
//        super.fireEditingStopped();
//    }
//}
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    private ShowEventOfDay showEventOfDay;
    private JButton editButt, cancleButt;

    public EditEventView() {
        scrollPane = new JScrollPane();
        scrollPane.setBounds(33, 41, 494, 90);
        editButt = new JButton("Edit");
        cancleButt = new JButton("Cancle");
    }

    public void drawTable(ShowEventOfDay showEventOfDay) {
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
        this.add(editButt);
        this.add(cancleButt);
    }

    public JButton getCancleButt() { return cancleButt; }
    public JButton getEditButt() { return editButt; }
    public JTable getTable() { return table; }
    public DefaultTableModel getModel() { return model; }
}
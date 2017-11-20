/* 5810405207 Pimonwan Sutmee */

package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {
	private JFrame frame;
	private CalendarView calendarView;
	private AddEventPage addEventPage;
	private ShowEventOfDay eventView;
	private DeleteTable deleteTable;
	private EditTable editTable;
	private EditEventPage editPage;
	private JPanel panel;
	
	public MainView() {
		this.frame = new JFrame();
		this.calendarView = new CalendarView();
		
		this.addEventPage = new AddEventPage();
		addEventPage.render();

		this.eventView = new ShowEventOfDay();
		eventView.render();
		
		this.panel = new JPanel();
		panel.add(calendarView,new GridLayout(3,3));

		this.deleteTable = new DeleteTable();

		this.editTable = new EditTable();

		this.editPage = new EditEventPage();
		editPage.render();
	}
	
	public void initFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();

	}
	
	public JFrame getFrame(){
		return frame;
	}
	public CalendarView getCalendarView() {
		return calendarView;
	}
	public AddEventPage getAddEventPage() {
		return addEventPage;
	}
	public ShowEventOfDay getShowEventOfDay() {
		return this.eventView;
	}
	public JPanel getPanel() {
		return this.panel;
	}
	public DeleteTable getDeleteTable() { return this.deleteTable; }
	public EditTable getEditTable() { return this.editTable; }
	public EditEventPage getEditPage() { return this.editPage;	}
}

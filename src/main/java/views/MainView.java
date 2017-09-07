/* 5810405207 Pimonwan Sutmee */

package views;

import javax.swing.JFrame;

public class MainView {
	private JFrame frame;
	private CalendarView calendarView;
	private AddEventPage addEventPage;
	
	public MainView() {
		this.frame = new JFrame();
		this.calendarView = new CalendarView();
		
		this.addEventPage = new AddEventPage();
		addEventPage.render();
	}
	
	public void initFrame() {
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(calendarView);
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

}

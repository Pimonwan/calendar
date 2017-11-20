/* 5810405207 Pimonwan Sutmee */
package views;
public class EditEventPage extends InputView{
    public EditEventPage(){
        super();
        this.setButton("Edit");
    }

    public void setForUpdate(String topic, String day, String month, String year, String startTime, String endTime, String place){
        this.topicField.setText(topic);
        this.placeField.setText(day);
        this.startHourChoice.setSelectedItem(startTime);
        this.endHourChoice.setSelectedItem(endTime);
        this.daysChoice.setSelectedItem(day);
        this.monthChoice.setSelectedItem(month);
        this.yearChoice.setSelectedItem(year);
        this.placeField.setText(place);
    }

}

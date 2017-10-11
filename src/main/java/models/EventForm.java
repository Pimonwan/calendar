/* 5810405207 Pimonwan Sutmee */
package models;

public class EventForm {
    private String topic;
    private String date;
    private String startTime;
    private String endTime;
    private String place;

    public EventForm(String topic, String date, String startTime, String endTime, String place){
        this.topic = topic;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
    }
    public String getTopic(){ return this.topic; }
    public String getDate(){ return this.date; }
    public String getStartTime(){ return this.startTime; }
    public String getEndTime(){ return this.endTime; }
    public String getPlace(){ return this.place; }

    public void setTopic(String topic){ this.topic = topic; }
    public void setDate(String date){ this.date = date; }
    public void setStartTime(String startTime){ this.startTime = startTime; }
    public void setEndTime(String endTime){ this.endTime = endTime; }
    public void setPlace(String place){ this.place = place; }
}

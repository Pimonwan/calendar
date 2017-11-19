/* 5810405207 Pimonwan Sutmee */
package models;

public class EventForm {
    private String topic;
    private String date;
    private double startTime;
    private double endTime;
    private String place;

    public EventForm(String topic, String date, double startTime, double endTime, String place){
        this.topic = topic;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
    }
    public String getTopic(){ return this.topic; }
    public String getDate(){ return this.date; }
    public double getStartTime(){ return this.startTime; }
    public double getEndTime(){ return this.endTime; }
    public String getPlace(){ return this.place; }

    public void setTopic(String topic){ this.topic = topic; }
    public void setDate(String date){ this.date = date; }
    public void setStartTime(double startTime){ this.startTime = startTime; }
    public void setEndTime(double endTime){ this.endTime = endTime; }
    public void setPlace(String place){ this.place = place; }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 2ndyrGroupC
 */
public class Course {

    private String title;
    private String schedule;
    private int units;

    public Course() {
    }

    public Course(String title, String schedule, int units) {
        this.title = title;
        this.schedule = schedule;
        this.units = units;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the schedule
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * @return the units
     */
    public int getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", schedule=" + schedule + ", units=" + units + '}';
    }

}

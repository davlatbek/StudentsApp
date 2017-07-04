package innopolis.studentsapp.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by davlet on 6/8/17.
 */
public class Lesson extends Entity implements Serializable {
    private Long id;
    private String name;
    private Date date;
    private Date startTime;
    private Date endTime;
    private String subject;
    private String description;
    private String lector;

    public Lesson(Long id, String name, Date date, Date startTime, Date endTime, String subject, String description, String lector) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subject = subject;
        this.description = description;
        this.lector = lector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }
}

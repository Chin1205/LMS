package biz.global77.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "certificates")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "completion_date")
    private String completionDate;

    public Certificate() {}

    public Certificate(String userName, String courseTitle, String completionDate) {
        this.userName = userName;
        this.courseTitle = courseTitle;
        this.completionDate = completionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }
}

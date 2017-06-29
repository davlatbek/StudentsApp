package innopolis.studentsapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davlet on 6/8/17.
 */
public class Group extends Entity implements Serializable, Parcelable {
    private Long Id;
    private String name;
    private Integer courseNumber;
    private List<Student> studentList;
    private transient Semester semester;

    public Group(Long Id, String name, Integer courseNumber, Semester semester) {
        this.Id = Id;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.studentList = new ArrayList<>();
    }

    public Group(Long id, String name, Integer courseNumber) {
        Id = id;
        this.name = name;
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.Id);
        dest.writeString(this.name);
        dest.writeValue(this.courseNumber);
        dest.writeList(this.studentList);
    }

    protected Group(Parcel in) {
        this.Id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.courseNumber = (Integer) in.readValue(Integer.class.getClassLoader());
        this.studentList = new ArrayList<Student>();
        in.readList(this.studentList, Student.class.getClassLoader());
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel source) {
            return new Group(source);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };
}

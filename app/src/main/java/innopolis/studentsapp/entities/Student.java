package innopolis.studentsapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by davlet on 6/8/17.
 */
public class Student extends Entity implements Serializable, Parcelable {
    private String name;
    private String surname;
    private String middleName;
    private Date dateOfBirth;
    private final Long id;
    private Long groupID;
    private transient List<Contact> contacts;
    private transient Random random = new Random();
    private int photoId;

    public Student(String name, String surname, String middleName, Date dateOfBirth, Long groupID, List<Contact> contacts) {
        random = new Random();
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.groupID = groupID;
        this.id = System.currentTimeMillis() + random.nextInt();
        this.contacts = contacts;
    }

    public Student(String name, String surname, String middleName, Date dateOfBirth, Long groupID) {
        random = new Random();
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.groupID = groupID;
        this.id = System.currentTimeMillis() + random.nextInt();
    }

    public Student(String name, String surname, String middleName, Date dateOfBirth, Long groupID, int photoId, List<Contact> contacts) {
        random = new Random();
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.groupID = groupID;
        this.id = System.currentTimeMillis() + random.nextInt();
        this.photoId = photoId;
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Student)) return false;
        if (!(this.getId().equals(((Student) o).getId()))) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.surname);
        dest.writeString(this.middleName);
        dest.writeLong(this.dateOfBirth != null ? this.dateOfBirth.getTime() : -1);
        dest.writeValue(this.id);
        dest.writeValue(this.groupID);
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.surname = in.readString();
        this.middleName = in.readString();
        long tmpDateOfBirth = in.readLong();
        this.dateOfBirth = tmpDateOfBirth == -1 ? null : new Date(tmpDateOfBirth);
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.groupID = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}

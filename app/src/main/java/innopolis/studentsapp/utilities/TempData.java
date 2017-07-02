package innopolis.studentsapp.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Contact;
import innopolis.studentsapp.entities.ContactType;
import innopolis.studentsapp.entities.Group;
import innopolis.studentsapp.entities.Journal;
import innopolis.studentsapp.entities.Lesson;
import innopolis.studentsapp.entities.Semester;
import innopolis.studentsapp.entities.Student;

/**
 * Created by davlet on 6/20/17.
 */

public class TempData {
    private static TempData data = null;
    public static List<Student> allStudents = null;
    public static List<Student> students = null;
    public static List<Student> students2 = null;
    public static List<Contact> contacts = null;
    public static List<Group> groups = null;
    public static List<Journal> journals = null;
    public static List<Lesson> lessons = null;
    static Random random = new Random();

    static {
        allStudents = new ArrayList<>();
        students = new ArrayList<>();
        groups = new ArrayList<>();
        contacts = new ArrayList<>();
        journals = new ArrayList<>();
        lessons = new ArrayList<>();

        students.add(new Student("Lillie!!!", "clinton", "perelman", new Date(123456789L), 1L, R.drawable.portraitphoto, null));
        students.add(new Student("albert", "einstein", "stein", new Date(123456789L), 1L, R.drawable.einstein, null));
        students.add(new Student("lillie", "clinton", "vein", new Date(123456789L), 1L, R.drawable.lillie, null));
        students.add(new Student("albert", "einstein", "kurzvei", new Date(123456789L), 1L, R.drawable.einstein, null));
        students.add(new Student("lillie", "clinton", "borowitz", new Date(123456789L), 1L, R.drawable.lillie, null));

        Contact tempContact;

        for (Student student : students){
            List<Contact> tempList = new ArrayList<>();
            for (int i = 0; i < 3; i++){
                StringBuilder tempPhone = new StringBuilder("+7");
                for (int j = 0; j <= 9; j++){
                    tempPhone.append(random.nextInt(9));
                }
                tempContact = new Contact(ContactType.PHONE, tempPhone.toString());
                tempList.add(tempContact);
            }
            student.setContacts(tempList);
        }

        Group group1 = new Group(1L, "group 1", 10);
        Group group2 = new Group(2L, "group 2", 20);
        Group group3 = new Group(3L, "group 3", 30);
        group1.setStudentList(students);

        students2 = new ArrayList<>();
        students2.add(new Student("2Lillie!!!", "clinton", "perelman", new Date(123456789L), 1L, R.drawable.portraitphoto, null));
        students2.add(new Student("2albert", "einstein", "stein", new Date(123456789L), 1L, R.drawable.einstein, null));
        students2.add(new Student("2lillie", "clinton", "vein", new Date(123456789L), 1L, R.drawable.lillie, null));
        students2.add(new Student("2albert", "einstein", "kurzvei", new Date(123456789L), 1L, R.drawable.einstein, null));
        students2.add(new Student("2lillie", "clinton", "borowitz", new Date(123456789L), 1L, R.drawable.lillie, null));

        Contact tempContact2;
        List<Contact> tempList2 = new ArrayList<>();
        for (Student student : students2){
            tempList2.clear();
            for (int i = 0; i < 3; i++){
                StringBuilder tempPhone = new StringBuilder("+7");
                for (int j = 0; j <= 9; j++){
                    tempPhone.append(random.nextInt(9));
                }
                tempContact2 = new Contact(ContactType.PHONE, tempPhone.toString());
                tempList2.add(tempContact2);
            }
            student.setContacts(tempList2);
        }
        group2.setStudentList(students2);

        groups.add(group1);
        groups.add(group2);
        groups.add(group3);

        allStudents.addAll(students);
        allStudents.addAll(students2);
    }

    private TempData() {

    }

    public static TempData getInstance() {
        if (data == null)
            return new TempData();
        return data;
    }

    public static List<Student> getStudents() {
        return allStudents;
    }

    public static List<Group> getGroups() {
        return groups;
    }

    public Student getStudentById(Long id) {
        for (Student student : allStudents) {
            if (student.getId().equals(id))
                return student;
        }
        return null;
    }

    public Group getGroupById(Long id){
        for (Group group : groups){
            if (group.getId().equals(id))
                return group;
        }
        return null;
    }

    public List<Contact> getContactsForStudentById(Long id){
        for (Student student : allStudents){
            if (student.getId().equals(id))
                return student.getContacts();
        }
        return null;
    }

    public List<Student> getStudentsForGroupById(Long id){
        return this.getGroupById(id).getStudentList();
    }
}

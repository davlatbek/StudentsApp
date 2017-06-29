package innopolis.studentsapp.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import innopolis.studentsapp.entities.Group;
import innopolis.studentsapp.entities.Semester;
import innopolis.studentsapp.entities.Student;

/**
 * Created by davlet on 6/20/17.
 */

public class TempData {
    private static TempData data = null;
    public static List<Group> groups = null;
    public static List<Student> students = null;

    private TempData(){
        students = new ArrayList<>();
        students.add(new Student("david", "beckham", "nomiddename", new Date(1234000L), 1L));
        students.add(new Student("cristian", "verner", "nomiddename", new Date(12345678L), 1L));
        students.add(new Student("davlet", "israilov", "nomiddename", new Date(123457689L), 1L));

        Group group = new Group(1L, "group p1" , 10, Semester.FALL);
        group.setStudentList(students);

        groups = new ArrayList<>();
        groups.add(group);
        groups.add(new Group(2L, "group 2" , 20, Semester.SPRING));
        groups.add(new Group(3L, "group 3" , 30, Semester.FALL));
    }

    public static TempData getInstance(){
        if (data == null)
            return new TempData();
        return data;
    }
}

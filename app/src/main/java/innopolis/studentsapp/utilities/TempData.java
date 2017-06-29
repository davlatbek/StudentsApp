package innopolis.studentsapp.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Group;
import innopolis.studentsapp.entities.Semester;
import innopolis.studentsapp.entities.Student;

/**
 * Created by davlet on 6/20/17.
 */

public class TempData {
    private static TempData data = null;
    public static List<Group> groups = null;

    public static List<Student> getStudents() {
        return students;
    }

    public static List<Student> students = null;

    static {
        students = new ArrayList<>();
        students.add(new Student("Lillie!!!", "clinton" , "kurbonovich", new Date(123456789L), 1L, R.drawable.portraitphoto));
        students.add(new Student("albert", "einstein" , "kurbonovich", new Date(123456789L), 1L, R.drawable.einstein));
        students.add(new Student("lillie", "clinton" , "kurbonovich", new Date(123456789L), 1L, R.drawable.lillie));
        students.add(new Student("albert", "einstein" , "kurbonovich", new Date(123456789L), 1L, R.drawable.einstein));
        students.add(new Student("lillie", "clinton" , "kurbonovich", new Date(123456789L), 1L, R.drawable.lillie));
    }

    private TempData(){
        Group group = new Group(1L, "group portraitphoto" , 10, Semester.FALL);
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

    public Student getStudentById(Long id){
        for (Student student:students){
            if (student.getId().equals(id))
                return student;
        }
        return null;
    }
}

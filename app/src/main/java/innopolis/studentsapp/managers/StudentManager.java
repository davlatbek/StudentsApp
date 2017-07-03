package innopolis.studentsapp.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import innopolis.studentsapp.entities.Student;

/**
 * Created by davlet on 6/8/17.
 */
public class StudentManager {
    private List<Student> students = new ArrayList<>();

    private static class StudentManagerHolder {
        private static final StudentManager INSTANCE = new StudentManager();
    }

    public static StudentManager getInstance(){
        return StudentManagerHolder.INSTANCE;
    }

    public void add(Student student){
        students.add(student);
    }

    public Student get(Long id){
        for (Student student : students){
            if (student.getId().equals(id))
                return student;
        }
        return null;
    }

    public List<Student> getAll(){
        return students;
    }

    public void addAll(List<Student> students) {
        this.students = students;
    }

    public void update(Student student){
        for (Student stud : students){
            if (student.getId().equals(stud.getId())){
                stud = student;
            }
        }
    }

    public void delete(Long idToDelete){
        for (Student student : students){
            if (student.getId().equals(idToDelete)){
                students.remove(student);
            }
        }
    }
}


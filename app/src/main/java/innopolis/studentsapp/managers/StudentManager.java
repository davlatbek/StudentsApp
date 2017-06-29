package innopolis.studentsapp.managers;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.entities.Student;

/**
 * Created by davlet on 6/8/17.
 */
public class StudentManager {
    List<Student> students = new ArrayList<>();

    public void create(Student student){
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

    public void update(Student student){
        for (Student stud : students){
            if (student.getId().equals(stud.getId())){
                stud = student;
            }
        }
    }

    public void delete(Long idToDelete){
        for (Student student : students){
            if (student.getId() == idToDelete){
                students.remove(student);
            }
        }
    }
}


package ec.utb.jv.data_access;

import ec.utb.jv.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> students;

    public StudentDaoList() {
        students = new ArrayList<>(0);
    }

    public Student saveStudent(Student student){
        if(students.contains(student)){
            return null;
        }
        students.add(student);
        return student;

    }



    public Student findByEmail(String email){
        for (Student student : students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }

        }
        return null;
    }

    public List<Student> findByName(String name){
        name = name.toLowerCase();
        List<Student> listOfNames = new ArrayList<>(0);
        for (Student student : students){
            if (student.getName().toLowerCase().contains(name)){
                listOfNames.add(student);
            }
        }

        return listOfNames;

    }

    @Override
    public Student findById(int id) {
        for (Student student : students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
       return students.contains(student) ? students.remove(student) : false;
    }
}

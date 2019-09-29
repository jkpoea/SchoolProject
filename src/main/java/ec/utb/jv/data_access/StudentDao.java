package ec.utb.jv.data_access;

import ec.utb.jv.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent (Student student);

    /*Hitta student via email*/
    Student findByEmail (String email);

    /*Hitta student via namn*/
    List<Student> findByName (String name);

    /*Hitta student via id*/
    Student findById (int id);

    /* Visa listan av studenter*/
    List<Student> findAll ();

    /*Tar bort studenter från listan*/
    boolean deleteStudent (Student student);
}

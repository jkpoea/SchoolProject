package ec.utb.jv.data_access;

import ec.utb.jv.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDao {

    Course saveCourse(Course course);

    /* Hitta kurs via id*/
    Course findById(int id);

    /*Hitta kurs/kurser via name*/
    List<Course> findByName(String name);

    /* Hitta kurs/kurser via datum*/
    List<Course> findByDate(LocalDate localDate);

    /* Få listan av alla kurser */
    List<Course> findAll ();

    /* Tar bort en kurs från listan */
    boolean removeCourse(Course course);

}

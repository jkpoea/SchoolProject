package ec.utb.jv.data_access;

import ec.utb.jv.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {

    private static List<Course> courses;

    public CourseDaoList() {
        courses = new ArrayList<>(0);
    }

    @Override
    public Course saveCourse(Course course) {
        if(courses.contains(course)){
            return null;
        }
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses){
            if (course.getId() == id){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        name = name.toLowerCase();
        List<Course> listofCourseNames = new ArrayList<>(0);
        for (Course course : courses){
            if (course.getCourseName().toLowerCase().contains(name)){
                listofCourseNames.add(course);
            }
        }
        return listofCourseNames;
    }

    @Override
    public List<Course> findByDate(LocalDate localDate) {
        List<Course> listByDate = new ArrayList<>(0);
        for (Course course : courses){
            if (course.getStartDate().equals(localDate)){
                listByDate.add(course);
            }
        }
        return listByDate;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        return courses.contains(course) ? courses.remove(course) : false;
    }
}

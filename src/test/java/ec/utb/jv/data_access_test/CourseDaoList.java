package ec.utb.jv.data_access_test;

import ec.utb.jv.Course;
import ec.utb.jv.data_access.CourseDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class CourseDaoList {

    CourseDao courseDao = new ec.utb.jv.data_access.CourseDaoList();
    Course c1 = new Course(1, "Datateknik", LocalDate.of(2019,12,24), 6);
    Course c2 = new Course(2, "Dataingejör", LocalDate.of(2019, 12, 24), 8);
    Course c3 = new Course(3, "Programmering", LocalDate.of(2020, 1, 11), 10);

    //Tested saveCourse method before refactor it into a @Before
    @Before
    public void saveCourse_test(){
        courseDao.saveCourse(c1);
        courseDao.saveCourse(c2);
        courseDao.saveCourse(c3);
    }

    @Test
    public void findById_test(){
        Course notNull = courseDao.findById(1);
        Course willBeNull = courseDao.findById(4);
        Assert.assertNotNull(notNull);
        Assert.assertNull(willBeNull);
    }

    @Test
    public void findByName_test(){
        List<Course> courseList = courseDao.findByName("DATA");
        Assert.assertNotNull(courseList);
        Assert.assertEquals(2, courseList.size());
    }

    @Test
    public void findByDate_test(){
        List<Course> dateList = courseDao.findByDate(LocalDate.of(2019,12,24));
        Assert.assertEquals(2, dateList.size());
    }

    @Test
    public void removeCourse_test(){
        Assert.assertTrue(courseDao.removeCourse(c1));
        Assert.assertFalse(courseDao.removeCourse(c1));
        Assert.assertEquals(2, courseDao.findAll().size());
    }

}

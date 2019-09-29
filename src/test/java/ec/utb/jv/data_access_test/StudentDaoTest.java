package ec.utb.jv.data_access_test;

import ec.utb.jv.Student;
import ec.utb.jv.data_access.StudentDao;
import ec.utb.jv.data_access.StudentDaoList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {

    StudentDao studentDao = new StudentDaoList();
    Student s1 = new Student(1, "Daniel Svensson", "test@email.com", "testgatan 1");
    Student s2 = new Student(2, "Daniel Andersson", "test@gmail.com", "testgatan 2");
    Student s3 = new Student(3,"Anders Sjöqvist", "test@hotmail.com", "testgatan 3");

    //Testing if student is added into the list
    // + adding S1 again and expecting list to be size 1
    //Also testing findAll method by accident.
    @Test
    public void saveStudent_test(){
        studentDao.saveStudent(s1);
        studentDao.saveStudent(s1);
        Assert.assertNotNull(studentDao.findAll());
        Assert.assertEquals(1, studentDao.findAll().size());
    }

    //Testing find email method
    @Test
    public void findByEmail_test(){
        studentDao.saveStudent(s2);
        Student test = studentDao.findByEmail("test@gmail.com");
        Assert.assertNotNull(test);
        Assert.assertEquals(s2, test);
    }
    //Testing findByName method. Seraching for "Daniel" and expecting the list to be 2
    @Test
    public void findByName_test(){
        studentDao.saveStudent(s1);
        studentDao.saveStudent(s2);
        List<Student> nameList = studentDao.findByName("daniel");
        Assert.assertEquals(2, nameList.size());
    }
    //Testing findById_test
    @Test
    public void findbyId_test(){
        studentDao.saveStudent(s2);
       Student expected = studentDao.findById(2);
       Student studentNull = studentDao.findById(4);
       Assert.assertNotNull(expected);
       Assert.assertEquals(s2, expected);
       Assert.assertNull(studentNull);

    }
    //Testing deleteStudent method.
    //Add 2 students and remove 1. Expecting list to be size 1
    //then seraching for the removed student. Expecting to be null
    @Test
    public void deleteStudent_test(){
        Student number1 = studentDao.saveStudent(s1);
        Student number2 = studentDao.saveStudent(s2);
        studentDao.deleteStudent(s2);
        Assert.assertEquals(1, studentDao.findAll().size());
        Assert.assertNull(studentDao.findById(2));
    }
}

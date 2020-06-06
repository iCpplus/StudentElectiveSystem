package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import service.CourseManager;
import service.StudentManger;

public class StudentMangerImpl implements StudentManger {
    StudentDao studentDao = new StudentDaoImpl();
    CourseManager courseManager = new CourseManagerImpl();

    @Override
    public int insertStudent(Student student) {
        List<Student> list = new ArrayList<>();
        list = studentDao.selectAllStudent();
        int n = 0;
        for (Student s : list) {
            if (s.getId().equals(student.getId())) {
                n = -1;
                break;
            }
        }
        if (n == 0) {
            studentDao.insertStudent(student);
        }
        return n;
    }

    @Override
    public int deleteStudent(String id) {
        int n = -1;
        List<Student> list = new ArrayList<>();
        list = studentDao.selectAllStudent();
        for (Student s : list) {
            if (s.getId().equals(id)) {
                n = 0;
                break;
            }
        }
        if (n == 0) {
            studentDao.deleteStudent(id);
        }
        return n;
    }

    @Override
    public int updateStudent(Student student, String id) {
        int n = -1;
        List<Student> list = new ArrayList<>();
        list = studentDao.selectAllStudent();
        for (Student s : list) {
            if (s.getId().equals(id)) {
                n = 0;
                list.remove(s);
                break;
            }
            for (Student st : list) {
                if (student.getId().equals(st.getId()))
                    n = -2;
                break;
            }
        }
        if (n == 0) {
            studentDao.updateStudent(student, id);
        }
        return n; // 如果n=-1 那么说明数据库中没有这个学生信息。如果n=-2，那么说明想要修改的id与数据库中重复。
    }

    @Override
    public Student selectStudent(String id) {
        Student student = null;
        List<Student> list = new ArrayList<>();
        list = studentDao.selectAllStudent();
        for (Student s : list) {
            if (s.getId().equals(id)) {
                student = s;
                break;
            }
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudent() {
        return studentDao.selectAllStudent();
    }

}
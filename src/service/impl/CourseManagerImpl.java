package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import entity.Course;
import service.CourseManager;

public class CourseManagerImpl implements CourseManager {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public int insertCourse(Course course) {
        List<Course> list = new ArrayList<>();
        list = courseDao.selectAllCourse();
        int n = 0;
        for (Course s : list) {
            if (s.getId().equals(course.getId()) || s.getName().equals(course.getName())) {
                n = -1;
                break;
            }
        }
        if (n == 0) {
            courseDao.insertCourse(course);
        }
        return n;
    }

    @Override
    public int deleteCourse(String name) {
        int n = -1;
        List<Course> list = new ArrayList<>();
        list = courseDao.selectAllCourse();
        for (Course s : list) {
            if (s.getName().equals(name)) {
                n = 0;
                break;
            }
        }
        if (n == 0) {
            courseDao.deleteCourse(name);
        }
        return n;
    }

    @Override
    public int updateCourse(Course course, String name) {
        int n = -1;
        List<Course> list = new ArrayList<>();
        list = courseDao.selectAllCourse();
        for (Course s : list) {
            if (s.getName().equals(name)) {
                n = 0;
                list.remove(s);
                break;
            }
            for (Course st : list) {
                if (course.getId().equals(st.getId()) || course.getName().equals(st.getName()))
                    n = -2;
                break;
            }
        }
        if (n == 0) {
            courseDao.updateCourse(course, name);
        }
        return n;
    }

    @Override
    public Course selectCourse(String name) {
        Course course = null;
        List<Course> list = new ArrayList<>();
        list = courseDao.selectAllCourse();
        for (Course s : list) {
            if (s.getName().equals(name)) {
                course = s;
                break;
            }
        }
        return course;
    }

    @Override
    public List<Course> selectAllCourse() {
        return courseDao.selectAllCourse();
    }

}
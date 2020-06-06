package service.impl;

import dao.ScDao;
import dao.impl.ScDaoImpl;
import entity.Sc;
import service.AdminManager;
import service.CourseManager;
import service.StudentManger;

public class AdminManagerImpl implements AdminManager {

    StudentManger studentManager = new StudentMangerImpl();
    CourseManager courseManager = new CourseManagerImpl();
    ScDao scDao = new ScDaoImpl();

    @Override
    public int selectCourse(String id, String name) {
        int n = 0;
        if (studentManager.selectStudent(id) == null) {
            n = -1;
        } else if (courseManager.selectCourse(name) == null) {
            n = -2;
        }
        if (n == 0) {
            Sc sc = new Sc();
            sc.setSId(id);
            sc.setCName(name);
            sc.setSName(studentManager.selectStudent(id).getName());
            scDao.insertStudent(sc);
        }

        return n; // 如果返回-1，则是数据库中没有这个学生。如果返回-2，则是数据库中没有该课程
    }
}
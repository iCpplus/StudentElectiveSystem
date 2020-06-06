package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import entity.Student;
import util.DbUtil;

public class StudentDaoImpl implements StudentDao {

    @Override
    public int insertStudent(Student student) {

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "insert into students values(?,?,?,?)";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, student.getId());
            st.setString(2, student.getName());
            st.setString(3, student.getGender());
            st.setString(4, student.getGrade());
            st.executeUpdate(); // 执行编译
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, null);
        }

        return 0;
    }

    @Override
    public int deleteStudent(String id) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "DELETE FROM students WHERE id=?";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, id);
            st.executeUpdate(); // 执行编译
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, null);
        }
        return 0;
    }

    @Override
    public int updateStudent(Student student, String id) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "UPDATE students SET name=?, gender=?,  grade=?,  id=? WHERE id=?";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, student.getName());
            st.setString(2, student.getGender());
            st.setString(3, student.getGrade());
            st.setString(4, student.getId());
            st.setString(5, id);

            st.executeUpdate(); // 执行编译
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, null);
        }
        return 0;
    }

    @Override
    public Student selectStudent(String id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Student s = new Student();
        try {
            conn = DbUtil.getConnection();
            String sql = "select * from students WHERE id=?";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, id);
            rs = st.executeQuery(); // 执行编译
            if (rs.next()) {
                s.setId(rs.getString("id"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getString("gender"));
                s.setGrade(rs.getString("grade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, rs);
        }
        return s;
    }

    @Override
    public List<Student> selectAllStudent() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            conn = DbUtil.getConnection();
            String sql = "select * from students";
            st = conn.prepareStatement(sql); // 预编译
            rs = st.executeQuery(); // 执行编译
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("id"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getString("gender"));
                s.setGrade(rs.getString("grade"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, rs);
        }
        return list;
    }

}
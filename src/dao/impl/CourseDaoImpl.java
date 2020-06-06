package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CourseDao;
import entity.Course;
import util.DbUtil;

public class CourseDaoImpl implements CourseDao {

    @Override
    public int insertCourse(Course course) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "insert into courses values(?,?,?)";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, course.getId());
            st.setString(2, course.getName());
            st.setInt(3, course.getCredit());
            st.executeUpdate(); // 执行编译
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, null);
        }

        return 0;
    }

    @Override
    public int deleteCourse(String name) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "DELETE FROM courses WHERE name=?";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, name);
            st.executeUpdate(); // 执行编译
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, null);
        }
        return 0;
    }

    @Override
    public int updateCourse(Course course, String name) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "UPDATE courses SET name=?, credit=?, id=? WHERE name=?";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, course.getName());

            st.setInt(2, course.getCredit());
            st.setString(3, course.getId());
            st.setString(4, name);

            st.executeUpdate(); // 执行编译
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, null);
        }
        return 0;
    }

    @Override
    public Course selectCourse(String name) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Course c =new Course();
        try {
            conn = DbUtil.getConnection();
            String sql = "select * from courses WHERE name=?";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, name);
            rs = st.executeQuery(); // 执行编译
            if (rs.next()) {
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setCredit(rs.getInt("credit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, rs);
        }
        return c;
    }

    @Override
    public List<Course> selectAllCourse() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Course> list=new ArrayList<>();
        try {
            conn = DbUtil.getConnection();
            String sql = "select * from courses";
            st = conn.prepareStatement(sql); // 预编译
            rs = st.executeQuery(); // 执行编译
            while (rs.next()) {
                Course c=new Course();
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setCredit(rs.getInt("credit"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, rs);
        }
        return list;
    }

}
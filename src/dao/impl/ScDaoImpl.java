package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ScDao;
import entity.Sc;
import util.DbUtil;

public class ScDaoImpl implements ScDao {

    @Override
    public int insertStudent(Sc sc) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "insert into sc values(?,?,?)";
            st = conn.prepareStatement(sql); // 预编译
            st.setString(1, sc.getSId());
            st.setString(2, sc.getCName());
            st.setString(3, sc.getSName());
            st.executeUpdate(); // 执行编译
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, null);
        }

        return 0;
    }

    @Override
    public List<Sc> selectAllStudent() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Sc> list = new ArrayList<>();
        try {
            conn = DbUtil.getConnection();
            String sql = "select * from sc";
            st = conn.prepareStatement(sql); // 预编译
            rs = st.executeQuery(); // 执行编译
            while (rs.next()) {
                Sc sc = new Sc();
                sc.setSId(rs.getString("SId"));
                sc.setCName(rs.getString("CName"));
                sc.setSName(rs.getString("SName"));
                list.add(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.release(conn, st, rs);
        }
        return list;
    }

}
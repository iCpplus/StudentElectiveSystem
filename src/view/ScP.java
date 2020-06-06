package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.ScDao;
import dao.impl.ScDaoImpl;
import entity.Course;
import entity.Sc;
import entity.Student;
import service.AdminManager;
import service.CourseManager;
import service.StudentManger;
import service.impl.AdminManagerImpl;
import service.impl.CourseManagerImpl;
import service.impl.StudentMangerImpl;

public class ScP {

    public static JPanel SCP() {

        ScDao scDao = new ScDaoImpl();
        AdminManager adminManager = new AdminManagerImpl();
        StudentManger studentManger = new StudentMangerImpl();
        CourseManager courseManager = new CourseManagerImpl();

        JPanel p1 = new JPanel();
        p1.setBounds(50, 50, 300, 60);

        JButton b1 = new JButton("选课");
        JButton b2 = new JButton("查询学生数量");
        JButton b3 = new JButton("查询课程数量");
        JButton b4 = new JButton("查询课程相关学生");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setTitle("选课");
                d.setSize(400, 300);
                d.setLocation(200, 200);
                d.setLayout(new FlowLayout());

                JTextField tf1 = new JTextField();
                tf1.setText("选课学生的学号");
                tf1.setPreferredSize(new Dimension(80, 30));

                JTextField tf2 = new JTextField();
                tf2.setText("要选的课程名");
                tf2.setPreferredSize(new Dimension(80, 30));

                JButton b = new JButton("确定");
                b.setBounds(50, 50, 280, 30);
                b.setPreferredSize(new Dimension(300, 40));
                d.add(b);
                d.add(tf1);
                d.add(tf2);

                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text1 = tf1.getText();
                        String text2 = tf2.getText();

                        int n = adminManager.selectCourse(text1, text2);
                        if (n == 0) {
                            JOptionPane.showMessageDialog(null, "选课成功");
                        } else if (n == -1) {
                            JOptionPane.showMessageDialog(null, "没有这个学生");
                        } else {
                            JOptionPane.showMessageDialog(null, "没有该课程");
                        }
                    }
                });
                d.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<Student> list = studentManger.selectAllStudent();
                JOptionPane.showMessageDialog(null, "学生总数：" + list.size());
            }
        });

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<Course> list = courseManager.selectAllCourse();
                JOptionPane.showMessageDialog(null, "课程总数总数：" + list.size());
            }
        });

        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setTitle("delete");
                d.setSize(400, 300);
                d.setLocation(200, 200);
                d.setLayout(new FlowLayout());

                JTextField tf1 = new JTextField();
                tf1.setText("课程名");
                tf1.setPreferredSize(new Dimension(80, 30));

                JButton b = new JButton("确定");
                b.setBounds(50, 50, 280, 30);
                b.setPreferredSize(new Dimension(300, 40));
                d.add(b);
                d.add(tf1);

                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text1 = tf1.getText();
                        List<Sc> list = scDao.selectAllStudent();
                        List<Sc> list2 = new ArrayList<>();
                        for (Sc sc : list) {
                            if (sc.getCName().equals(text1)) {
                                list2.add(sc);
                            }
                        }

                        String[] columnNames = new String[] { "SId", "SName" };
                        String[][] scs = new String[list2.size()][2];
                        int k = 0;
                        for (int i = 0; i < scs.length; i++) {
                            for (int j = 0; j < scs[i].length; j++) {
                                if (j == 0) {
                                    scs[i][j] = list2.get(k).getSId();
                                }
                                if (j == 1) {
                                    scs[i][j] = list2.get(k).getSName();
                                    k++;
                                }

                            }
                        }

                        JTable t = new JTable(scs, columnNames);

                        JDialog d2 = new JDialog();
                        d2.setTitle("结果");
                        d2.setSize(400, 300);
                        d2.setLocation(200, 200);
                        d2.setLayout(new BorderLayout());
                        d2.add(t, BorderLayout.CENTER);
                        d2.setVisible(true);
                    }
                });
                d.setVisible(true);

            }
        });

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        return p1;
    }

}
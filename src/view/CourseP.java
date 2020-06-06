package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import entity.Course;
import service.CourseManager;
import service.impl.CourseManagerImpl;

public class CourseP {
    public static JPanel CP() {
        CourseManager courseManager = new CourseManagerImpl();
        JPanel p1 = new JPanel();
        p1.setBounds(50, 50, 300, 60);

        JButton b1 = new JButton("添加");
        JButton b2 = new JButton("删除");
        JButton b3 = new JButton("修改");
        JButton b4 = new JButton("查询");
        JButton b5 = new JButton("显示");

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setTitle("insert");
                d.setSize(400, 300);
                d.setLocation(200, 200);
                d.setLayout(new FlowLayout());

                JTextField tf1 = new JTextField();
                tf1.setText("课程号");
                tf1.setPreferredSize(new Dimension(80, 30));

                JTextField tf2 = new JTextField();
                tf2.setText("课程名");
                tf2.setPreferredSize(new Dimension(80, 30));
                JTextField tf3 = new JTextField();
                tf3.setText("学分");
                tf3.setPreferredSize(new Dimension(80, 30));

                JButton b = new JButton("确定");
                b.setBounds(50, 50, 280, 30);
                b.setPreferredSize(new Dimension(300, 40));
                d.add(b);
                d.add(tf1);
                d.add(tf2);
                d.add(tf3);

                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text1 = tf1.getText();
                        String text2 = tf2.getText();
                        String text3 = tf3.getText();

                        Course course = new Course();
                        course.setId(text1);
                        course.setName(text2);
                        course.setCredit(Integer.valueOf(text3).intValue());
                        int n = courseManager.insertCourse(course);
                        if (n == 0) {
                            JOptionPane.showMessageDialog(null, "添加成功");
                        } else {
                            JOptionPane.showMessageDialog(null, "课程已存在");
                        }
                    }
                });
                d.setVisible(true);

            }
        });

        b2.addActionListener(new ActionListener() {

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
                        if (courseManager.deleteCourse(text1) == 0) {
                            JOptionPane.showMessageDialog(null, "删除成功");
                        } else {
                            JOptionPane.showMessageDialog(null, "没有该课程");
                        }
                    }
                });
                d.setVisible(true);

            }
        });

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setTitle("update");
                d.setSize(400, 300);
                d.setLocation(200, 200);
                d.setLayout(new FlowLayout());

                JTextField tf1 = new JTextField();
                tf1.setText("课程号");
                tf1.setPreferredSize(new Dimension(80, 30));

                JTextField tf2 = new JTextField();
                tf2.setText("课程名");
                tf2.setPreferredSize(new Dimension(80, 30));
                JTextField tf3 = new JTextField();
                tf3.setText("学分");
                tf3.setPreferredSize(new Dimension(80, 30));

                JTextField tf5 = new JTextField();
                tf5.setText("目标课程名");
                tf5.setPreferredSize(new Dimension(80, 30));
                JButton b = new JButton("确定");
                b.setBounds(50, 50, 280, 30);
                b.setPreferredSize(new Dimension(300, 40));
                d.add(b);
                d.add(tf1);
                d.add(tf2);
                d.add(tf3);
                d.add(tf5);
                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text1 = tf1.getText();
                        String text2 = tf2.getText();
                        String text3 = tf3.getText();
                        String text5 = tf5.getText();
                        Course course = new Course();
                        course.setId(text1);
                        course.setName(text2);
                        course.setCredit(Integer.valueOf(text3).intValue());

                        int n = courseManager.updateCourse(course, text5);
                        if (n == 0) {
                            JOptionPane.showMessageDialog(null, "修改成功");
                        } else if (n == -1) {
                            JOptionPane.showMessageDialog(null, "没有该课程");
                        } else {
                            JOptionPane.showMessageDialog(null, "修改的课程重复");
                        }

                    }
                });
                d.setVisible(true);

            }
        });

        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setTitle("select");
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
                        Course s = courseManager.selectCourse(text1);
                        if (s != null) {
                            JOptionPane.showMessageDialog(null, s.getId() + " " + s.getName() + " " + s.getCredit());
                        } else {
                            JOptionPane.showMessageDialog(null, "没有这个学生");
                        }
                    }
                });
                d.setVisible(true);

            }
        });

        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setTitle("selectAll");
                d.setSize(400, 300);
                d.setLocation(200, 200);
                d.setLayout(new BorderLayout());

                List<Course> list = courseManager.selectAllCourse();

                String[] columnNames = new String[] { "id", "name", "credit" };
                String[][] courses = new String[list.size()][3];
                int k = 0;
                for (int i = 0; i < courses.length; i++) {
                    for (int j = 0; j < courses[i].length; j++) {
                        if (j == 0) {
                            courses[i][j] = list.get(k).getId();
                        }
                        if (j == 1) {
                            courses[i][j] = list.get(k).getName();
                        }
                        if (j == 2) {
                            courses[i][j] = Integer.toString(list.get(k).getCredit());
                            k++;
                        }

                    }
                }

                JTable t = new JTable(courses, columnNames);
                d.add(t, BorderLayout.CENTER);
                d.setVisible(true);
            }
        });

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        return p1;
    }

}
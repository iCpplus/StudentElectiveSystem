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

import entity.Student;
import service.StudentManger;
import service.impl.StudentMangerImpl;

public class StudentP {
    public static JPanel SP() {
        StudentManger studentManger = new StudentMangerImpl();
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
                tf1.setText("学号");
                tf1.setPreferredSize(new Dimension(80, 30));

                JTextField tf2 = new JTextField();
                tf2.setText("姓名");
                tf2.setPreferredSize(new Dimension(80, 30));
                JTextField tf3 = new JTextField();
                tf3.setText("性别");
                tf3.setPreferredSize(new Dimension(80, 30));
                JTextField tf4 = new JTextField();
                tf4.setText("班级");
                tf4.setPreferredSize(new Dimension(80, 30));
                JButton b = new JButton("确定");
                b.setBounds(50, 50, 280, 30);
                b.setPreferredSize(new Dimension(300, 40));
                d.add(b);
                d.add(tf1);
                d.add(tf2);
                d.add(tf3);
                d.add(tf4);

                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text1 = tf1.getText();
                        String text2 = tf2.getText();
                        String text3 = tf3.getText();
                        String text4 = tf4.getText();

                        Student student = new Student();
                        student.setId(text1);
                        student.setName(text2);
                        student.setGender(text3);
                        student.setGrade(text4);
                        if (studentManger.insertStudent(student) == 0) {
                            JOptionPane.showMessageDialog(null, "添加成功");
                        } else {
                            JOptionPane.showMessageDialog(null, "学号重复");
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
                tf1.setText("学号");
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
                        if (studentManger.deleteStudent(text1) == 0) {
                            JOptionPane.showMessageDialog(null, "删除成功");
                        } else {
                            JOptionPane.showMessageDialog(null, "没有这个学生");
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
                tf1.setText("学号");
                tf1.setPreferredSize(new Dimension(80, 30));

                JTextField tf2 = new JTextField();
                tf2.setText("姓名");
                tf2.setPreferredSize(new Dimension(80, 30));
                JTextField tf3 = new JTextField();
                tf3.setText("性别");
                tf3.setPreferredSize(new Dimension(80, 30));
                JTextField tf4 = new JTextField();
                tf4.setText("班级");
                tf4.setPreferredSize(new Dimension(80, 30));
                JTextField tf5 = new JTextField();
                tf5.setText("目标学号");
                tf5.setPreferredSize(new Dimension(80, 30));
                JButton b = new JButton("确定");
                b.setBounds(50, 50, 280, 30);
                b.setPreferredSize(new Dimension(300, 40));
                d.add(b);
                d.add(tf1);
                d.add(tf2);
                d.add(tf3);
                d.add(tf4);
                d.add(tf5);
                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text1 = tf1.getText();
                        String text2 = tf2.getText();
                        String text3 = tf3.getText();
                        String text4 = tf4.getText();
                        String text5 = tf5.getText();
                        Student student = new Student();
                        student.setId(text1);
                        student.setName(text2);
                        student.setGender(text3);
                        student.setGrade(text4);
                        int n = studentManger.updateStudent(student, text5);
                        if (n == 0) {
                            JOptionPane.showMessageDialog(null, "修改成功");
                        } else if (n == -1) {
                            JOptionPane.showMessageDialog(null, "没有这个学生");
                        } else {
                            JOptionPane.showMessageDialog(null, "修改的学号重复");
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
                tf1.setText("学号");
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
                        Student s = studentManger.selectStudent(text1);
                        if (s != null) {
                            JOptionPane.showMessageDialog(null,
                                    s.getId() + " " + s.getName() + " " + s.getGender() + " " + s.getGrade());
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

                List<Student> list = studentManger.selectAllStudent();

                String[] columnNames = new String[] { "id", "name", "gender", "grade" };
                String[][] students = new String[list.size()][4];
                int k = 0;
                for (int i = 0; i < students.length; i++) {
                    for (int j = 0; j < students[i].length; j++) {
                        if (j == 0) {
                            students[i][j] = list.get(k).getId();
                        }
                        if (j == 1) {
                            students[i][j] = list.get(k).getName();
                        }
                        if (j == 2) {
                            students[i][j] = list.get(k).getGender();
                        }
                        if (j == 3) {
                            students[i][j] = list.get(k).getGrade();
                            k++;
                        }
                    }
                }

                JTable t = new JTable(students, columnNames);
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
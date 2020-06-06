package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import entity.Student;
import service.StudentManger;
import service.impl.StudentMangerImpl;

public class View {

    public static void main(String[] args) {
        StudentManger studentManger = new StudentMangerImpl();
        JFrame frame = new JFrame("学生选修课系统");
        frame.setSize(600, 500);
        frame.setLocation(200, 200);
        frame.setLayout(new FlowLayout());

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
                String[][] heros = new String[list.size()][4];
                int k = 0;
                for (int i = 0; i < heros.length; i++) {
                    for (int j = 0; j < heros[i].length; j++) {
                        if (j == 0) {
                            heros[i][j] = list.get(k).getId();
                        }
                        if (j == 1) {
                            heros[i][j] = list.get(k).getName();
                        }
                        if (j == 2) {
                            heros[i][j] = list.get(k).getGender();
                        }
                        if (j == 3) {
                            heros[i][j] = list.get(k).getGrade();
                            k++;
                        }
                    }
                }

                JTable t = new JTable(heros, columnNames);
                d.add(t,BorderLayout.CENTER);                              
                d.setVisible(true);
            }
        });

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);

        JPanel p2 = new JPanel();
        JButton b6 = new JButton("添加");
        JButton b7 = new JButton("删除");
        JButton b8 = new JButton("修改");
        JButton b9 = new JButton("查询");
        JButton b10 = new JButton("显示");

        p2.add(b6);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b10);

        p2.setBounds(10, 150, 300, 60);

        JPanel p3 = new JPanel();
        p3.setBounds(50, 50, 300, 60);
        JTabbedPane tp = new JTabbedPane();
        tp.add(p1);
        tp.add(p2);
        tp.add(p3);

        tp.setTitleAt(0, "学生信息");
        tp.setTitleAt(1, "课程信息");
        tp.setTitleAt(2, "选课系统");

        
        frame.setContentPane(tp);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.FlowLayout;

public class Client {
    public static void main(String[] args) {
        JFrame frame = new JFrame("学生选修课系统");
        frame.setSize(600, 500);
        frame.setLocation(200, 200);
        frame.setLayout(new FlowLayout());

        JPanel p1 = StudentP.SP();
        JPanel p2=CourseP.CP();
        JPanel p3=ScP.SCP();
        JTabbedPane tp = new JTabbedPane();
        tp.add(p1);
        tp.add(p2);
        tp.add(p3);
        tp.setTitleAt(0, "学生信息");
        tp.setTitleAt(1, "课程信息");
        tp.setTitleAt(2, "选课及统计系统");
        frame.setContentPane(tp);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
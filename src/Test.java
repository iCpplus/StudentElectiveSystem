import entity.Course;
import service.CourseManager;
import service.impl.CourseManagerImpl;

public class Test {
    public static void main(String[] args) {

        // AdminManager adminManager = new AdminManagerImpl();
        // adminManager.selectCourse("201811044218", "java");

        // Course course = new Course();
        // course.setId("123456");
        // course.setName("java");
        // course.setCredit(3);
        // CourseManager courseManager = new CourseManagerImpl();
        // courseManager.insertCourse(course);

        // Student student = new Student();
        // student.setId("201811044218");
        // student.setName("kkkkkkkkkkk");
        // student.setGender("boy");
        // student.setAge(18);
        // student.setGrade("grade 2");
        // student.setTheClass("182");
        // student.setPNumber("15188446937");
        // StudentDao studentDao = new StudentDaoImpl();
        // studentDao.insertStudent(student);
        // List<Student> list=new ArrayList<>();
        // list=studentDao.selectAllStudent();
        // System.out.println(list.size());
        // StudentManger studentManger = new StudentMangerImpl();
        // studentManger.insertStudent(new Student("222", "222", "222", "222"));
        // CourseDao courseDao=new CourseDaoImpl();
        CourseManager courseManager=new CourseManagerImpl();
        Course c=new Course("83338","数据库",3);
        courseManager.updateCourse(c, "333");
        // courseDao.updateCourse(c, "java");

        // System.out.println( studentManger.deleteStudent("20181105"));
        // studentDao.deleteStudent("201811044215");
        // student = studentDao.selectStudent("201811044215");
        // studentDao.updateStudent(student,"201811044222");
        // System.out.println(student.getName());

    }
}
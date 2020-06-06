package dao;

import java.util.List;

import entity.Student;

public interface StudentDao {
    /**
     * insert student.
     * 
     * @param student
     * @return int
     */
    int insertStudent(Student student);

    /**
     * delete student by id.
     * 
     * @param id
     * @return int
     */
    int deleteStudent(String id);

    /**
     * update student by id.
     * 
     * @param student id
     * @return int
     */
    int updateStudent(Student student,String id);

    /**
     * select student by id.
     * 
     * @param id
     * @return student
     */
    Student selectStudent(String id);

    /**
     * select all students.
     * 
     * @return list of student
     */
    List<Student> selectAllStudent();
}
package service;

import java.util.List;

import entity.Course;

public interface CourseManager {
    /**
     * insert course.
     * 
     * @param course
     * @return int
     */
    int insertCourse(Course course);

    /**
     * delete course by its name.
     * 
     * @param name of course
     * @return int
     */
    int deleteCourse(String name);

    /**
     * update course by its name.
     * 
     * @param course name
     * @return int
     */
    int updateCourse(Course course, String name);

    /**
     * select course by its name.
     * 
     * @param name of course
     * @return course
     */
    Course selectCourse(String name);

    /**
     * select all courses.
     * 
     * @return list of courses
     */
    List<Course> selectAllCourse();
}
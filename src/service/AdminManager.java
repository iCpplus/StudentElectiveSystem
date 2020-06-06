package service;

public interface AdminManager {
    /**
     * use student's id select course by name.
     * 
     * @param id   of student
     * @param name of course
     * @return int
     */
    int selectCourse(String id, String name);
}
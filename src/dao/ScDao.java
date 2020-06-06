package dao;

import java.util.List;

import entity.Sc;

public interface ScDao {
    /**
     * 
     * @param sc
     * @return int
     */
    int insertStudent(Sc sc);
    /**
     * 
     * @return list
     */
    List<Sc> selectAllStudent();
}
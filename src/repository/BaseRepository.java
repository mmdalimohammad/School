package repository;

import model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<T> {
    List<T> getAll() throws SQLException;
    boolean add(T t) throws SQLException;
    boolean remove(T t) throws SQLException;
    boolean update(T t) throws SQLException;

}

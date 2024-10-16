package repository;

import model.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface StudentRepository extends BaseRepository<Student> {

    Optional<Student> getByNationalCode(String nationalCode)throws SQLException;
    Optional<Student> getByIdAndNationalCode(int id, String nationalCode) throws SQLException;

    @Override
    List<Student> getAll() throws SQLException;

    @Override
    boolean add(Student student) throws SQLException;

    @Override
    boolean remove(Student student) throws SQLException;

    @Override
    boolean update(Student student) throws SQLException;



}

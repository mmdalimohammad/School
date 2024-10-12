package repository;

import model.Student;
import model.Teacher;
import model.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface TeacherRepository extends BaseRepository<Teacher> {
    @Override
    List<Teacher> getAll() throws SQLException;

    @Override
    boolean add(Teacher teacher) throws SQLException;

    @Override
    boolean remove(Teacher teacher) throws SQLException;

    @Override
    boolean update(Teacher teacher) throws SQLException;
    Teacher getByNationalCode(String nationalCode) throws SQLException;
    Teacher getByIdAndNationalCode(int id, String nationalCode) throws SQLException;
    List<StudentDto> getAllStudent() throws SQLException;



}

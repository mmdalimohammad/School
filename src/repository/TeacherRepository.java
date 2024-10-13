package repository;

import model.Student;
import model.Teacher;
import model.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends BaseRepository<Teacher> {
    @Override
    List<Teacher> getAll() throws SQLException;

    @Override
    boolean add(Teacher teacher) throws SQLException;

    @Override
    boolean remove(Teacher teacher) throws SQLException;

    @Override
    boolean update(Teacher teacher) throws SQLException;
    Optional<Teacher> getByNationalCode(String nationalCode) throws SQLException;
    Optional<Teacher> getByIdAndNationalCode(int id, String nationalCode) throws SQLException;
    List<StudentDto> getAllStudent() throws SQLException;

    boolean addScore(long studentId,int courseId, double score) throws SQLException;



}

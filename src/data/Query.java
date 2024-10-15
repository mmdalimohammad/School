package data;

public class Query {
    //language=sql
    public static final String ADD_STUDENT_DATA = "INSERT INTO students (first_name, last_name, dob, national_code)\n" +
            "VALUES (?, ?, ?, ?)";
    //language=sql
    public static final String GET_STUDENT_BY_ID_NATIONAL_CODE = "select *\n" + "from students\n" + "where student_id = ? and national_code = ?";
    //language=sql
    public static final String GET_ALL_STUDENT_QUERY = "SELECT * FROM students ";

    //language=sql
    public static final String REMOVE_STUDENTS_DATA = "DELETE FROM students WHERE student_id = ?";
    //language=sql
    public static final String GET_STUDENT_FIND_BY_NATIONAL_CODE = "SELECT * FROM students WHERE national_code = ?";
    //language=sql
    public static final String UPDATE_STUDENT_DATA = "UPDATE students SET first_name =? ,last_name=? WHERE national_code = ?";
    //language=sql
    public static final String ADD_COURSE_STUDENT = "insert into courses_students(course_id, student_id,national_code) values (?,?,?)";
    //language=sql
    public static final String GET_USER_COURSES = "select c.course_title, c.course_unit, concat(t.first_name, ' ', t.last_name) as teacherName, e.date, e.time from courses c join courses_students cs on c.course_id = cs.course_id join teachers t on c.course_id = t.course_id join public.exams e on c.course_id = e.course_id where student_id = ?";

    //language=sql
    public static final String ADD_EXAM_STUDENT = "insert into exams_students (exam_id,student_id,national_code) values (?,?,?)";
    //language=sql
    public static final String FIND_EXAM_STUDENT = "select e.exam_id from courses_students cs join exams e on e.course_id = cs.course_id where cs.student_id = ? ";
    //language=sql
    public static final String DELETE_COURSE_STUDENT = "delete from courses_students cs where  course_id = ? and student_id = ? and national_code = ?";
    //language=sql
    public static final String DELETE_EXAM_STUDENT = "delete from exams_students where exam_id = ?";
    //language=sql
    public static final String GET_COUNT_COURSE_STUDENT = "select count(*) from courses_students where   course_id =? and student_id=? ";
    //language=sql
    public static final String REMOVE_COURSE_STUDENT_ID = "DELETE FROM courses_students WHERE student_id = ?";
    //language=sql
    public static final String REMOVE_EXAM_STUDENT_ID = "DELETE FROM exams_students WHERE student_id = ?";
    //******************************************************************************************************************************************

    //language=sql
    public static final String GET_ALL_TEACHER_QUERY = "select * from teachers";

    //language=sql
    public static final String ADD_TEACHER_DATA = "INSERT INTO teachers (first_name, last_name, dob,national_code,course_id) VALUES (?,?,?,?,?)";
    //language=sql
    public static final String REMOVE_TEACHER_DATA = "DELETE FROM teachers WHERE teacher_id = ?";
    //language=sql
    public static final String GET_TEACHER_FIND_BY_NATIONAL_CODE = "SELECT * FROM teachers WHERE national_code = ?";
    //language=sql
    public static final String UPDATE_TEACHER_DATA = "UPDATE teachers SET first_name =? ,last_name=? WHERE national_code = ?";
    //language=sql
    public static final String GET_TEACHER_BY_ID_NATIONAL_CODE = "select *\n" + "from teachers\n" + "where teacher_id = ? and national_code = ?";
    //language=sql
    public static final String GET_USER_STUDENT="select s.student_id,concat( s.first_name,' ' ,s.last_name) as full_name, s.national_code, cs.score from teachers t join courses_students cs on t.course_id = cs.course_id join students s on cs.student_id = s.student_id where t.teacher_id = ? ";
    //language=sql
    public static final String GET_ADD_SCORE="UPDATE courses_students SET score = ? WHERE student_id = ? and course_id = ?";

    //******************************************************************************************************************************************

    //language=sql
    public static final String ADD_NEW_COURSE_DATA = "INSERT INTO courses (course_title, course_unit) VALUES (?,?)";
    //language=sql
    public static final String REMOVE_COURSE_DATA = "DELETE FROM courses WHERE course_id = ?";
    //language=sql
    public static final String GET_COURSE_FIND_BY_TITLE = "SELECT * FROM courses WHERE course_title = ?";
    //language=sql
    public static final String GET_ALL_COURSE = "SELECT * FROM courses";
    //language=sql
    public static final String UPDATE_COURSE_DATA = "UPDATE courses SET course_title = ?,course_unit=? WHERE course_id = ?";
    //language=sql
    public static final String GET_ALL_COURSE_DTO = "select c.course_title, c.course_unit, concat(t.first_name, ' ' , t.last_name) as teacherName, e.date, e.time from courses c join teachers t on c.course_id = t.course_id join exams e on c.course_id = e.course_id";
    //language=sql
    public static final String REMOVE_EXAM_COURSE = "DELETE FROM exams WHERE course_id = ?";
    //language=sql
    public static final String REMOVE_COURSE_STUDENT_COURSE = "DELETE FROM courses_students WHERE course_id = ?";


    //******************************************************************************************************************************************

    //language=sql
    public static final String ADD_NEW_EXAM_DATA = "INSERT INTO exams (exam_name,date,time,course_id) VALUES (?,?,?,?)";
    //language=sql
    public static final String REMOVE_EXAM_DATA = "DELETE FROM exams WHERE exam_id = ?";
    //language=sql
    public static final String GET_EXAM_FIND_BY_NAME = "SELECT * FROM exams WHERE exam_name = ?";
    //language=sql
    public static final String GET_ALL_EXAM = "SELECT * FROM exams";
    //language=sql
    public static final String UPDATE_EXAM_DATA = "UPDATE exams SET exam_name = ?,date = ?,time = ? WHERE exam_id = ?";
    //******************************************************************************************************************************************
    //language=sql
    public static final String ADMIN_USER_AND_PASS = "select * from admins where username = ? and password = ?";

}

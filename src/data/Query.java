package data;

public class Query {
    //language=sql
    public static final String ADD_STUDENT_DATA = "INSERT INTO students (first_name, last_name, national_code) VALUES (?,?,?)";
    //language=sql
    public static final String GET_ALL_STUDENT_QUERY = "SELECT * FROM students ";
    //language=sql
    public static final String GET_COUNT_OF_STUDENT = "select  count(*) from students ";
    //language=sql
    public static final String REMOVE_STUDENTS_DATA = "DELETE FROM students WHERE student_id = ?";
    //language=sql
    public static final String GET_STUDENT_FIND_BY_NATIONAL_CODE = "SELECT * FROM students WHERE national_code = ?";
    //language=sql
    public static final String UPDATE_STUDENT_DATA = "UPDATE students SET first_name =? ,last_name=? WHERE national_code = ?";

    //******************************************************************************************************************************************

    //language=sql
    public static final String GET_ALL_TEACHER_QUERY = "select * from teachers";
    //language=sql
    public static final String GET_COUNT_OF_TEACHER = "select  count(*) from teachers";
    //language=sql
    public static final String ADD_TEACHER_DATA = "INSERT INTO teachers (first_name, last_name, national_code) VALUES (?,?,?)";
    //language=sql
    public static final String REMOVE_TEACHER_DATA = "DELETE FROM teachers WHERE teacher_id = ?";
    //language=sql
    public static final String GET_TEACHER_FIND_BY_NATIONAL_CODE = "SELECT * FROM teachers WHERE national_code = ?";
    //language=sql
    public static final String UPDATE_TEACHER_DATA = "UPDATE teachers SET first_name =? ,last_name=? WHERE national_code = ?";


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


    //******************************************************************************************************************************************

    //language=sql
    public static final String ADD_NEW_EXAM_DATA="INSERT INTO exams (exam_name,date,time) VALUES (?,date ?,timestamptz ?)";

}

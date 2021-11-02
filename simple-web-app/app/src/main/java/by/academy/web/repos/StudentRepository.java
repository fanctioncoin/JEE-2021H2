package by.academy.web.repos;

import by.academy.web.model.CredUser;
import by.academy.web.model.Student;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends AbstractRepository<Student> implements StudentInterfaceRepository{

    private static final String SELECT_FROM_STUDENT_ALL = " select u.id u_id, u.login u_login, u.password u_password, " +
            "u.role u_role, " +
            "s.id s_id, s.name s_name, s.age s_age, s.name_group s_name_group, s.topic1, s.topic2, s.topic3, s.topic4 " +
            "from usr u " +
            "join student s " +
            "on s.id_usr = u.id";

    private static final String ONE_STUDENT_FILTER = " where u.id = ?";

    private static final String FIND_STUDENT_BY_ID = SELECT_FROM_STUDENT_ALL + ONE_STUDENT_FILTER;

    //language=SQL
    private static final String INSERT_STUDENT_SQL = "insert into student (, salary) values (?, ?) returning id";
    //language=SQL
    private static final String UPDATE_STUDENT_SQL = "update usr u set login = ?, password = ?," +
            " role = ?" + ONE_STUDENT_FILTER;

    //language=SQL
    private static final String UPDATE_STUDENT_OTHER_SQL = "update student set name = ?," +
            " age = ?, name_group = ?, topic1 = ?, topic2 = ?, topic3 = ?, topic4 = ? where id_usr = ?";


    //language=SQL
    private static final String DELETE_STUDENT_BY_ID = "delete from usr u" + ONE_STUDENT_FILTER;




    private static volatile StudentRepository instance;

    private final DataSource dataSource;


    public StudentRepository(DataSource dataSource) {
        super(dataSource);
        this.dataSource = dataSource;
    }

    public static StudentRepository getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (CoachRepository.class) {
                if (instance == null) {
                    instance = new StudentRepository(dataSource);
                }
            }
        }
        return instance;
    }



    @Override
    protected String selectAllFields() {
        return SELECT_FROM_STUDENT_ALL;
    }

    @Override
    protected String findById() {
        return FIND_STUDENT_BY_ID;
    }

    @Override
    protected String insertSql() {
        return INSERT_STUDENT_SQL;
    }

    @Override
    protected String insertSqlOther() {
        return null;
    }

    @Override
    protected String updateSql() {
        return UPDATE_STUDENT_SQL;
    }

    @Override
    protected String updateOtherSql() {
        return UPDATE_STUDENT_OTHER_SQL;
    }

    @Override
    protected String deleteSql() {
        return DELETE_STUDENT_BY_ID;
    }

    @Override
    protected List<Student> resultSetToPerson(ResultSet rs) throws SQLException {

        List<Student> result = new ArrayList<>();
        List<String> marks;
        while (rs.next()) {
            int uId = rs.getInt("u_id");
            marks =new ArrayList<>();
            marks.add(rs.getString("topic1"));
            marks.add(rs.getString("topic2"));
            marks.add(rs.getString("topic3"));
            marks.add(rs.getString("topic4"));
            result.add(new Student()
                    .withId(uId)
                    .withCredUser(
                            new CredUser()
                                    .withLogin(rs.getString("u_login"))
                                    .withPassword(rs.getString("u_password"))
                                    .withRoles(rs.getString("u_role")))
                    .withName(rs.getString("s_name"))
                    .withAge(rs.getInt("s_age"))
                    .withGroupName(rs.getString("s_name_group"))
                    .withMarks(marks));
        }
        return result.isEmpty() ? new ArrayList<>() : result;
    }

    @Override
    protected void insertLogic(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
    }

    @Override
    protected void insertLogicOther(Student person, PreparedStatement ps) throws SQLException {

    }

    @Override
    protected void updateLogic(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getCredUser().getLogin());
        ps.setString(2, student.getCredUser().getPassword());
        ps.setString(3, student.getCredUser().getRoles());
    }

    @Override
    protected void updateLogicOther(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getGroupName());
        ps.setString(4, student.getMarks().get(0));
        ps.setString(5, student.getMarks().get(1));
        ps.setString(6, student.getMarks().get(2));
        ps.setString(7, student.getMarks().get(3));
        ps.setInt(8, student.getId());
    }
}

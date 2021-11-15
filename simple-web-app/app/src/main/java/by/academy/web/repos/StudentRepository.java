package by.academy.web.repos;

import by.academy.web.model.Band;
import by.academy.web.model.Coach;
import by.academy.web.model.CredUser;
import by.academy.web.model.Student;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StudentRepository extends AbstractRepository<Student> implements StudentInterfaceRepository{
    //language=SQL
    private static final String SELECT_FROM_STUDENT_ALL = " select u.id u_id, u.login u_login, u.password u_password, " +
            "u.role u_role, " +
            "s.id s_id, s.name s_name, s.age s_age, s.marks1, s.marks2, s.marks3, s.marks4, s.marks5, " +
            "b.name b_name, b.disciplines1, b.disciplines2, b.disciplines3, b.disciplines4, b.disciplines5, " +
            "c.id c_id, c.name c_name, c.age c_age, c.salary c_salary " +
            "from usr u " +
            "join student s " +
            "on s.id_usr = u.id "+
            "join band b " +
            "on s.id_band = b.id " +
            "join coach c " +
            "on b.id_coach = c.id"
            ;

    private static final String ONE_STUDENT_FILTER = " where u.id = ?";

    private static final String FIND_STUDENT_BY_ID = SELECT_FROM_STUDENT_ALL + ONE_STUDENT_FILTER;

    //language=SQL
    private static final String INSERT_STUDENT_SQL = "insert into student ( salary) values (?, ?) returning id";
    //language=SQL
    private static final String UPDATE_STUDENT_SQL = "update usr u set login = ?, password = ?," +
            " role = ?" + ONE_STUDENT_FILTER;

    //language=SQL
    private static final String UPDATE_STUDENT_OTHER_SQL = "update student set name = ?," +
            " age = ?, marks1 = ?, marks2 = ?, marks3 = ?, marks4 = ? where id_usr = ?";

    //language=SQL
    private static final String UPDATE_STUDENT_OTHER_1_SQL = "update band set name = ?," +
            "  disciplines1 = ?, disciplines2 = ?, disciplines3 = ?, disciplines4 = ? where id_coach = ?";


    //language=SQL
    private static final String DELETE_STUDENT_BY_ID = "delete from usr u" + ONE_STUDENT_FILTER;
    private static final String U_ID = "u_id";
    private static final String U_LOGIN = "u_login";
    private static final String U_PASSWORD = "u_password";
    private static final String U_ROLE = "u_role";
    private static final String S_NAME = "s_name";
    private static final String S_AGE = "s_age";
    private static final String B_NAME = "b_name";
    private static final String C_SALARY = "c_salary";
    private static final String C_AGE = "c_age";
    private static final String C_NAME = "c_name";
    private static final String C_ID = "c_id";


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
    protected String updateOther1Sql() {
        return UPDATE_STUDENT_OTHER_1_SQL;
    }

    @Override
    protected String deleteSql() {
        return DELETE_STUDENT_BY_ID;
    }

    @Override
    protected List<Student> resultSetToPerson(ResultSet rs) throws SQLException {

        List<Student> result = new ArrayList<>();
        List<String> disciplines = Arrays.asList("disciplines1","disciplines2","disciplines3","disciplines4","disciplines5");
        List<String> marks = Arrays.asList("marks1","marks2","marks3","marks4","marks5");
        while (rs.next()) {
            int uId = rs.getInt(U_ID);
            List<String> checkMarks=checkOnNull(rs, marks);
            List<String> checkDisciplines=checkOnNull(rs,disciplines);
            result.add(new Student()
                    .withId(uId)
                    .withCredUser(
                            new CredUser()
                                    .withLogin(rs.getString(U_LOGIN))
                                    .withPassword(rs.getString(U_PASSWORD))
                                    .withRole(rs.getString(U_ROLE)))
                    .withName(rs.getString(S_NAME))
                    .withAge(rs.getInt(S_AGE))
                    .withBand(
                            new Band()
                                    .withName(rs.getString(B_NAME))
                                    .withCoach(
                                            new Coach()
                                            .withId(rs.getInt(C_ID))
                                            .withName(rs.getString(C_NAME))
                                            .withAge(rs.getInt(C_AGE))
                                            .withSalary(rs.getInt(C_SALARY)))
                                    .withDisciplines(checkDisciplines))
                    .withMarks(checkMarks));
        }
        return result.isEmpty() ? new ArrayList<>() : result;
    }

    private List<String> checkOnNull(ResultSet rs, List<String> list) throws SQLException {
        List<String> checkList =new ArrayList<>();
        for(String s : list){
           String result = rs.getString(s);
            if(result!=null){
                checkList.add(result);
            }
        }
        return checkList;
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
        ps.setString(3, student.getCredUser().getRole());
    }

    @Override
    protected void updateLogicOther(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getMarks().get(0));
        ps.setString(4, student.getMarks().get(1));
        ps.setString(5, student.getMarks().get(2));
        ps.setString(6, student.getMarks().get(3));
        ps.setInt(7, student.getId());
    }

    @Override
    protected void updateLogicOther1(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getBand().getName());
        ps.setString(2, student.getBand().getDisciplines().get(0));
        ps.setString(3, student.getBand().getDisciplines().get(1));
        ps.setString(4, student.getBand().getDisciplines().get(2));
        ps.setString(5, student.getBand().getDisciplines().get(3));
        ps.setInt(6, student.getBand().getCoach().getId());
    }
}

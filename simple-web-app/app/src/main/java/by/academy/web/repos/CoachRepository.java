package by.academy.web.repos;

import by.academy.web.model.Coach;
import by.academy.web.model.CredUser;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CoachRepository extends AbstractRepository<Coach> implements CoachInterfaceRepository{

    //language=SQL
    private static final String SELECT_FROM_COACH_ALL = " select u.id u_id, u.login u_login," +
            " u.password u_password, u.role u_role," +
            " c.id c_id, c.name c_name, c.age c_age, c.salary c_salary" +
            " from usr u" +
            " join coach c" +
            " on c.id_usr =u.id";

    private static final String ONE_COACH_FILTER = " where u.id = ?";

    private static final String FIND_COACH_BY_ID = SELECT_FROM_COACH_ALL + ONE_COACH_FILTER;

    //language=SQL
    private static final String INSERT_COACH_SQL = "insert into usr (login, password, role) values (?, ?, ?) returning id";

    //language=SQL
    private static final String INSERT_COACH_OTHER_SQL = "insert into coach  (name, age, salary, id_usr) values (?, ?, ?, ?) returning id_usr";


    //language=SQL
    private static final String UPDATE_COACH_SQL = "update usr u set login = ?, password = ?," +
            " role = ?" + ONE_COACH_FILTER;
    //language=SQL
    private static final String UPDATE_COACH_USER_SQL = "update coach  set name = ?," +
            " age = ?, salary = ? where id_usr = ?";

    //language=SQL
    private static final String DELETE_COACH_BY_ID = "delete from usr u" + ONE_COACH_FILTER;
    private static final String U_ID = "u_id";
    private static final String U_LOGIN = "u_login";
    private static final String U_PASSWORD = "u_password";
    private static final String U_ROLE = "u_role";
    private static final String C_NAME = "c_name";
    private static final String C_AGE = "c_age";
    private static final String C_SALARY = "c_salary";


    private static volatile CoachRepository instance;

    private final DataSource dataSource;

    private CoachRepository(DataSource dataSource) {
        super(dataSource);
        this.dataSource = dataSource;
    }

    public static CoachRepository getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (CoachRepository.class) {
                if (instance == null) {
                    instance = new CoachRepository(dataSource);
                }
            }
        }
        return instance;
    }
    @Override
    protected String selectAllFields() {
        return SELECT_FROM_COACH_ALL ;
    }

    @Override
    protected String findById() {
        return FIND_COACH_BY_ID;
    }

    @Override
    protected String insertSql() {
        return INSERT_COACH_SQL;
    }

    @Override
    protected String insertSqlOther() {
        return INSERT_COACH_OTHER_SQL;
    }

    @Override
    protected String updateSql() {
        return UPDATE_COACH_SQL;
    }

    @Override
    protected String updateOtherSql() {
        return UPDATE_COACH_USER_SQL;
    }

    @Override
    protected String updateOther1Sql() {
        return null;
    }

    @Override
    protected String deleteSql() {
        return DELETE_COACH_BY_ID;
    }

    @Override
    protected void insertLogic(Coach coach, PreparedStatement ps) throws SQLException {
        ps.setString(1, coach.getCredUser().getLogin());
        ps.setString(2, coach.getCredUser().getPassword());
        ps.setString(3, coach.getCredUser().getRole());
    }
    @Override
    protected void insertLogicOther(Coach coach, PreparedStatement ps) throws SQLException {
        ps.setString(1, coach.getName());
        ps.setInt(2, coach.getAge());
        ps.setInt(3, coach.getSalary());
        ps.setInt(4,coach.getId());
    }

    @Override
    protected void updateLogic(Coach coach, PreparedStatement ps) throws SQLException {
        ps.setString(1, coach.getCredUser().getLogin());
        ps.setString(2, coach.getCredUser().getPassword());
        ps.setString(3, coach.getCredUser().getRole());
    }

    @Override
    protected void updateLogicOther(Coach coach, PreparedStatement ps) throws SQLException {
        ps.setString(1, coach.getName());
        ps.setInt(2, coach.getAge());
        ps.setInt(3, coach.getSalary());
        ps.setInt(4, coach.getId());
    }

    @Override
    protected void updateLogicOther1(Coach person, PreparedStatement ps) throws SQLException {

    }


    @Override
    protected List<Coach> resultSetToPerson(ResultSet rs) throws SQLException {
        List<Coach> result = new ArrayList<>();
            while (rs.next()) {
                int uId=rs.getInt(U_ID);
                result.add(new Coach()
                        .withId(uId)
                        .withCredUser(
                                new CredUser()
                                        .withLogin(rs.getString(U_LOGIN))
                                        .withPassword(rs.getString(U_PASSWORD))
                                        .withRole(rs.getString(U_ROLE)))
                        .withName(rs.getString(C_NAME))
                        .withAge(rs.getInt(C_AGE))
                        .withSalary(rs.getInt(C_SALARY))); }

        return result.isEmpty() ? new ArrayList<>() : result;
    }
    }

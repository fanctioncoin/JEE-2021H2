package by.academy.web.repos;

import by.academy.web.model.*;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class AdminRepository extends AbstractRepository<Admin> implements AdminInterfaceRepository  {

    private static final String SELECT_FROM_ADMIN_ALL =" select u.id u_id, u.login u_login," +
            " u.password u_password, u.role u_role," +
            " a.id a_id, a.name a_name, a.age a_age" +
            " from usr u" +
            " join adm a" +
            " on a.id_usr = u.id";
    private static final String U_ID = "u_id";
    private static final String U_LOGIN = "u_login";
    private static final String U_PASSWORD = "u_password";
    private static final String U_ROLE = "u_role";
    private static final String A_NAME = "a_name";
    private static final String A_AGE = "a_age";

    private static volatile AdminRepository instance;
    private final DataSource dataSource;

    private AdminRepository(DataSource dataSource) {
        super(dataSource);
        this.dataSource = dataSource;
    }

    public static AdminRepository getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (AdminRepository.class) {
                if (instance == null) {
                    instance = new AdminRepository(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    protected String selectAllFields() {
        return SELECT_FROM_ADMIN_ALL;
    }

    @Override
    protected String findById() {
        return null;
    }

    @Override
    protected String insertSql() {
        return null;
    }

    @Override
    protected String insertSqlOther() {
        return null;
    }

    @Override
    protected String updateSql() {
        return null;
    }

    @Override
    protected String updateOtherSql() {
        return null;
    }

    @Override
    protected String updateOther1Sql() {
        return null;
    }

    @Override
    protected String deleteSql() {
        return null;
    }

    @Override
    protected List<Admin> resultSetToPerson(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    protected void insertLogic(Admin person, PreparedStatement ps) throws SQLException {

    }

    @Override
    protected void insertLogicOther(Admin person, PreparedStatement ps) throws SQLException {

    }

    @Override
    protected void updateLogic(Admin person, PreparedStatement ps) throws SQLException {

    }

    @Override
    protected void updateLogicOther(Admin person, PreparedStatement ps) throws SQLException {

    }

    @Override
    protected void updateLogicOther1(Admin person, PreparedStatement ps) throws SQLException {

    }

    @Override
    public List<Admin> findAll() {
        List<Admin> result = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps2 = con.prepareStatement(SELECT_FROM_ADMIN_ALL);
             ResultSet rs2 = ps2.executeQuery()) {

            while (rs2.next()) {
                int uId = rs2.getInt(U_ID);
                result.add(new Admin()
                        .withId(uId)
                        .withCredUser(
                                new CredUser()
                                        .withLogin(rs2.getString(U_LOGIN))
                                        .withPassword(rs2.getString(U_PASSWORD))
                                        .withRole(rs2.getString(U_ROLE)))
                        .withName(rs2.getString(A_NAME))
                        .withAge(rs2.getInt(A_AGE)));

            }

            } catch(SQLException e){
                log.error(e.getMessage());
            }
            return result;
        }

    @Override
    public Optional<Admin> find(int id) {
        return Optional.empty();
    }

    @Override
    public Admin save(Admin admin) {
        return null;
    }


    @Override
    public Optional<Admin> remove(Admin person) {
        return Optional.empty();
    }
}

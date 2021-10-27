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
import java.util.Map;
import java.util.Optional;

@Slf4j
public class PersonRepositoryPostgres implements PersonRepository {
    private static final String SELECT_FROM_COACH_ALL = " select u.id u_id, u.login u_login, u.password u_password," +
            " ur.role ur_role," +
            " c.id c_id, c.name c_name, c.age c_age, c.salary c_salary " +
            "from usr u " +
            "join user_role ur " +
            "on ur.user_id = u.id " +
            "join coach c " +
            "on c.id_usr =u.id";
    private static final String SELECT_FROM_STUDENT_ALL = " select u.id u_id, u.login u_login, u.password u_password, " +
            "ur.role ur_role, " +
            "s.id s_id, s.name s_name, s.age s_age, s.name_group s_name_group, s.topic1, s.topic2, s.topic3, s.topic4 " +
            "from usr u " +
            "join user_role ur " +
            "on ur.user_id = u.id " +
            "join student s " +
            "on s.id_usr = u.id";
    private static volatile PersonRepositoryPostgres instance;
    private final DataSource dataSource;

    private PersonRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static PersonRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (PersonRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new PersonRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }


    @Override
    public Map<Integer, Person> findAllMap() {
        return null;
    }

    @Override
    public List<Person> findAll() {
        List<Person> result = new ArrayList<>();
        List<String> marks = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_FROM_COACH_ALL);
             PreparedStatement ps1 =con.prepareStatement(SELECT_FROM_STUDENT_ALL);
             ResultSet rs = ps.executeQuery();
             ResultSet rs1 = ps1.executeQuery()) {

            while (rs.next()) {
                int uId=rs.getInt("u_id");
                result.add(new Coach()
                        .withId(uId)
                        .withCredUser(
                                new CredUser()
                                        .withLogin(rs.getString("u_login"))
                                        .withPassword(rs.getString("u_password"))
                                        .withRoles(rs.getString("ur_role")))
                        .withName(rs.getString("c_name"))
                        .withAge(rs.getInt("c_age"))
                        .withSalary(rs.getInt("c_salary"))); }

            while (rs1.next()) {
                int uId=rs1.getInt("u_id");
                marks.clear();
                marks.add(rs1.getString("topic1"));
                marks.add(rs1.getString("topic2"));
                marks.add(rs1.getString("topic3"));
                marks.add(rs1.getString("topic4"));
                   result.add(new Student()
                        .withId(uId)
                        .withCredUser(
                                new CredUser()
                                        .withLogin(rs1.getString("u_login"))
                                        .withPassword(rs1.getString("u_password"))
                                        .withRoles(rs1.getString("ur_role")))
                        .withName(rs1.getString("s_name"))
                        .withAge(rs1.getInt("s_age"))
                        .withGroupName(rs1.getString("s_name_group"))
                        .withMarks(marks));

        }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public Optional<Person> find(int id) {
        return Optional.empty();
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    @Override
    public Optional<Person> remove(Person person) {
        return Optional.empty();
    }
}

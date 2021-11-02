package by.academy.web.repos;

import by.academy.web.model.Person;
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
public abstract class AbstractRepository< T extends Person> implements ARepository<T> {
    private static final int POSITION_ID = 1;
    private final DataSource dataSource;

    protected AbstractRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected abstract String selectAllFields();

    protected abstract String findById();

    protected abstract String insertSql();

    protected abstract String insertSqlOther();

    protected abstract String updateSql();

    protected abstract String updateOtherSql();

    protected abstract String deleteSql();

    protected abstract List<T> resultSetToPerson(ResultSet rs) throws SQLException;

    protected abstract void insertLogic(T person, PreparedStatement ps) throws SQLException;

    protected abstract void insertLogicOther(T person, PreparedStatement ps) throws SQLException;

    protected abstract void updateLogic(T person, PreparedStatement ps) throws SQLException;

    protected abstract void updateLogicOther(T person, PreparedStatement ps) throws SQLException;


    @Override
    public List<T> findAll() {
        List<T> result= new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(selectAllFields());
             ResultSet rs = ps.executeQuery()) {
            result = resultSetToPerson(rs);
        }catch (NullPointerException e){
        log.error(e.getMessage());

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public Optional<T> find(int id) {
        List<T> result = null;
        ResultSet rs = null;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(findById())) {
            ps.setInt(POSITION_ID, id);
            rs = ps.executeQuery();
            result = resultSetToPerson(rs);
        } catch (SQLException e) {
            log.error(e.getMessage());
        } finally {
            closeQuietly(rs);
        }
        return result.stream().findAny();
    }

    @Override
    public T save(T person) {
        return person.getId() == null ? insert(person) : update(person);
    }

    private T insert(T person) {
        try (Connection con = dataSource.getConnection()) {

            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(insertSql());
            insertLogic(person, ps);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                person.setId(rs.getInt(POSITION_ID));
            }
            // 2 транзакция
            PreparedStatement ps1 = con.prepareStatement(insertSqlOther());
            insertLogicOther(person, ps1);
            ps1.executeQuery();
            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return person;
    }

        private T update (T person){

            try (Connection con = dataSource.getConnection()) {
                con.setAutoCommit(false);
                //Первая транзация вставка в таблицу usr
                PreparedStatement ps = con.prepareStatement(updateSql());
                updateLogic(person, ps);
                ps.setInt(4, person.getId());
                ps.executeUpdate();

                //Вторая транзакция вставка в таблицу <T>
                PreparedStatement ps1 = con.prepareStatement(updateOtherSql());
                updateLogicOther(person, ps1);
                ps1.executeUpdate();
                con.commit();
                con.setAutoCommit(true);
                ps.executeUpdate();

            } catch (SQLException e) {
                log.error(e.getMessage());
            }
            return person;
        }


        @Override
        public Optional<T> remove (T person){
            try (Connection con = dataSource.getConnection();
                 PreparedStatement ps = con.prepareStatement(deleteSql())) {
                ps.setInt(1, person.getId());
                if (ps.executeUpdate() > 0) {
                    return Optional.of(person);
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
            return Optional.empty();
        }

        private static void closeQuietly (AutoCloseable closeable){
            if (closeable == null) {
                return;
            }
            try {
                closeable.close();
            } catch (Exception e) {
                log.error("Couldn't close {}", closeable);
            }
        }
    }

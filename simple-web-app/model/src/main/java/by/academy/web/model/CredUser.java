package by.academy.web.model;

import java.util.Objects;

public class CredUser {
    private int id;
    private String login;
    private String password;
    private Role role;

    public CredUser(int id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CredUser{" +
                "idUser=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredUser credUser = (CredUser) o;
        return id == credUser.id && Objects.equals(login, credUser.login) && Objects.equals(password, credUser.password) && role == credUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role);
    }
}

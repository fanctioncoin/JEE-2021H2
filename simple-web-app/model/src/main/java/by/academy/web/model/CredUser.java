package by.academy.web.model;

import lombok.*;

import java.util.Objects;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredUser extends Entity {

    private String login;
    private String password;
    private Role role;

    public CredUser(int id, String login, String password, Role role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }
    @Override
    public CredUser withId(Integer id) {
        setId(id);
        return this;
    }

    public CredUser withLogin(String login) {
        setLogin(login);
        return this;
    }

    public CredUser withPassword(String password) {
        setPassword(password);
        return this;
    }

    public CredUser withRole(Role role) {
        setRole(role);
        return this;
    }
}

//    @Override
//    public String toString() {
//        return "CredUser{" +
//                "idUser=" + super.getId() +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                ", role=" + role +
//                '}';
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CredUser credUser = (CredUser) o;
//        return id == credUser.id && Objects.equals(login, credUser.login) && Objects.equals(password, credUser.password) && role == credUser.role;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, login, password, role);
//    }
//}

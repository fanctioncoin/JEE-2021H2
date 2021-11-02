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
    private String roles;

    public CredUser(Integer id, String login, String password, Role role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public CredUser(Integer id, String login, String password, String roles) {
        super(id);
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public CredUser(String login, String password, String roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
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
    public CredUser withRoles(String roles){
        setRoles(roles);
        return this;
    }
}


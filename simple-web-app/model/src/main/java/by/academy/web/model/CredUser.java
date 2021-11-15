package by.academy.web.model;

import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity( name = "usr")
public class CredUser extends Entity {

    private String login;
    private String password;

//    @Transient
//    private Role role1;

    private String role;

//    public CredUser(Integer id, String login, String password, Role role1) {
//        super(id);
//        this.login = login;
//        this.password = password;
//        this.role1 = role1;
//    }



//    public CredUser(String login, String password, String role) {
//        this.login = login;
//        this.password = password;
//        this.role = role;
//    }

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

    public CredUser withRole(String role){
        setRole(role);
        return this;
    }
}


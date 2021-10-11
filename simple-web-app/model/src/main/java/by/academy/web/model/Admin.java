package by.academy.web.model;

public class Admin extends Person  {

    public Admin() {
    }

    public Admin(CredUser credUser, int id, String name, int age) {
        super(credUser, id, name, age);
    }

    @Override
    public String getInfo() {
        return null;
    }
}

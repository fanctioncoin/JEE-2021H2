package by.academy.web;



import by.academy.web.model.*;
import by.academy.web.repos.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class Start {
    public static void main(String[] args) {
//        Configuration cfg = new Configuration().configure();
//        SessionFactory sessionFactory = cfg.buildSessionFactory();

        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//
//
//        TypedQuery<Student> query = em.createQuery("from Student ", Student.class);
//        query.getResultList().forEach(Start::printWithPrefix);
        StringBuilder stringBuilder =new StringBuilder();
        String marks ="marks";
        for(int i=0; i<5; i++){
            String result =marks+stringBuilder.append(i).toString();
            System.out.println(result);
            stringBuilder.delete(0,stringBuilder.length());
        }

//        Coach coach = em.find(Coach.class, 20);
////        CredUser credUser =em.find(CredUser.class,1);
////        printWithPrefix(credUser);
//        printWithPrefix(coach);
//
//        em.remove(coach);

//       Coach coach1 = new Coach()
//                .withCredUser(
//                        new CredUser()
//                                .withLogin("sasasas")
//                                .withPassword("123")
//                                .withRole("COACH"))
//                .withName("Awecy")
//                .withAge(20)
//                .withSalary(2000);
//
//        em.persist(coach1);


        //One-To-Many
//        Department department = em.find(Department.class, 1);
//        printWithPrefix(department);


        //One-To-One
//        Employee employee = em.find(Employee.class, 1);

//        printWithPrefix(employee);

//        em.remove(title);

//        Employee newEmployee = new Employee()
//                .withName("Джон")
//                .withTitle(new Title()
//                        .withName("CTO"));
//        em.persist(newEmployee);
//
//        TypedQuery<Employee> employeesQuery = em.createQuery("from Employee", Employee.class);
//        List<Employee> employees = employeesQuery.getResultList();
//        employees.stream().forEach(System.out::println);



//        Title managerTitle = new Title().withName("Менеджер");
//        em.persist(managerTitle);
//
//        TypedQuery<Title> oneTitleQuery = em.createQuery("from Title where name = 'Менеджер'", Title.class);
//        Title title = oneTitleQuery.getSingleResult();

//        Employee title = em.find(Employee.class, 1);

//        System.out.println("!!!" + title);

        tx.commit();
        em.close();


//        sessionFactory.close();

//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        Title title = session.find(Title.class, 1);
//        System.out.println("!!!" + title);
//
//        tx.commit();
//        session.close();
    }

    private static void printWithPrefix(Object obj) {
        System.out.println("!!!" + obj);
    }
}

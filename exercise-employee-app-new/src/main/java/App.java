import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main( String[] args ) {

        System.out.println("Project started....");

        // Create Configuration Object
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create the factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        Employee employee = new Employee();
//        employee.setId(6);
        employee.setName("abcdedfg");
        employee.setEmail("abcdedfg@gmail.com");


        // save the employee
        session.save(employee);

        // create cars
//        Cars car = new Cars();
//        car.setId(1);
//        car.setType("Sports");
//        car.

//        Employee employee = session.get(Employee.class, 1);
//        System.out.println(employee);

        // commit the transaction
        t.commit();
        // close the connection
        session.close();
    }
}

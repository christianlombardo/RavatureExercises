import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class EmployeeDao implements DAO<Employee> {

    private static EmployeeDao daoEmployee;
    Configuration cfg;
    SessionFactory factory;

    EmployeeDao() {

        // Create Configuration Object
        cfg = new Configuration();

        // read the configuration and load the
        cfg.configure("hibernate.cfg.xml");

        // create the factory
        factory = cfg.buildSessionFactory();
    }


    @Override
    public Employee readById(Employee obj) {
        return null;
    }


    @Override
    public List<Employee> readAll() {

        // open the session
        Session session = factory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        String hql = "FROM Employee";
        Query query = session.createQuery(hql);
        List<Employee> results = query.list();

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

        return results;
    }


    @Override
    public void update(Employee employee) {
        // open the session
        Session session = factory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        // hibernate update employee record
        session.update(employee);

        // commit the transaction
        t.commit();

        // close the connection
        session.close();
    }


    @Override
    public void delete(Employee employee) {
        // open the session
        Session session = factory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        // hibernate delete
        session.delete(employee);

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

    }


    @Override
    public void insert(Employee employee) {
        // open the session
        Session session = factory.openSession();

        // begin the transaction
        Transaction t = session.beginTransaction();

        // hibernate save to the database
        session.save(employee);

        // commit the transaction
        t.commit();

        // close the connection
        session.close();

    }

}

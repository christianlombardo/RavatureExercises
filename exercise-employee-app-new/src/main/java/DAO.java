import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> {

    void insert(T obj);

    T readById(T obj);

    List<T> readAll();

    void update(T obj);

    void delete(T obj);


}

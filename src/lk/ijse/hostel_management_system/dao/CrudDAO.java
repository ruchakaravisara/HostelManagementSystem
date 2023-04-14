package lk.ijse.hostel_management_system.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    String save(T obj) throws Exception;
    void update(T obj) throws Exception;
    void delete(T obj) throws Exception;
    T getObject(String id) throws Exception;
    List<T>loadAll() throws Exception;
    String generateID() throws Exception;
}

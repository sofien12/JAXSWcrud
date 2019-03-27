package DAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DUONGHM
 */
public abstract class abstractModel<T> {

    private Class<T> entityClass;

    public abstractModel() {
    }

    public abstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
         session.getTransaction().begin();
        Query query = session.createQuery("FROM " + entityClass.getName());
        //System.out.println("================FROM " + entityClass.getName() + "=======================");
        List<T> lst = query.list();
        session.getTransaction().commit();
        session.close();
        return lst;
    }

    public List<T> getAll(String condition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        Query query = session.createQuery("FROM " + entityClass.getName() + " WHERE " + condition);
        //System.out.println("======FROM " + entityClass.getName()+ " WHERE "+condition+"======");
        List<T> lst = query.list();
        session.getTransaction().commit();
        session.close();
        return lst;
    }

    public List<T> createHQLQuery(String hqlQuery) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        Query query = session.createQuery(hqlQuery);
        //System.out.println("======FROM " + entityClass.getName()+ " WHERE "+condition+"======");
        List<T> lst = query.list();
        session.getTransaction().commit();
        session.close();
        return lst;
    }

    public List<T> search(String condition) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        Query query = session.createQuery("FROM " + entityClass.getName() + " WHERE " + condition);
        //System.out.println("======FROM " + entityClass.getName()+ " WHERE "+condition+"======");
        List<T> lst = query.list();
        session.getTransaction().commit();
        session.close();
        return lst;
    }

    public void add(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        try {            
            
            session.save(entity);
            session.getTransaction().commit();            
        } catch (Exception ex) {
        	session.getTransaction().rollback();            
            ex.printStackTrace();            
            
        }        
        session.close();
    }

    public void update(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();       
        try {
            
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {
        	session.getTransaction().rollback();
            ex.printStackTrace();  
            
        }        
        session.close();
    }

    public void delete(T entity)  {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();        
        try {
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {
        	session.getTransaction().rollback();
            ex.printStackTrace();  
           
        }        
        session.close();
    }
}
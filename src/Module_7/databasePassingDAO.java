package Module_7;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Module_7.databasePassing;
import Module_7.HibernateUtil;
/*
 * @Author Jancarlo Sevilla
 * This is the databasePassingDAO essentially interacts with the database while sending its parameters
 */

public class databasePassingDAO {

/*
 * This list essentially retrieves the parameters from mysql and pass them into a list containing databasePassing as its entity.
 * @return mysql parameters into list
 */
	public List<databasePassing> list() {
        Transaction tx = null;

		
		List <databasePassing> dPassing = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			tx = session.beginTransaction();
			
			dPassing = session.createQuery("FROM databasePassing").getResultList();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return dPassing;
	}
/*
 * deleteList deletes a list from mysql by the int id given from servlet
 * @return a list is deleted
 */
	   public void deleteList(int id) {

	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();

	            databasePassing dataPassing = session.get(databasePassing.class, id);
	            if (dataPassing != null) {
	                session.delete(dataPassing);
	                System.out.println("list has been deleted");
	            }

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	   /*
	    * savelist saves the list to mysql
	    * @return
	    */
	   public void savelist(databasePassing list) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(list);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	   
}

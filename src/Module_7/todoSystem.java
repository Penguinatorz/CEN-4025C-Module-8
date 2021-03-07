package Module_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * 
 * @author Jancarlo Sevilla todoSystem class this runs all the parameters needed
 *         to pass and retrieve todo items into an arraylist
 */
public class todoSystem {

	private ArrayList<String> todoList = new ArrayList<String>();
	private String addPassing;
	private databasePassing database = new databasePassing();

	/**
	 * 
	 * geToDo is a method just to check if the list is being added.
	 */
	public void getToDo() {
		System.out.println(todoList);
	}

	/**
	 * incrementToDo is just a simple method to differentiate added to-do item
	 * 
	 * @param todo is the passing String given from the todoInput class
	 * @return this method return an update String of the user input.
	 */
	public String incrementToDo(String todo) {
		addPassing = ">> ' " + todo + " '";
		return addPassing;
	}

	/**
	 * addToDo method is a simple method calling the incrementToDo adding in more
	 * items to the user inputted string
	 * 
	 * @param todo user input retrieve from todoInput class
	 * @return the update string
	 */
	public boolean addToDo(String todo) {
		return todoList.add(incrementToDo(todo));
	}

	/**
	 * deleteToDo is a simple method that deletes the inputted index
	 * 
	 * @param index is retrieved from todoInput
	 * @return deletes the inputted todolist
	 */
	public boolean deleteToDo(int index) {
		return todoList.remove(index) != null;
	}

	/**
	 * todoCheck makes use of the deleteToDo method and verifies if the retrieve
	 * user input is valid
	 * 
	 * @param index retrieved from todoInput class
	 * @return update on deleted index
	 */
	public boolean todoCheck(int index) {
		if (index >= 0 && index < todoList.size()) {
			deleteToDo(index);
			System.out.println("The item " + index + " of the to-do has been deleted");
			return true;
		} else {
			System.out.println("The to-do item list is empty or the entered to-do to delete is invalid");
			return false;
		}
	}

	/**
	 * todoView is a void method that simply checks if the todoList is empty and if
	 * not prints out each index in a loop.
	 */
	public void todoView() {
		if (todoList.isEmpty()) {
			System.out.println("The to-do item list is empty\n" + "Try adding an item.");
		} else {
			for (int i = 0; todoList.size() > i; i++) {
				System.out.println(todoList.get(i));
			}
		}
	}

	/*
	 * todoSave is a void method that passes the string parameters into the
	 * databasePassing class and in doing so makes the use of hibernate to store the
	 * parameters into a database.
	 */
	public void todoSave() {
		if (todoList.isEmpty()) {

		} else {
			for (int i = 0; todoList.size() > i; i++) {
				database.setList(todoList.get(i));
				Configuration con = new Configuration().configure().addAnnotatedClass(databasePassing.class);
				SessionFactory sf = con.buildSessionFactory();
				Session session = sf.openSession();
				Transaction tx = session.beginTransaction();
				session.save(database);
				tx.commit();
			}
			System.out.println("Saving Complete");
		}
	}

	public void listAll() {
		Configuration con = new Configuration().configure().addAnnotatedClass(databasePassing.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List databaseList = session.createQuery("FROM databasePassing").list();

			for (Iterator iterator = databaseList.iterator(); iterator.hasNext();) {
				databasePassing passing = (databasePassing) iterator.next();
				System.out.println("iD " + passing.getId());
				System.out.println("List: " + passing.getList());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void deleteDataList(Integer iD) {
		Configuration con = new Configuration().configure().addAnnotatedClass(databasePassing.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			databasePassing passing = (databasePassing) session.get(databasePassing.class, iD);
			session.delete(passing);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}

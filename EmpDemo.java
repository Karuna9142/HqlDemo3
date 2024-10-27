package com.demo1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmpDemo {
	
	public static void select_query()
	{
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		
		SessionFactory sf = c.buildSessionFactory();
		Session sess = sf.openSession();
		
		Transaction t = sess.beginTransaction();
		
		
		 //Select Command
		String hql = "from Employee";
		Query q = sess.createQuery(hql);
		List<Employee> emp = q.getResultList();
		
		System.out.println("Student List");
		for(Employee e:emp)
		{
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getAge());
		}
		
		t.commit();
		sess.close();
		
	}
	public static void where_clause()
	{
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		
		SessionFactory sf = c.buildSessionFactory();
		Session sess = sf.openSession();
		
		Transaction t = sess.beginTransaction();
		String hql = "select p.name from Employee p where p.age =22";
		Query q = sess.createQuery(hql);
		List<String>emplo = q.getResultList();
		System.out.println("employee List");
		
		for(String s:emplo)
		{
			System.out.println(s);
		}
		t.commit();
		sess.close();
	}
	public static void update_clause()
	{
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		
		SessionFactory sf = c.buildSessionFactory();
		Session sess = sf.openSession();
		
		Transaction t = sess.beginTransaction();
		/*
		String hql = "update Employee set name = :n where id = :i";
		Query q = sess.createQuery(hql);
		q.setParameter("n", "Anjali");
		q.setParameter("i", 101);
		
		int row = q.executeUpdate();
		System.out.println(row+ " Object is updated");
		*/
		String hql = "update Employee set age = :a where id = :k";
		Query q = sess.createQuery(hql);
		q.setParameter("a", 24);
		q.setParameter("k", 101);
		
		int row = q.executeUpdate();
		System.out.println(row+ " Object is updated");
		
		
		t.commit();
		sess.close();
	}

	public static void main(String[] args) {
		
		
		/*
		
		*/
		EmpDemo e1 = new EmpDemo();
		//e1.select_query();
		//e1.where_clause();
		e1.update_clause();
		
		
	}

}

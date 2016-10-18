package com.bridgelabz.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.ResponseElementModel;

@Repository("hibernateDao")
public class HibernateDao implements UserDao {
	
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	Session session;

	public void Save(ArrayList<ResponseElementModel> responseElementModelArrayList) {
		try{
			
			
			for (int i = 0; i < responseElementModelArrayList.size(); i++) {
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				
				System.out.println(responseElementModelArrayList.get(i));
				session.save(responseElementModelArrayList.get(i));
			/*	if (i % 20 == 0) { // Same as the JDBC batch size
									// flush a batch of inserts and release
									// memory:
					session.flush();
					session.clear();
				}*/
				tx.commit();
				session.close();
			}
			
		}
		catch(Exception e)
		{
			System.out.println("hello");
			e.printStackTrace();
		}
	}
}

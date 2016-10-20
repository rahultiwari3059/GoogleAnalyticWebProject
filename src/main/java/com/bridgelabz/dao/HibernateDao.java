package com.bridgelabz.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.AppOpenModel;
import com.bridgelabz.model.AppReOpenModel;
import com.bridgelabz.model.ResponseElementModel;

@Repository("hibernateDao")
public class HibernateDao implements UserDao {
	
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	Session session;

	public void allElementSave(ArrayList<ResponseElementModel> responseElementModelArrayList) {
		try{
		
			for (int i = 0; i < responseElementModelArrayList.size(); i++) {
				
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(responseElementModelArrayList.get(i));
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
		public void appOpenModelSave(ArrayList<AppOpenModel> appOpenModelArrayList) {
			try{
				
				
				for (int i = 0; i < appOpenModelArrayList.size(); i++) {
					Session session = sessionFactory.openSession();
					Transaction tx = session.beginTransaction();
					
					session.save(appOpenModelArrayList.get(i));
					if (i % 20 == 0) { // Same as the JDBC batch size
										// flush a batch of inserts and release
										// memory:
						session.flush();
						session.clear();
					}
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
		public void appReOpenModelSave(ArrayList<AppReOpenModel> appReOpenModelArrayList) {
			try{
				
				
				for (int i = 0; i < appReOpenModelArrayList.size(); i++) {
					Session session = sessionFactory.openSession();
					Transaction tx = session.beginTransaction();
					
					session.save(appReOpenModelArrayList.get(i));
					if (i % 20 == 0) { // Same as the JDBC batch size
										// flush a batch of inserts and release
										// memory:
						session.flush();
						session.clear();
					}
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
		public void Save(ArrayList<ResponseElementModel> responseElementModelArrayList) {
			// TODO Auto-generated method stub
			
		}
		
}

package org.service;
// Generated Jun 20, 2016 11:51:30 PM by Hibernate Tools 3.5.0.Final

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bean.MyVehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Home object for domain model class MyVehicle.
 * @see .MyVehicle
 * @author Hibernate Tools
 */

@Repository
@Service
public class MyVehicleService {

	private static final Log log = LogFactory.getLog(MyVehicleService.class);

	@Autowired
	private SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MyVehicle transientInstance) {
		log.debug("persisting MyVehicle instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MyVehicle persistentInstance) {
		log.debug("removing MyVehicle instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MyVehicle merge(MyVehicle detachedInstance) {
		log.debug("merging MyVehicle instance");
		try {
			MyVehicle result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MyVehicle findById(long id) {
		log.debug("getting MyVehicle instance with id: " + id);
		try {
			MyVehicle instance = entityManager.find(MyVehicle.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MyVehicle> findByUserID(long userID){
		log.debug("getting list of MyVehicle");
		List<MyVehicle> result = new ArrayList<MyVehicle>();
		try{
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			result = (List<MyVehicle>) session.createCriteria(MyVehicle.class).add(Restrictions.eq("user", userID)).list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<MyVehicle> saveMyVehicle(MyVehicle myvehicle){
		log.debug("getting list of MyVehicle");
		List<MyVehicle> result = new ArrayList<MyVehicle>();
		try{
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(myvehicle);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}	
}

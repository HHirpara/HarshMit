package org.service;
// default package
// Generated Jul 18, 2016 4:06:33 PM by Hibernate Tools 3.5.0.Final

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bean.OfferedRide;
import org.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Home object for domain model class OfferedRide.
 * @see .OfferedRide
 * @author Hibernate Tools
 */

@Repository
@Service
public class OfferedRideService {

	private static final Log log = LogFactory.getLog(OfferedRideService.class);

	@Autowired
	private SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	@PersistenceContext
	private EntityManager entityManager;
	
	public void persist(OfferedRide transientInstance) {
		System.out.println("in for call");
		log.debug("persisting OfferedRide instance"+transientInstance.toString());
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(OfferedRide persistentInstance) {
		log.debug("removing OfferedRide instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public OfferedRide merge(OfferedRide detachedInstance) {
		log.debug("merging OfferedRide instance");
		try {
			OfferedRide result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OfferedRide findById(long id) {
		log.debug("getting OfferedRide instance with id: " + id);
		OfferedRide offeredRide = new OfferedRide();
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			offeredRide = (OfferedRide) session.get(OfferedRide.class, id);
			tx.commit();
			log.debug("get successful");
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		return offeredRide;
	}

	 
	@SuppressWarnings("unchecked")
	public List<OfferedRide> findByUserID(long userID){
		
		List<OfferedRide> result = new ArrayList<OfferedRide>();
		try{
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			result = (List<OfferedRide>) session.createCriteria(OfferedRide.class).add(Restrictions.eq("user", userID)).list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}

	public String addMyRide(OfferedRide offeredRide){
		String result = "";
		try{
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(offeredRide);
			tx.commit();
			result = "success";
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	
	public OfferedRide saveRide(OfferedRide instance) {
		log.debug("saving User instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(instance);
			tx.commit();
			log.debug("saved successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}

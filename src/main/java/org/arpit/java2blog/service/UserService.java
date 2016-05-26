package org.arpit.java2blog.service;


import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.HashMap;

// Generated May 21, 2016 9:47:32 PM by Hibernate Tools 5.0.0.Alpha3

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.arpit.java2blog.bean.User;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * Home object for domain model class User.
 * @see .User
 * @author Hibernate Tools
 */

@Repository
@Service
public class UserService {

	private static final Log log = LogFactory.getLog(UserService.class);


	@Autowired
	private SessionFactory sessionFactory = new Configuration()/*.addFile("user.hbm.xml")*/.configure("hibernate.cfg.xml").buildSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Long id) {
		log.debug("getting User instance with id: " + id);
		try {
			
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			User user = (User) session.get(User.class, id);
			tx.commit();
			
			return user;
			
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) sessionFactory.getCurrentSession().createCriteria("User")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> findAll(Class clazz) {
		log.debug("finding User instance by example");
		try {

			List<User> users = new ArrayList<User>();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			System.out.println("ready....");
			users = session.createCriteria(User.class).list();
			tx.commit();
			return users;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
}

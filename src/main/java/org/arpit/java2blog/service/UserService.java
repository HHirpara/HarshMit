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
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Home object for domain model class User.
 * @see .User
 * @author Hibernate Tools
 */


public class UserService {

	private static final Log log = LogFactory.getLog(UserService.class);

	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	//new Configuration().configure().buildSessionFactory();

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
			User instance = (User) sessionFactory.getCurrentSession().get("User", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
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
			List<User> results = (List<User>) (sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).list());
			log.debug("find by example successful, result size: " + results.size());
								
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> findAllJSON(Class clazz) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) (sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).list());
			log.debug("find by example successful, result size: " + results.size());
								
			 HashMap<Long,User> userJSON = new HashMap<>();
			 
			 for (User user : results) {
				 userJSON.put(user.getUserId(), user);
			    }

			 List<User> users = new ArrayList<User>(userJSON.values());
			 
			return users;
			
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

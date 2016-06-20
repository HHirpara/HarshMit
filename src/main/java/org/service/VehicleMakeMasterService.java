package org.service;
// Generated Jun 1, 2016 6:31:44 PM by Hibernate Tools 3.5.0.Final

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bean.VehicleMakeMaster;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Home object for domain model class VehicleMakeMaster.
 * @see org.entity.VehicleMakeMaster
 * @author Hibernate Tools
 */

@Repository
@Service
public class VehicleMakeMasterService {

	private static final Log log = LogFactory.getLog(VehicleMakeMasterService.class);

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

	public void persist(VehicleMakeMaster transientInstance) {
		log.debug("persisting VehicleMakeMaster instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VehicleMakeMaster instance) {
		log.debug("attaching dirty VehicleMakeMaster instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VehicleMakeMaster instance) {
		log.debug("attaching clean VehicleMakeMaster instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VehicleMakeMaster persistentInstance) {
		log.debug("deleting VehicleMakeMaster instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VehicleMakeMaster merge(VehicleMakeMaster detachedInstance) {
		log.debug("merging VehicleMakeMaster instance");
		try {
			VehicleMakeMaster result = (VehicleMakeMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VehicleMakeMaster findById(java.lang.Long id) {
		log.debug("getting VehicleMakeMaster instance with id: " + id);
		try {
			VehicleMakeMaster instance = (VehicleMakeMaster) sessionFactory.getCurrentSession()
					.get("org.entity.VehicleMakeMaster", id);
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
	public List<VehicleMakeMaster> findByExample(VehicleMakeMaster instance) {
		log.debug("finding VehicleMakeMaster instance by example");
		try {
			List<VehicleMakeMaster> results = (List<VehicleMakeMaster>) sessionFactory.getCurrentSession()
					.createCriteria("org.entity.VehicleMakeMaster").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VehicleMakeMaster> findAll(Class clazz) {
		log.debug("finding User instance by example");
		try {

			List<VehicleMakeMaster> vehicles = new ArrayList<VehicleMakeMaster>();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			vehicles = session.createCriteria(VehicleMakeMaster.class).list();
			tx.commit();
			return vehicles;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public VehicleMakeMaster save(VehicleMakeMaster instance) {
		log.debug("attaching clean VehicleMakeMaster instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		return instance;
	}
	
	public VehicleMakeMaster update(VehicleMakeMaster instance) {
		log.debug("attaching clean VehicleMakeMaster instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.update(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		return instance;
	}
}

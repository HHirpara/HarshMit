package org.service;
// Generated Jun 1, 2016 6:31:44 PM by Hibernate Tools 3.5.0.Final

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bean.VehicleModelMaster;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Home object for domain model class VehicleModelMaster.
 * @see org.entity.VehicleModelMaster
 * @author Hibernate Tools
 */

@Repository
@Service
public class VehicleModelMasterService {

	private static final Log log = LogFactory.getLog(VehicleModelMasterService.class);

	@Autowired
	private SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(VehicleModelMaster transientInstance) {
		log.debug("persisting VehicleModelMaster instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VehicleModelMaster instance) {
		log.debug("attaching dirty VehicleModelMaster instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VehicleModelMaster instance) {
		log.debug("attaching clean VehicleModelMaster instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VehicleModelMaster persistentInstance) {
		log.debug("deleting VehicleModelMaster instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VehicleModelMaster merge(VehicleModelMaster detachedInstance) {
		log.debug("merging VehicleModelMaster instance");
		try {
			VehicleModelMaster result = (VehicleModelMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VehicleModelMaster findById(java.lang.Long id) {
		log.debug("getting VehicleModelMaster instance with id: " + id);
		try {
			VehicleModelMaster instance = (VehicleModelMaster) sessionFactory.getCurrentSession()
					.get("org.entity.VehicleModelMaster", id);
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
	public List<VehicleModelMaster> findByExample(VehicleModelMaster instance) {
		log.debug("finding VehicleModelMaster instance by example");
		try {
			List<VehicleModelMaster> results = (List<VehicleModelMaster>) sessionFactory.getCurrentSession()
					.createCriteria("org.entity.VehicleModelMaster").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VehicleModelMaster> findAll(Class clazz) {
		log.debug("finding Vehicle Model instance by example");
		try {

			List<VehicleModelMaster> vehicles = new ArrayList<VehicleModelMaster>();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			vehicles = session.createCriteria(VehicleModelMaster.class).list();
			tx.commit();
			return vehicles;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

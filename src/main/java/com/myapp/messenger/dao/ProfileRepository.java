package com.myapp.messenger.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.myapp.messenger.dao.config.HibernateUtil;
import com.myapp.messenger.model.entity.Profile;

public class ProfileRepository {

	public Profile save(Profile profile) {
		Session session = HibernateUtil.getNewSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(profile);
			tx.commit();
		} catch (Exception ex) {
			Optional.ofNullable(tx).ifPresent(Transaction::rollback);
			throw ex;
		} finally {
			Optional.ofNullable(session).ifPresent(Session::close);
		}
		return profile;
	}

	public Profile update(Profile profile) {
		Session session = HibernateUtil.getNewSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(profile);
			tx.commit();
		} catch (Exception ex) {
			Optional.ofNullable(tx).ifPresent(Transaction::rollback);
			throw ex;
		} finally {
			Optional.ofNullable(session).ifPresent(Session::close);
		}
		return profile;
	}

	public void delete(Profile profile) {
		Session session = HibernateUtil.getNewSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(profile);
			tx.commit();
		} catch (Exception ex) {
			Optional.ofNullable(tx).ifPresent(Transaction::rollback);
			throw ex;
		} finally {
			Optional.ofNullable(session).ifPresent(Session::close);
		}
	}

	public Profile findOne(String name) {
		Profile profile = null;
		Session session = HibernateUtil.getNewSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query<Profile> query = session.createQuery("from Profile p where p.username=:name", Profile.class);
			query.setParameter("name", name);
			profile = query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			Optional.ofNullable(tx).ifPresent(Transaction::rollback);
			throw ex;
		} finally {
			Optional.ofNullable(session).ifPresent(Session::close);
		}
		return profile;
	}
	public List<Profile> findAll() {
		List<Profile> profiles = null;
		Session session = HibernateUtil.getNewSession();
		try {
			session.beginTransaction();
			profiles = session.createQuery("from Profile p", Profile.class).list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			Optional.ofNullable(session.getTransaction()).ifPresent(Transaction::rollback);
			throw ex;
		} finally {
			Optional.ofNullable(session).ifPresent(HibernateUtil::close);
		}
		return profiles;
	}
}

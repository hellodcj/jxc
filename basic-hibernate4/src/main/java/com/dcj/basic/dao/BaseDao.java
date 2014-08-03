package com.dcj.basic.dao;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao<T> implements IBaseDao<T> {
	
	private SessionFactory sessionFactory;
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;
	
	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	
	@Inject
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public T add(T t) {
		getSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		getSession().delete(this.load(id));
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public T load(int id) {
		return (T)getSession().load(getClz(), id);
	}

}

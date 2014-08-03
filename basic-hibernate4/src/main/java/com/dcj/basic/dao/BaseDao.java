package com.dcj.basic.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dcj.basic.model.SystemContext;
import com.dcj.basic.model.Pager;

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

	@Override
	public List<T> list(String hql) {
		return this.list(hql, null);
	}

	@Override
	public List<T> list(String hql, Object arg) {
		return this.list(hql, new Object[]{arg});
	}

	@Override
	public List<T> list(String hql, Object[] args) {
		return this.list(hql, args,null);
	}

	@Override
	public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
		hql = this.initSort(hql);
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.list();
	}

	@Override
	public List<T> listByAlias(String hql, Map<String, Object> alias) {
		return this.list(hql, null, alias);
	}

	@Override
	public Pager<T> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> find(String hql, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> find(String hql, Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryObject(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryObject(String hql, Object arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryObject(String hql, Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateByHql(String hql) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByHql(String hql, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByHql(String hql, Object[] args) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 根据hql，初始化排序
	 * @param hql
	 * @return
	 */
	private String initSort(String hql) {
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(sort!=null&&!"".equals(sort.trim())) {
			hql+=" order by "+sort;
			if(!"desc".equals(order)) hql+=" asc";
			else hql+=" desc";
		}
		return hql;
	}
	
	/**
	 * 设置query的参数
	 * @param query
	 * @param args
	 */
	private void setParameter(Query query,Object[] args) {
		if(args!=null&&args.length>0) {
			int index = 0;
			for(Object arg:args) {
				query.setParameter(index++, arg);
			}
		}
	}
	
	/**
	 * 设置别名参数
	 * @param query
	 * @param alias
	 */
	private void setAliasParameter(Query query,Map<String,Object> alias) {
		if(alias!=null) {
			Set<String> keys = alias.keySet();
			for(String key:keys) {
				Object val = alias.get(key);
				if(val instanceof Collection) {
					//查询条件是列表
					query.setParameterList(key, (Collection)val);
				} else {
					query.setParameter(key, val);
				}
			}
		}
	}

	@Override
	public Pager<T> findByAlias(String hql, Map<String, Object> alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias) {
		// TODO Auto-generated method stub
		return null;
	}
}

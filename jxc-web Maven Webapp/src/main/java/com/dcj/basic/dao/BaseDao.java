package com.dcj.basic.dao;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.dcj.basic.model.SystemContext;
import com.dcj.basic.model.Pager;

@Repository(value="baseDao")
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
		getSession().flush();
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
		return this.find(hql, null);
	}

	@Override
	public Pager<T> find(String hql, Object arg) {
		return this.find(hql, new Object[]{arg});
	}

	@Override
	public Pager<T> find(String hql, Object[] args) {
		return this.find(hql, args, null);
	}
	
	@Override
	public Pager<T> findByAlias(String hql, Map<String, Object> alias) {
		return this.find(hql, null, alias);
	}

	@Override
	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(hql);
		String cq = getCountHql(hql,true);
		Query cquery = getSession().createQuery(cq);
		Query query = getSession().createQuery(hql);
		//设置别名参数
		setAliasParameter(query, alias);
		setAliasParameter(cquery, alias);
		//设置参数
		setParameter(query, args);
		setParameter(cquery, args);
		//实例化一个分页对象，将从context中获取的分页信息，传入这个对象中
		Pager<T> pages = new Pager<T>();
		setPagers(query,pages);
		List<T> datas = query.list();
		pages.setDatas(datas);
		long total = (Long)cquery.uniqueResult();
		pages.setTotal(total);
		return pages;
	}

	@Override
	public Object queryObject(String hql) {
		return this.queryObject(hql,null);
	}

	@Override
	public Object queryObject(String hql, Object arg) {
		return this.queryObject(hql, new Object[]{arg});
	}

	@Override
	public Object queryObject(String hql, Object[] args) {
		return this.queryObject(hql, args,null);
	}
	
	@Override
	public Object queryObject(String hql, Object[] args,
			Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.uniqueResult();
	}

	@Override
	public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
		return this.queryObject(hql,null,alias);
	}

	@Override
	public void updateByHql(String hql) {
		this.updateByHql(hql, null);
		
	}

	@Override
	public void updateByHql(String hql, Object arg) {
		this.updateByHql(hql, new Object[]{arg});
	}

	@Override
	public void updateByHql(String hql, Object[] args) {
		Query query = getSession().createQuery(hql);
		setParameter(query, args);
		query.executeUpdate();
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

	/**
	 * 拼接count的hql语句
	 * @param hql
	 * @param isHql
	 * @return
	 */
	private String getCountHql(String hql,boolean isHql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*) "+e;
		if(isHql)
			c.replaceAll("fetch", "");
		return c;
	}

	/**
	 * 从context中获取分页信息，并初始化query的分页
	 * @param query
	 * @param pages
	 */
	private void setPagers(Query query,Pager pages) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageOffset==null||pageOffset<0) pageOffset = 0;
		if(pageSize==null||pageSize<0) pageSize = 15;
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
	}

	@Override
	public <N> List<N> listBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		SQLQuery sq = getSession().createSQLQuery(sql);
		setAliasParameter(sq, alias);
		setParameter(sq, args);
		if(hasEntity) {
			sq.addEntity(clz);
		} else 
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		return sq.list();
	}

	@Override
	public <N> List<N> listByAliasSql(String sql, Map<String, Object> alias,
			Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, alias, clz, hasEntity);
	}

	@Override
	public <N> List<N> listBySql(String sql, Object[] args, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, args, null, clz, hasEntity);
	}

	@Override
	public <N> List<N> listBySql(String sql, Object arg, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, new Object[]{arg}, clz, hasEntity);
	}

	@Override
	public <N> List<N> listBySql(String sql, Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, clz, hasEntity);
	}

	@Override
	public <N> Pager<N> findBySql(String sql, Object[] args, Class<?> clz,
			boolean hasEntity) {
		return this.findBySql(sql, args, null, clz, hasEntity);
	}

	@Override
	public <N> Pager<N> findBySql(String sql, Object arg, Class<?> clz,
			boolean hasEntity) {
		return this.findBySql(sql, new Object[]{arg}, clz, hasEntity);
	}

	@Override
	public <N> Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, null, clz, hasEntity);
	}

	@Override
	public <N> Pager<N> findBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		String cq = getCountHql(sql,false);
		SQLQuery sq = getSession().createSQLQuery(sql);
		SQLQuery cquery = getSession().createSQLQuery(cq);
		setAliasParameter(sq, alias);
		setAliasParameter(cquery, alias);
		setParameter(sq, args);
		setParameter(cquery, args);
		Pager<N> pages = new Pager<N>();
		setPagers(sq, pages);
		if(hasEntity) {
			sq.addEntity(clz);
		} else {
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		}
		List<N> datas = sq.list();
		pages.setDatas(datas);
		long total = ((BigInteger)cquery.uniqueResult()).longValue();
		pages.setTotal(total);
		return pages;
	}

	@Override
	public <N> Pager<N> findByAliasSql(String sql, Map<String, Object> alias,
			Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, null, alias, clz, hasEntity);
	}
}

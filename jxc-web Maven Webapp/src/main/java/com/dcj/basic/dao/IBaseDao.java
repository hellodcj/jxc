package com.dcj.basic.dao;

import java.util.List;
import java.util.Map;

import com.dcj.basic.model.Pager;

/**
 * 公共 dao
 */
public interface IBaseDao<T> {
	/**
	 * 添加对象
	 */
	public T add(T t);
	
	/**
	 * 根据id，删除对象
	 */
	public void delete(int id);
	
	/**
	 * 修改对象
	 */
	public void update (T t);
	
	/**
	 * 根据id，查找对象
	 */
	public T load(int id);
	
	/**基于别名与参数的混合查询
	 * @param
	 * @return 查询一组布分页的列表对象
	 */
	public List<T> list(String hql);
	public List<T> list(String hql,Object arg);
	public List<T> list(String hql,Object[] args);
	public List<T> listByAlias(String hql,Map<String,Object> alias);
	public List<T> list(String hql, Object[] args, Map<String, Object> alias);
	
	/**
	 * 根据sql语句来查询list
	 * @param sql
	 * @param args
	 * @param alias
	 * @param clz
	 * @param hasEntity
	 * @return
	 */
	public <N extends Object>List<N> listBySql(String sql, Object[] args,Map<String, Object> alias, Class<?> clz, boolean hasEntity);
	public <N extends Object>List<N> listByAliasSql(String sql, Map<String, Object> alias,Class<?> clz, boolean hasEntity);
	public <N extends Object>List<N> listBySql(String sql, Object[] args, Class<?> clz,boolean hasEntity);
	public <N extends Object>List<N> listBySql(String sql, Object arg, Class<?> clz,boolean hasEntity) ;
	public <N extends Object>List<N> listBySql(String sql, Class<?> clz, boolean hasEntity) ;
	/**
	 * 分页对象
	 * @param hql
	 * @return Pager<T>
	 */
	public Pager<T> find(String hql);
	public Pager<T> find(String hql,Object arg);
	public Pager<T> find(String hql,Object[] args);
	public Pager<T> findByAlias(String hql,Map<String, Object> alias);
	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias);
	
	/**
	 * 根据sql来得到分页对象
	 * @param sql
	 * @param args
	 * @param clz
	 * @param hasEntity
	 * @return
	 */
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args, Class<?> clz,boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql, Object arg, Class<?> clz,boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args,Map<String, Object> alias, Class<?> clz, boolean hasEntity);
	public <N extends Object>Pager<N> findByAliasSql(String sql, Map<String, Object> alias,Class<?> clz, boolean hasEntity);
	/**
	 * 查询单个对象
	 * @param hql
	 * @return Object
	 */
	public Object queryObject(String hql) ;
	public Object queryObject(String hql,Object arg) ;
	public Object queryObject(String hql,Object[] args) ;
	public Object queryObject(String hql, Object[] args,Map<String, Object> alias);
	public Object queryObjectByAlias(String hql, Map<String, Object> alias);
	
	/**
	 * 根据hql来更新数据
	 * @param hql
	 */
	public void updateByHql(String hql);
	public void updateByHql(String hql,Object arg);
	public void updateByHql(String hql,Object[] args);
	
	
}

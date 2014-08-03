package com.dcj.basic.dao;

import java.util.List;

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
	
	/**
	 * @param
	 * @return 查询一组布分页的列表对象
	 */
	public List<T> list(String hql);
}

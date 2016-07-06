package com.momolela.core.dao;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * 
 * BaseDaoImpl
 * 创建人:keke
 * 时间：2015年4月29日-上午12:03:20 
 * @version 1.0.0
 *
 */
public interface IBaseDao<T,PK extends Serializable> {

	/**
	 * 保存方法
	 * 方法名：save
	 * 创建人：xuchengfei
	 *  时间：2015年5月5日-下午11:10:25 
	 * @param t
	 * @return T
	 * @exception 
	 * @since  1.0.0
	 */
	public T save(T t); 
	
	/**
	 * 根据主键获取实体
	 * 方法名：get
	 * 创建人：xuchengfei
	 * 时间：2015年5月6日-上午12:20:40 
	 * @param id
	 * @return T
	 * @exception 
	 * @since  1.0.0
	 */
	public T get(PK id) ;
	
	/**
	 * 根据主键获取实体
	 * 方法名：load
	 * 创建人：xuchengfei
	 * 时间：2015年5月6日-上午12:20:40 
	 * @param id
	 * @return T
	 * @exception 
	 * @since  1.0.0
	 */
	public T load(PK id) ;
	
	/**
	 * 根据主键删除
	 * 方法名：get
	 * 创建人：xuchengfei
	 * 时间：2015年5月6日-上午12:20:40 
	 * @param id
	 * @return T
	 * @exception 
	 * @since  1.0.0
	 */
	public void delete(T entity);
	
	/**
	 * 根据主键获取实体
	 * 方法名：get
	 * 创建人：xuchengfei
	 * 时间：2015年5月6日-上午12:20:40 
	 * @param id
	 * @return T
	 * @exception 
	 * @since  1.0.0
	 */
	public T deleteById(PK id);
	
	public T update(T entity);
	
	public T updateDefault(T entity);
	
	public List<T> find(String sql ,Object...args);
	
}

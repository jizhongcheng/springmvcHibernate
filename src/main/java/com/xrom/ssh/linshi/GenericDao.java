package com.xrom.ssh.linshi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author  lianhai

 */
public interface GenericDao<T extends Serializable, PK extends Serializable> {
    // -------------------- 基本检索、添加、改动、删除操作 --------------------

    // 依据主键获取实体。

    public T get(PK id);

    // 依据主键获取实体并加锁。假设没有对应的实体。返回 null。
    public T getWithLock(PK id, LockMode lock);

    // 依据主键获取实体。
    public T load(PK id);

    // 依据主键获取实体并加锁。假设没有对应的实体，抛出异常。


    public T loadWithLock(PK id, LockMode lock);

    // 获取所有实体。
    public List<T> loadAll();

    // loadAllWithLock() ?

    // 更新实体
    public void update(T entity);

    // 更新实体并加锁
    public void updateWithLock(T entity, LockMode lock);

    // 存储实体到数据库
    public void save(T entity);

    // saveWithLock()

    // 添加或更新实体
    public void saveOrUpdate(T entity);


    // 删除指定的实体
    public void delete(T entity);

    // 加锁并删除指定的实体
    public void deleteWithLock(T entity, LockMode lock);

    // 依据主键删除指定实体
    public void deleteByKey(PK id);

    // 依据主键加锁并删除指定的实体
    public void deleteByKeyWithLock(PK id, LockMode lock);

    // 删除集合中的所有实体
    public void deleteAll(Collection<T> entities);

    // -------------------- HQL ----------------------------------------------

    // 使用HQL语句直接添加、更新、删除实体
    public int bulkUpdate(String queryString);

    // 使用带參数的HQL语句添加、更新、删除实体
    public int bulkUpdate(String queryString, Object[] values);

    // 使用HQL语句检索数据
    public List find(String queryString);

    // 使用带參数的HQL语句检索数据
    public List find(String queryString, Object[] values);

    // 使用带命名的參数的HQL语句检索数据
    public List findByNamedParam(String queryString, String[] paramNames,Object[] values);

    // 使用命名的HQL语句检索数据
    public List findByNamedQuery(String queryName);

    // 使用带參数的命名HQL语句检索数据
    public List findByNamedQuery(String queryName, Object[] values);

    // 使用带命名參数的命名HQL语句检索数据
    public List findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values);

    // 使用HQL语句检索数据，返回 Iterator
    public Iterator iterate(String queryString);

    // 使用带參数HQL语句检索数据，返回 Iterator
    public Iterator iterate(String queryString, Object[] values);

    // 关闭检索返回的 Iterator
    public void closeIterator(Iterator it);

    // -------------------------------- Criteria ------------------------------

    // 创建与会话无关的检索标准对象
    public DetachedCriteria createDetachedCriteria();

    // 创建与会话绑定的检索标准对象
    public Criteria createCriteria();

    // 使用指定的检索标准检索数据
    public List findByCriteria(DetachedCriteria criteria);

    // 使用指定的检索标准检索数据。返回部分记录
    public List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);

    // 使用指定的实体及属性检索（满足除主键外属性＝实体值）数据
    public List<T> findEqualByEntity(T entity, String[] propertyNames);


    // 使用指定的检索标准检索数据。返回指定范围的记录
    public Integer getRowCount(DetachedCriteria criteria);

    // 使用指定的检索标准检索数据，返回指定统计值
    public Object getStatValue(DetachedCriteria criteria, String propertyName, String StatName);

    // -------------------------------- Others --------------------------------

    // 加锁指定的实体
    public void lock(T entity, LockMode lockMode);

    // 强制初始化指定的实体
    public void initialize(Object proxy);

    // 强制马上更新缓冲数据到数据库（否则仅在事务提交时才更新）
    public void flush();

}

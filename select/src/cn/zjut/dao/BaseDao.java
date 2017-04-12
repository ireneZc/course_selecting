package cn.zjut.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import cn.zjut.utils.HibernateHandler;
import cn.zjut.utils.Pagination;

public interface BaseDao<T> {  
	  
    /**  
     * ����ʵ��  
     *   
     * @param entity  
     *            ʵ�����  
     * @return ʵ������  
     */  
    Object save(Object entity);  
  
    /**  
     *   
     * ɾ��ʵ��  
     *   
     * @param entity  
     *            ʵ�����  
     *   
     */  
    void delete(Object entity);  
  
    /**  
     *   
     * ����ʵ��  
     *   
     * @param entity  
     *            ʵ�����  
     *   
     */  
    void update(Object entity);  
  
    /**  
     *   
     * ��������ʵ��, ʵ��û������ʱ���棬�������  
     *   
     * @param entity  
     *            ʵ�����  
     *   
     */  
    void saveOrUpdate(Object entity);  
  
    /**  
     *   
     * ��������ʵ��  
     *   
     * @param entities  
     *            ʵ�弯��  
     */  
    void saveAll(Collection<?> entities);  
  
    /**  
     *   
     * ����ɾ��ʵ��  
     *   
     * @param entities  
     *            ʵ�弯��  
     *   
     */  
    void deleteAll(Collection<?> entities);  
  
    /**  
     *   
     * ��������ʵ��  
     *   
     * @param entities  
     *            ʵ�弯��  
     *   
     */  
    void updateAll(Collection<?> entity);  
  
    /**  
     *   
     * ������������ʵ��, ʵ��û������ʱ���棬�������  
     *   
     * @param entity  
     *            ʵ�弯��  
     *   
     */  
    void saveOrUpdateAll(Collection<?> entities);  
  
    /**  
     *   
     * ��ȡ����ʵ�壬����ʵ���༰ʵ���������ȡ��  
     *   
     * @param entityClass  
     *            ʵ����  
     * @param id  
     *            ʵ������  
     * @return ʵ�����  
     */  
    @SuppressWarnings("hiding")  
    <T> T get(Class<T> entityClass, Serializable id);  
  
    /**  
     * ��ȡ����ʵ�壬���ݲ�ѯ��估������ȡ��  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @return ����ʵ�壬�����ѯ����ж�����򷵻ص�һ��ʵ��  
     */  
    @SuppressWarnings("hiding")  
    <T> T get(CharSequence queryString, Map<String, Object> params);  
  
    /**  
     * ��ȡ����ʵ�壬���ݲ�ѯ��估������ȡ��  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @return ����ʵ�壬�����ѯ����ж�����򷵻ص�һ��ʵ��  
     */  
    @SuppressWarnings("hiding")  
    <T> T get(CharSequence queryString, Object... params);  
  
    /**  
     *   
     * ��ѯʵ���б�  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @return ʵ���б�  
     */  
    @SuppressWarnings("hiding")  
    <T> List<T> findList(CharSequence queryString, Object... params);  
  
    /**  
     *   
     * ��ѯʵ���б�  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @return ʵ���б�  
     */  
    @SuppressWarnings("hiding")  
    <T> List<T> findList(CharSequence queryString, Map<String, Object> params);  
  
    /**  
     * ��ҳ��ѯʵ��  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param pageIndex  
     *            ��ǰҳ�룬���pageIndex<1�򲻷�ҳ���ҷ���pageSize����¼��  
     * @param pageSize  
     *            ÿҳ��¼�������pageSize<1�򷵻����м�¼��  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @return ʵ���ҳ����  
     */  
    @SuppressWarnings("hiding")  
    <T> Pagination<T> findPagination(CharSequence queryString, int pageIndex, int pageSize, Object... params);  
  
    /**  
     * ��ҳ��ѯʵ��  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @param pageIndex  
     *            ��ǰҳ�룬���pageIndex<2�򲻷�ҳ���ҷ���pageSize����¼��  
     * @param pageSize  
     *            ÿҳ��¼�������pageSize<1�򷵻����м�¼��  
     *   
     * @return ʵ���ҳ����  
     */  
    @SuppressWarnings("hiding")  
    <T> Pagination<T> findPagination(CharSequence queryString, Map<String, Object> params, int pageIndex, int pageSize);  
  
    /**  
     * ��ҳ��ѯʵ�壬�Զ�����������ѯ��䣬�ʺϸ��ӵ�hql��ҳ��ѯ  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param countString  
     *            ��ѯ��¼���������  
     * @param pageIndex  
     *            ��ǰҳ�룬���pageIndex<1�򲻷�ҳ���ҷ���pageSize����¼��  
     * @param pageSize  
     *            ÿҳ��¼�������pageSize<1�򷵻����м�¼��  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @return ʵ���ҳ����  
     */  
    @SuppressWarnings("hiding")  
    <T> Pagination<T> findPagination(CharSequence queryString, CharSequence countString, int pageIndex, int pageSize,  
            Object... params);  
  
    /**  
     * ��ҳ��ѯʵ�壬�Զ�����������ѯ��䣬�ʺϸ��ӵ�hql��ҳ��ѯ  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param countString  
     *            ��ѯ��¼���������  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @param pageIndex  
     *            ��ǰҳ�룬���pageIndex<2�򲻷�ҳ���ҷ���pageSize����¼��  
     * @param pageSize  
     *            ÿҳ��¼�������pageSize<1�򷵻����м�¼��  
     *   
     * @return ʵ���ҳ����  
     */  
    @SuppressWarnings("hiding")  
    <T> Pagination<T> findPagination(CharSequence queryString, CharSequence countString, Map<String, Object> params,  
            int pageIndex, int pageSize);  
  
    /**  
     * ��ҳ��ѯʵ�壬�Զ�����������ѯ��䣬�ʺϸ��ӵ�sql��ҳ��ѯ  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param countString  
     *            ��ѯ��¼���������  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @param pageIndex  
     *            ��ǰҳ�룬���pageIndex<2�򲻷�ҳ���ҷ���pageSize����¼��  
     * @param pageSize  
     *            ÿҳ��¼�������pageSize<1�򷵻����м�¼��  
     *   
     * @return ʵ���ҳ����  
     */  
    @SuppressWarnings("hiding")  
    public <T> Pagination<T> findSqlPagination(final CharSequence queryString, final CharSequence countString,  
            final Map<String, Object> params, int pageIndex, int pageSize);  
  
    /**  
     * ִ�����ݿ���²���  
     *   
     * @deprecated ��{@link #executeUpdate(String)}�滻  
     * @param hql  
     */  
    void execute(String hql);  
  
    /**  
     * ִ�����ݿ���²���  
     *   
     * @deprecated ��{@link #executeUpdate(HibernateHandler)}�滻  
     * @param hql  
     */  
    void execute(HibernateHandler handler);  
  
    /**  
     * ִ�����ݿ���²���  
     *   
     * @deprecated ��{@link #executeSqlUpdate(String)}�滻  
     * @param sql  
     */  
    void executeSql(String sql);  
  
    /**  
     * ִ�����ݿ��ѯ����  
     *   
     * @param handler  
     *            ������  
     * @return  
     * @throws Exception  
     */  
    Object executeQuery(HibernateHandler handler);  
  
    /**  
     * ִ�����ݿ���²���  
     *   
     * @param sql  
     * @return ���µļ�¼����  
     */  
    int executeSqlUpdate(String sql);  
  
    /**  
     * ִ�����ݿ���²���  
     *   
     * @param hql  
     * @return ���µļ�¼����  
     */  
    int executeUpdate(String hql);  
  
    /**  
     * ִ�����ݿ���²���  
     *   
     * @param handler  
     *            ������  
     * @return  
     * @throws Exception  
     */  
    Object executeUpdate(HibernateHandler handler);  
  
    public T getById(Serializable id);  
  
    public T saveEntity(T o);  
  
    public T insert(T o);  
  
    public void save(List<T> list);  
  
    public void insert(List<T> list);  
  
    public void delete(List<T> list);  
  
    public void update(List<T> list);  
  
    public List<T> findByProperty(String name, Object value);  
  
    public List<T> findByProperty(Map<String, Object> conditionMap);  
  
    /**  
     *   
     * ��ѯʵ���б�  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param maxResults  
     *            �б������  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @return ʵ���б�  
     */  
    public <V> List<V> findListByMax(CharSequence queryString, int maxResults, Object... params);  
  
    /**  
     *   
     * ��ѯʵ���б�  
     *   
     * @param queryString  
     *            ��ѯ���  
     * @param maxResults  
     *            �б������  
     * @param params  
     *            ��ѡ�Ĳ�ѯ����  
     * @return ʵ���б�  
     */  
    public <V> List<V> findListByMax(CharSequence queryString, int maxResults, Map<String, Object> params);  
}  
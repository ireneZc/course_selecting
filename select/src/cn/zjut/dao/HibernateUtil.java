package cn.zjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.zjut.entity.Students;

final public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	//线程局部模式
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	
	private HibernateUtil(){};
	
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	public static Session getCurrentSession(){
		Session session=threadLocal.get();
		if(session==null){
			session=sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session; 
	}
	public static void showResultByPage(int pageSize){
		int pageNow=1;
		int pageCount=1;
		int rowCount=1;
		
		Session session=null;
		Transaction tx=null;
		try {
			session=getCurrentSession();
			tx=session.beginTransaction();
			
			rowCount=Integer.parseInt(session.createQuery("select count(*) from Students").uniqueResult().toString());
			pageCount=(rowCount-1)/pageSize+1;
			for(int i=1;i<pageCount;i++){
				System.out.println("*******第"+i+"页*******");
				List<Students> list=session.createQuery("from Students").setFirstResult((i-1)*pageSize).setMaxResults(pageSize).list();
				for(Students s:list){
					System.out.println(s.getSname()+" "+s.getSacdemy());
				}
			} 
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
	}
	public List executeQuery(String hql,String[] parameters){
		Session session=null;
		Transaction tx= null;
		List list=null;
		try {
			session=getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			if(parameters!=null && parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setString(i, parameters[i]);
				}
			}
			list=query.list();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null  ){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	public static List excuteQueryByPage(String hql,String[] parameters,int pageSize,int pageNow){
		Session session=null;
		Transaction tx= null;
		List list=null;
		try {
			session=getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			if(parameters!=null && parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setString(i, parameters[i]);
				}
			}
			query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
			list=query.list();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null  ){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	public static void save(Object obj){
		Session session=null;
		Transaction tx= null;
		List list=null;
		try {
			session=getCurrentSession();
			tx=session.beginTransaction();
			session.save(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
	}
	public static void executeUpdate(String hql,String[] parameters){
		Session session=null;
		Transaction tx= null;
		try {
			session=getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			if(parameters!=null && parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setString(i, parameters[i]);
				}
			}
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null  ){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session!=null && session.isOpen()){
				session.close();
			}
		} 
	}
}

package cn.zjut.view;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.zjut.dao.HibernateUtil;
import cn.zjut.entity.Courses;
import cn.zjut.entity.Students;;

public class TestMain {
	public static void main(String[] args) {
		String[] parameters={"21"};
		String hql="update Students s set sage=?";
		HibernateUtil.executeUpdate(hql, parameters);
	}
	
	private static void showResultByPage(int pageSize){
		int pageNow=1;
		int pageCount=1;
		int rowCount=1;
		
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			
			rowCount=Integer.parseInt(session.createQuery("select count(*) from Students").uniqueResult().toString());
			pageCount=(rowCount-1)/pageSize+1;
			for(int i=1;i<pageCount;i++){
				System.out.println("*******ตฺ"+i+"าณ*******");
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
	private static void query4() {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			
			Query query=session.createQuery("from Students where id>? and sage=?");
			query.setInteger(0, 3);
			query.setShort(1, (short)20);
			List<Students> list=query.list();
			
			for(Students s:list){
				System.out.println(s.getSid()+" "+s.getSname());
			}
			
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
	
	private static void query3() {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			
			List<Students> list=session.createQuery("from Students order by sid").setFirstResult(0).setMaxResults(3).list();
			for(Students s:list){
				System.out.println(s.getSid()+" "+s.getSname());
			}
			
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

	private static void query2() {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			
			List list=session.createQuery("select sname,sdept from Students").list();
			for(int i=0;i<list.size();i++){
				Object[] obj=(Object[]) list.get(i);
				System.out.println(obj[0].toString()+" "+obj[1].toString());
			}
			
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

	private static void query1() {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			
			List <Students> list=session.createQuery("from Students").list();
			for(Students s:list){
				System.out.println(s.getSname()+" "+s.getSacdemy());
			}
			
			System.out.println("***********");
			Iterator<Students> iterator=list.iterator();
			while(iterator.hasNext()){
				Students s=iterator.next();
				System.out.println(s.getSname()+" "+s.getSage());
			}
			
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

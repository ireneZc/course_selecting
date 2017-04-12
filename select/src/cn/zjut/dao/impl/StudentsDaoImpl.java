package cn.zjut.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.zjut.dao.StudentsDao;
import cn.zjut.entity.Courses;


public class StudentsDaoImpl extends BaseDaoImpl implements StudentsDao {

	
	
	
	public String getStuPasswdBySid(String sid) {
		String hql="SELECT spassword FROM Students WHERE sid=?";
        String str= (String) get(hql, sid);
        return str;
	}


	public List getStudentsCurrentCourses(String sid) {
		String hql="SELECT c.cname "
				+ "FROM Courses AS c,StudentsCourses AS sc "
				+ "WHERE sc.sid=? and sc.cid=c.cid";
		
		List<Courses> list=findList(hql, sid);
		return list;
	}


	public List getAllCourses() {
		String hql="FROM Courses";
		Query query=getSession().createQuery(hql);
		List<Courses> list=query.list();
		return list;
	}

	
	public void selectCourses(List<Courses> courses) {
		// TODO Auto-generated method stub

	}

	
	public void deleteCourses(List<Courses> courses) {
		// TODO Auto-generated method stub

	}

	
	public List screenCoursesByCtype() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List screenCoursesByCtime() {
		// TODO Auto-generated method stub
		return null;
	}

}

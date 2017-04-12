package cn.zjut.dao;

import java.util.List;

import cn.zjut.entity.Courses;

public interface StudentsDao {
	public String getStuPasswdBySid(String sid);
	public List getStudentsCurrentCourses(String sid);
	public List getAllCourses();
	public void selectCourses(List<Courses> courses);
	public void deleteCourses(List<Courses> courses);
	public List screenCoursesByCtype();
	public List screenCoursesByCtime();
}

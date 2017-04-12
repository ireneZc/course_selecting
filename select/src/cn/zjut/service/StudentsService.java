package cn.zjut.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zjut.dao.impl.StudentsDaoImpl;

@Service
public class StudentsService {
	//@Resource
	private StudentsDaoImpl studentsDaoImpl;

	public StudentsDaoImpl getStudentsDaoImpl() {
		return studentsDaoImpl;
	}

	public void setStudentsDaoImpl(StudentsDaoImpl studentsDaoImpl) {
		this.studentsDaoImpl = studentsDaoImpl;
	}


	@Transactional
	public String passwd(){
		return studentsDaoImpl.getStuPasswdBySid("201519630201");
	}
}

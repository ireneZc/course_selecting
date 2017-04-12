package cn.zjut.test;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.zjut.dao.impl.StudentsDaoImpl;
import cn.zjut.entity.Students;
import cn.zjut.service.StudentsService;


public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentsService ts=(StudentsService) ac.getBean("StudentsService");
		System.out.println(ts.passwd());

	}
}

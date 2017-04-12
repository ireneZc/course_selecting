package cn.zjut.entity;

/**
 * AbstractStudentsCourses entity provides the base persistence definition of
 * the StudentsCourses entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudentsCourses implements java.io.Serializable {

	// Fields

	private Integer stuCourId;
	private String sid;
	private String cid;

	// Constructors

	/** default constructor */
	public AbstractStudentsCourses() {
	}

	/** full constructor */
	public AbstractStudentsCourses(String sid, String cid) {
		this.sid = sid;
		this.cid = cid;
	}

	// Property accessors

	public Integer getStuCourId() {
		return this.stuCourId;
	}

	public void setStuCourId(Integer stuCourId) {
		this.stuCourId = stuCourId;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
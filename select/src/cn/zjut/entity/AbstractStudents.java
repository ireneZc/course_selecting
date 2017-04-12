package cn.zjut.entity;

/**
 * AbstractStudents entity provides the base persistence definition of the
 * Students entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudents implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;
	private String ssex;
	private String sacdemy;
	private Short sage;
	private String spassword;

	// Constructors

	/** default constructor */
	public AbstractStudents() {
	}

	/** minimal constructor */
	public AbstractStudents(String sid, String sname, String ssex, Short sage, String spassword) {
		this.sid = sid;
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
		this.spassword = spassword;
	}

	/** full constructor */
	public AbstractStudents(String sid, String sname, String ssex, String sacdemy, Short sage, String spassword) {
		this.sid = sid;
		this.sname = sname;
		this.ssex = ssex;
		this.sacdemy = sacdemy;
		this.sage = sage;
		this.spassword = spassword;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSacdemy() {
		return this.sacdemy;
	}

	public void setSacdemy(String sacdemy) {
		this.sacdemy = sacdemy;
	}

	public Short getSage() {
		return this.sage;
	}

	public void setSage(Short sage) {
		this.sage = sage;
	}

	public String getSpassword() {
		return this.spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

}
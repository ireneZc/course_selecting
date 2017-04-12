package cn.zjut.entity;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */
public class Students extends AbstractStudents implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Students() {
	}

	/** minimal constructor */
	public Students(String sid, String sname, String ssex, Short sage, String spassword) {
		super(sid, sname, ssex, sage, spassword);
	}

	/** full constructor */
	public Students(String sid, String sname, String ssex, String sacdemy, Short sage, String spassword) {
		super(sid, sname, ssex, sacdemy, sage, spassword);
	}

}

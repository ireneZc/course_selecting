package cn.zjut.entity;

/**
 * Courses entity. @author MyEclipse Persistence Tools
 */
public class Courses extends AbstractCourses implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Courses() {
	}

	/** minimal constructor */
	public Courses(String cid, String cname, Short ccredit, String cctime, Short cmaxnum, Short cnownum, Short ctype) {
		super(cid, cname, ccredit, cctime, cmaxnum, cnownum, ctype);
	}

	/** full constructor */
	public Courses(String cid, String cname, Short ccredit, String cctime, String tid, Short cmaxnum, Short cnownum,
			Short ctype) {
		super(cid, cname, ccredit, cctime, tid, cmaxnum, cnownum, ctype);
	}

}

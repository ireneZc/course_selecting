package cn.zjut.entity;

/**
 * AbstractCourses entity provides the base persistence definition of the
 * Courses entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCourses implements java.io.Serializable {

	// Fields

	private String cid;
	private String cname;
	private Short ccredit;
	private String cctime;
	private String tid;
	private Short cmaxnum;
	private Short cnownum;
	private Short ctype;

	// Constructors

	/** default constructor */
	public AbstractCourses() {
	}

	/** minimal constructor */
	public AbstractCourses(String cid, String cname, Short ccredit, String cctime, Short cmaxnum, Short cnownum,
			Short ctype) {
		this.cid = cid;
		this.cname = cname;
		this.ccredit = ccredit;
		this.cctime = cctime;
		this.cmaxnum = cmaxnum;
		this.cnownum = cnownum;
		this.ctype = ctype;
	}

	/** full constructor */
	public AbstractCourses(String cid, String cname, Short ccredit, String cctime, String tid, Short cmaxnum,
			Short cnownum, Short ctype) {
		this.cid = cid;
		this.cname = cname;
		this.ccredit = ccredit;
		this.cctime = cctime;
		this.tid = tid;
		this.cmaxnum = cmaxnum;
		this.cnownum = cnownum;
		this.ctype = ctype;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Short getCcredit() {
		return this.ccredit;
	}

	public void setCcredit(Short ccredit) {
		this.ccredit = ccredit;
	}

	public String getCctime() {
		return this.cctime;
	}

	public void setCctime(String cctime) {
		this.cctime = cctime;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Short getCmaxnum() {
		return this.cmaxnum;
	}

	public void setCmaxnum(Short cmaxnum) {
		this.cmaxnum = cmaxnum;
	}

	public Short getCnownum() {
		return this.cnownum;
	}

	public void setCnownum(Short cnownum) {
		this.cnownum = cnownum;
	}

	public Short getCtype() {
		return this.ctype;
	}

	public void setCtype(Short ctype) {
		this.ctype = ctype;
	}

}
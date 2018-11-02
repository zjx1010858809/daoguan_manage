package com.situ.entity;

public class User {
	private int id;
	private String nike;
	private String pass="123";
	private String name;
	private int sex;
	private int age;
	private String birthday="";
	private int course_id;
	private int status=0;
	private String dress="";
	private int times=0;
	private String comments="";
	private String cname;
	
	
	private String[] sexlist= {"男","女"};//数字对应的文本


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNike() {
		return nike;
	}


	public void setNike(String nike) {
		this.nike = nike;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getDress() {
		return dress;
	}


	public void setDress(String dress) {
		this.dress = dress;
	}


	public int getTimes() {
		return times;
	}


	public void setTimes(int times) {
		this.times = times;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getSexlist() {
		return sexlist[sex];
	}
	
	

}

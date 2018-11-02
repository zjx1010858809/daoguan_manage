package com.situ.entity;

public class Operator {
	
	private int id;
	private String nike;			//用户名
	private String pass="123";			//密码
	private String name;			//姓名
	private int sex;				//电话
	private int age;
	
	private String[] sexlist= {"男","女"};
	
	
	
	
	public String getSexlist() {
		return sexlist[sex];
	}
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
	
}

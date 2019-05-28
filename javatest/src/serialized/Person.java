package serialized;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 序列化版本号，自己生成的
	 */
	private static final long serialVersionUID = 479531661532051261L;
	private String name = "root";
	private int age = 18;
	private String sex = "男";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:"+name+"\tage:"+age+"\tsex:"+sex;
	}
	
	
}

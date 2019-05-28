package serialized;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialVersionUID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		serializeCustomer();
		Customer customer = deserializeCustomer();
		System.out.println(customer);
	}
	/**
	 * 
	 */
	public static void serializeCustomer() {
		Customer customer = new Customer("lisa", 19);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(new File("../javatest/doc/customer.obj")));
			oos.writeObject(customer);
			System.out.println("serialized customer successfully");
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return
	 */
	public static Customer deserializeCustomer() {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(new File("../javatest/doc/customer.obj")));
			Customer customer = (Customer) ois.readObject();
			ois.close();
			System.out.println("deserialized customer successfully");
			return customer;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2228263189320369432L;
	private String name;
	private int age;
	
	//添加一个sex属性
	private String sex;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "name=" + name + ",age=" + age;
	}
}

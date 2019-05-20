package serialized;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.io.ObjectInputStream;

public class TestDemo {

	/**
	 * 序列化对象
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private static void serializePerson() throws FileNotFoundException, IOException {
		Person person = new Person();
		person.setAge(12);
		person.setName("lisa");
		person.setSex("女");
		ObjectOutputStream objOut = new ObjectOutputStream(new 
				FileOutputStream(new File("../javatest/doc/person.obj")));
		objOut.writeObject(person);
		System.out.println("person对象序列化成功");
		objOut.close();
	}

	/**
	 * 反序列化对象
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	private static Person deserlizePerson() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream objInput = new ObjectInputStream(new
				FileInputStream(new File("../javatest/doc/person.obj")));
		Person person = (Person) objInput.readObject();
		objInput.close();
		System.out.println("person对象反序列化成功");
		return person;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		serializePerson();
		Person person = deserlizePerson();
		System.out.println(MessageFormat.format("name={0},age={1},sex={2}",
				person.getName(),person.getAge(),person.getSex()));
	}	
}

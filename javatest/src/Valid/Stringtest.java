package Valid;

import java.util.ArrayList;

/**
 * @author admin
 *
 */
public class Stringtest {
	
	public static void main(String[] args) {
		
		
		//StringBuffer和StringBuilder都是可变对象，值是可以改变的（相对值而言的）
		//而String不是可变对象，它是final类型，一旦赋值就不能改，似乎和我们想象的有点不一样，但确实是这样的，
		//String 是引用类型,通过赋值，String类型的对象引用了别的对象（新创建的String对象），
		//和指针非常相似,而原始对象不能被改变，还是保留在堆中
		
		StringBuffer sbf = new StringBuffer("chen1");
		System.out.println(sbf.equals("chen1"));
		StringBuffer sbf2 = new StringBuffer("chen2");
		sbf2=sbf;
		System.out.println(sbf.hashCode());
		System.out.println(sbf2.hashCode());
		
		System.out.println(sbf.equals(sbf2));
		sbf.append("yun");
		System.out.println(sbf2);
		//以上证明StringBuffer 是可变对象
		
		
		String str = "chen";
		String str3 = "yun";
		
		System.out.println(str.hashCode());
		System.out.println("chen".hashCode());//str是引用了"chen"这个对象
		System.out.println(str3.hashCode());
		
		str3 = str;//str3改为引用"chen"
		
		System.out.println(str.hashCode());
		System.out.println(str3.hashCode());
		
		System.out.println(str.equals(str3));//输出ture
		
		str = "hello";
		System.out.println(str.hashCode());
		System.out.println("hello".hashCode());
		
		System.out.println(str.equals(str3));
		
		System.out.println(str3);
		
		System.out.println(str.equals("chen"));
		
		System.out.println(str.equals(sbf));
		
		String str1 = new String("chen");
		String str2 = new String("chen");
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str));
		
		str=sbf+"yun";
		
		System.out.println(str1.equals(str));
		

		StringBuilder sb = new StringBuilder("chen");
		
		System.out.println(sbf.equals(sb));
		ArrayList<String> strList = new ArrayList<String>();
		strList.add(str);
		System.out.println(strList.get(0));
	}
	
}

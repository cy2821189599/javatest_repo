package HashM;

import java.util.HashMap;
import java.util.Map;



public class TestHashMam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//无序map
		Map<Object, Object> map = new HashMap<>();
		map.put("1" ,"chenyun");
		System.out.println(map.get("1"));
		map.put("1" , "tom");//覆盖之前的key值相同的对象
		System.out.println(map.get("1"));
		map.put(1, 2);
		System.out.println(map.get(1));
		map.put("plumless", 10);
		map.put("buckeroo", 12);
		map.put(null, "nul-1");
		map.hashCode();
		map.put(null, "nul-2");//允许key值为null
		System.out.println(map.get(null));
		System.out.println(map.size());
		}
}

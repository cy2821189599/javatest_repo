package HashM;

import java.util.HashMap;


public class TestHashMam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Object, Object> map = new HashMap<>();
		map.put("1" ,"chenyun");
		System.out.println(map.get("1"));
		map.put("1" , "tom");
		System.out.println(map.get("1"));
		map.put(1, 2);
		System.out.println(map.get(1));
		}

}

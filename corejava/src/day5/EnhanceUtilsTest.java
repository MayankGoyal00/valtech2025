package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class EnhanceUtilsTest {

	@Test
	public void testMap() {
		Map<String, Integer> nums = Map.of("One",1,"Two",2,"three",3,"four",4);
		System.out.println(nums.getClass().getName());
		System.out.println(nums.keySet());
//		try {
//			nums.put("five",5);
//			fail("Immutable Map Expected ");
//		} catch (Exception ex) {
//			//ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		Map<String,Integer> nums1 =new HashMap<String,Integer>();
//		nums1.putAll(nums);
//		nums1.put("five",5);
		
	}
	
	
	@Test
	public void testList() {
		List<Integer> nums = List.of(1,2,3,4);  //varchar//immutable
		try {
			nums.add(5);
			fail("Immutable List Expected ");
		} catch (Exception ex) {
			//ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		List<Integer> nums1 =new ArrayList<Integer>();
		nums1.addAll(nums);
		nums1.add(5);
		
	}
	
	@Test
	public void testMapsConventional() {
		Map<String, Integer> nums = new HashMap<String,Integer>();//mutable
		nums.put("One",1);
		nums.put("two",2);
		nums.put("three",3);
	
	}
	
	@Test
	void testListConventional() {
		List<Integer> nums = new ArrayList<Integer>();//mutable
		nums.add(1);
		nums.add(2);
		nums.add(3);
		System.out.println(nums);
		List<Integer> nums1= Arrays.asList(1,2,3);//immutable
		assertEquals(nums,nums1);
	}

}

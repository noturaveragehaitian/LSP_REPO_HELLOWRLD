package org.howard.edu.lsp.midterm.question4;
import java.util.HashMap;


public class MapUtilities {
	public static int commonKeyValuePairs (
			HashMap<String, String> map1,
			HashMap<String, String> map2) {
		int count = 0;
		if (map1 == null || map2 == null) {
			return 0;
		} else {	// o(n^2) way of checking how many times a key is in a hashmap
			// reference by https://stackoverflow.com/questions/66436055/find-matching-key-value-pairs-in-hashmap
			for(String key : map1.keySet()) {
				if(map2.containsKey(key) && map2.get(key).equals(map1.get(key))) {
					count += 1;
				}
			}
			return count;
		}
	}
}

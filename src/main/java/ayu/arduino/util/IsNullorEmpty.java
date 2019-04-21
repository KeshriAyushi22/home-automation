package ayu.arduino.util;

import java.util.Collection;
import java.util.Map;

public class IsNullorEmpty {

	
	/**
	 * This method returns true if the collection is null or is empty.
	 * @param collection
	 * @return
	 */	
	public static boolean isNullOrEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns true of the map is null or is empty.
	 * @param map
	 * @return
	 */	
	public static boolean isNullOrEmpty(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns true if the object is null.
	 * @param object
	 * @return
	 */	
	public static boolean isNullOrEmpty(Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns true if the input array is null or its length is zero.
	 * @param array
	 * @return
	 */	
	public static boolean isNullOrEmpty(Object[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns true if the input string is null or its length is zero.
	 * @param string
	 * @return
	 */	
	public static boolean isNullOrEmpty(String string) {
		if (string == null || string.trim().isEmpty() || string.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns true if the input string  length is zero.
	 * @param string
	 * @return
	 */	
	public static boolean isEmpty(String string) {
		if (string.trim().isEmpty() || string.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns true if the input string is null.
	 * @param string
	 * @return
	 */
	public static boolean isNull(String string) {
		if (string == null) {
			return true;
		}
		return false;
	}


}

package ayu.arduino.helper;



import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {


	public static Object parseJson2Object(String jsonVal, Class cls){

		ObjectMapper test = new ObjectMapper();

		Object obj = null;
		try {
			obj = test.readValue(jsonVal, cls);
		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return obj;
	}

	public static Object parseJsonObject2Object(Object cls1, Class cls){

		ObjectMapper test = new ObjectMapper();

		Object obj = null;
		obj = test.convertValue(cls1, cls);
		return obj;
	}

	public static String parseObject2Json(Object obj, Class cls){

		String jsonValue = null;
		ObjectMapper test = new ObjectMapper();

		try {
			jsonValue = test.writeValueAsString(cls.cast(obj));
		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return jsonValue;
	}


}



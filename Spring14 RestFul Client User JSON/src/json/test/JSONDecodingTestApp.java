package json.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONDecodingTestApp {

	public static void main(String[] args) {
		String data = "{\"address\":\"����\",\"age\":1000,\"name\":\"ȫ�浿\"}";
		JSONObject jsonObj = (JSONObject) JSONValue.parse(data);
		System.out.println("json object " + jsonObj);

		System.out.println("����");
		System.out.println(jsonObj.get("address"));
		System.out.println("\n\n");

		String arrayData = "[\"����\",1000,\"ȫ�浿\"]";
		JSONArray jsonArray = (JSONArray) JSONValue.parse(arrayData);

		System.out.println("json object " + jsonObj);

		System.out.println("����");
		System.out.println(jsonArray.get(0));
	

	}

}

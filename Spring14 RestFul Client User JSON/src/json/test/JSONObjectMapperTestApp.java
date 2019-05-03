package json.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.sun.org.apache.xerces.internal.impl.xs.util.LSInputListImpl;

import spring.domain.User;

public class JSONObjectMapperTestApp {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		User user = new User("user01","ȫ�浿","1111",null,10);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("\n\n======================");
		System.out.println("1.domain->json value(string)");
		String jsonOneValue = objectMapper.writeValueAsString(user);
		System.out.println(jsonOneValue);
		
		System.out.println();
		
		System.out.println("1.json value-> domain object ��ȯ �� �� ����");
		User returnUser = objectMapper.readValue(jsonOneValue, User.class);
		System.out.println(returnUser);
		System.out.println("userId : "+returnUser.getUserId());

		System.out.println();
		
		System.out.println("1. json value-> jsonobject ��� �� �� ����");
		JSONObject jsonObj = (JSONObject) JSONValue.parse(jsonOneValue);
		System.out.println(jsonObj);
		System.out.println("userId : "+ jsonObj.get("userId"));
		
		System.out.println("\n\n======================");
		List<User> list = new ArrayList<User>(10);
		list.add(user);
		list.add(new User("user02","ȫ�浿","2222",null,20));
		
		System.out.println("2.list <user>->json value(string)");
		String jsonManyValue = objectMapper.writeValueAsString(list);
		System.out.println(jsonManyValue);
		
		System.out.println();
		
		System.out.println("2.json value-> List<user> ��ȯ �� �� ����");
		List<User> returnList = objectMapper.readValue(jsonManyValue, new TypeReference<List<User>>() {
		});
		System.out.println(returnList);
		System.out.println(returnList.get(0));
		System.out.println("userId : "+returnList.get(0).getUserId());

		System.out.println();
		
		System.out.println("2. json value-> jsonobject ��� �� �� ����");
		JSONArray jsonArray = (JSONArray) JSONValue.parse(jsonManyValue);
		System.out.println(jsonArray);
		System.out.println((JSONObject)jsonArray.get(0));
		System.out.println("userId : "+((JSONObject)jsonArray.get(0)).get("userId"));
		
		
		System.out.println("\n\n======================");
		Map<String,User> map = new HashMap<String,User>();
		map.put("1", user);
		map.put("2", new User("user02","ȫ�浿","2222",null,20));
		
		System.out.println("3.Map<User>->JSON value(String)���� ��ȯ");
		jsonManyValue = objectMapper.writeValueAsString(map);
		System.out.println(jsonManyValue);
		
		System.out.println();
		
		System.out.println("3. json value(String) -> Map<User> ��ȯ �� �� ����");
		Map<String,User> returnMap = objectMapper.readValue(jsonManyValue, new TypeReference<Map<String,User>>() {
		});
		System.out.println(returnMap);
		System.out.println(returnMap.get("1"));
		System.out.println(returnMap.get("1").getUserId());
		
		System.out.println();
		System.out.println("3.Json value -> jsonobject ��� �� �� ����");
		jsonObj =(JSONObject) JSONValue.parse(jsonManyValue);
		System.out.println(jsonObj);
		System.out.println((JSONObject)jsonObj.get("1"));
		System.out.println("userId : "+ ((JSONObject)jsonObj.get("1")).get("userId"));
		
		
	}

}

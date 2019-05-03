package json.test;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import spring.domain.Search;
import spring.domain.UserHasASearch;

public class UserHasASearchObjectMapperTestApp {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException  {
		
		UserHasASearch userHasASearch = new UserHasASearch();
		Search search = new Search();
		search.setSearchCondition("이름검색");
		userHasASearch.setSearch(search);
	
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("\n\n======================");
		System.out.println("1.domain->json value(string)");
		String jsonValue = objectMapper.writeValueAsString(userHasASearch);
		System.out.println(jsonValue);
		
		System.out.println();
		
		System.out.println("1.json value-> domain object 변환 과 값 추출");
		UserHasASearch returnUserHasASearch = objectMapper.readValue(jsonValue, UserHasASearch.class);
		System.out.println(returnUserHasASearch);
		System.out.println("userId : "+returnUserHasASearch.getUserId());
		System.out.println("search condition : "+returnUserHasASearch.getSearch().getSearchCondition());

		System.out.println();
		
		System.out.println("1. json value-> jsonobject 사용 과 값 추출");
		JSONObject jsonObj = (JSONObject) JSONValue.parse(jsonValue);
		System.out.println(jsonObj);
		System.out.println("userId : "+ jsonObj.get("userId"));
		System.out.println("search condition : "+((JSONObject)(jsonObj.get("search"))).get("searchCondition"));
		
		
		
		
	}

}

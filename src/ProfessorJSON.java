import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ProfessorJSON {
	
	private Map<String, String> dataMap;
	private String JSONString;
	private JSONObject JSONOb;
	
	public ProfessorJSON(Professor professor) throws IOException {
		
		dataMap = professor.getMap();
		
		JSONOb = new JSONObject(dataMap);
		JSONString = JSONOb.toString();
		
	}
	
	public String getJSONString(){
		
		return JSONString;
		
	}
	
	public JSONObject getJSONObject(){
		
		return JSONOb;
		
	}
	
	public Map<String, String> getDataMap(){
		
	return dataMap;
		
	}

}

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ProfessorsJSON {

	private List<Map<String, String>> phoneBookData = new LinkedList<Map<String, String>>();
	private String phoneBookJSON;
	private ProfessorJSON p;

	public ProfessorsJSON(PhoneBook phonebook) throws IOException {
		
		List<Professor> professors = phonebook.getProfessors();
		
		for (Professor professor: professors){
			
			p = new ProfessorJSON(professor);
			phoneBookData.add(p.getDataMap());
			
		}
		
		JSONObject professorsObj = new JSONObject();
		
		professorsObj.put("professors", phoneBookData);
		
		phoneBookJSON = JSONValue.toJSONString(professorsObj);
		
	}
	
	public String getJSON(){
		
		return phoneBookJSON;
		
		
	}

}

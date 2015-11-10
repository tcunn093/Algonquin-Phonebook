import com.cedarsoftware.*;
import com.cedarsoftware.util.io.JsonWriter;

import org.json.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProfessorsJSON {

	private List<Map<String, String>> phoneBookData = new LinkedList<Map<String, String>>();
	private String phoneBookJSON;
	private ProfessorJSON p;

	public ProfessorsJSON(PhoneBook phonebook) throws IOException, JSONException {
		
		List<Professor> professors = phonebook.getProfessors();
		
		for (Professor professor: professors){
			
			p = new ProfessorJSON(professor);
			phoneBookData.add(p.getDataMap());
			
		}
		
		JSONObject professorsObj = new JSONObject();
		
		professorsObj.put("professors", phoneBookData);
		
		
		
		phoneBookJSON = JsonWriter.formatJson(professorsObj.toString(3));
		
	}
	
	public String getJSON(){
		
		return phoneBookJSON;
		
		
	}

}

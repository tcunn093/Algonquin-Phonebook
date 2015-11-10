import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Professor {
	
	public String getAlias() {
		return alias;
	}

	public String getName() {
		return name;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public String getFax() {
		return fax;
	}

	public String getExtension() {
		return extension;
	}

	public String getVoicemail() {
		return voicemail;
	}

	public String getCampus() {
		return campus;
	}

	public String getRoom() {
		return room;
	}

	public String getTitle() {
		return title;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getDepartment() {
		return department;
	}
	
	public void display(){
		
		System.out.println("\n" + getAlias());
		System.out.println(getName());
		System.out.println(getVoicemail());
		
		
	}

	private String alias,
				   name,
				   primaryEmail,
				   officePhone,
				   fax,
				   extension,
				   voicemail,
				   campus,
				   room,
				   title,
				   alternateEmail,
				   department;
	
	private Map<String, String> dataMap;
	
	private String phoneBookEntryURL;
	
	private Scanner s;
	
	private BufferedReader reader;
	
	private String[] infoTitles = {"alias", 
								   "name", 
								   "Internet Email Address", 
								   "office_phone", 
								   "fax" , 
								   "extension", 
								   "vmail", 
								   "campus", 
								   "room", 
								   "title", 
								   "Alternate Email Address", 
								   "department"};
	
	
	public Map<String,String> getMap(){
		
	return dataMap;	
		
	}
	public Professor(String phoneBookEntryUrl) throws IOException{
		
		//Set the URL of the professor's phonebook page
		this.phoneBookEntryURL = phoneBookEntryUrl;
		
		dataMap = new HashMap<String, String>();
		
		//Get the HTML document from the URL
		
		Document doc = Jsoup.connect(phoneBookEntryUrl).get();
		
		//Retrieve raw professor info from HTML
		String rawInfo = doc.select("pre").first().text();
		
		reader = new BufferedReader(new StringReader(rawInfo));
		
		String line = reader.readLine();
		
		do {
			
			parseProfInfo(line);
			line = reader.readLine();
			
		} while (line != null);

		
	}
	
	
	private void parseProfInfo(String line){
		
		String data;
		
		for (String infoTitle: infoTitles){
			
			if (line.contains(infoTitle)){
				
				data = StringParsing.getWordsAfterString(line, ": ");
				
				switch (infoTitle) {
				
					case "alias": 
						alias = data;
						dataMap.put("alias", data);
						break;
									
					case "name": 
						name = data;
						dataMap.put("name", data);
						break;
								 
					case "Internet Email Address": 
						primaryEmail = data;
						dataMap.put("primaryEmail", data);
						break;
					
					case "office_phone":
						officePhone = data;
						dataMap.put("officePhone", data);
						break;
					
					case "fax":
						fax = data;
						dataMap.put("fax", data);
						break;
					
					case "extension":
						extension = data;
						dataMap.put("extension", data);
						break;
					
					case "vmail":
						voicemail = data;
						dataMap.put("voicemail", data);
						break;
						
					case "campus":
						campus = data;
						dataMap.put("campus", data);
						break;
					
					case "room":
						room = data;
						dataMap.put("room", data);
						break;
					
					case "title":
						title = data;
						dataMap.put("title", data);
						break;
						
					case "Alternate Email Address":
						alternateEmail = data;
						dataMap.put("alternateEmail", data);
						break;
						
					case "department":
						department = data;
						dataMap.put("department", data);
						break;
						
				}
				
			}
			
			
		}
			
			
		}
		
		
			
	}
	
	
	
	

	
	

	
	
	


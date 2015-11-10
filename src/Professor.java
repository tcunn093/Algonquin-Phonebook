import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
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
	
	public Professor(String phoneBookEntryUrl) throws IOException{
		
		//Set the URL of the professor's phonebook page
		this.phoneBookEntryURL = phoneBookEntryUrl;
		
		//Get the HTML document from the URL
		
		Document doc = Jsoup.connect(phoneBookEntryUrl).get();
		
		//Retrieve raw professor info from HTML
		String rawInfo = doc.select("pre").first().text();
		
		System.out.print(rawInfo);
		
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
						break;
									
					case "name": 
						name = data;
						break;
								 
					case "Internet Email Address": 
						primaryEmail = data;
						break;
					
					case "office_phone":
						officePhone = data;
						break;
					
					case "fax":
						fax = data;
						break;
					
					case "extension":
						extension = data;
						break;
					
					case "vmail":
						voicemail = data;
						break;
						
					case "campus":
						campus = data;
						break;
					
					case "room":
						room = data;
						break;
					
					case "title":
						title = data;
						break;
						
					case "Alternate Email Address":
						alternateEmail = data;
						break;
						
					case "department":
						department = data;
						break;
						
					default: System.out.println(data);
						
				}
				
			}
			
			
		}
			
			
		}
		
		
			
	}
	
	
	
	

	
	

	
	
	


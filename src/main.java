import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONException;


public class main {

	public static void main(String[] args) throws IOException, JSONException {
		
		PhoneBook p = new PhoneBook();
		
		ProfessorsJSON phbJSON = new ProfessorsJSON(p);
		
		PrintWriter pw = new PrintWriter("C:\\Users\\Thomas\\Workspace\\Algonquin Phonebook Scrape\\src\\professorsJSON.txt");
		pw.println(phbJSON.getJSON());
		pw.close();

		
	}
	
	

}

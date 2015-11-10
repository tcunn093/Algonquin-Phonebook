
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PhoneBook {
	
	private static String html;
	private final String phoneBookURL  = "http://algwww2.algonquincollege.com/cgi-bin/WebPh?DB=csnet-ns&server=algwww2.algonquincollege.com";
	private List<Professor> professors;
	
	static{
		
		byte[] data = null;
		
		try{
			
			File file = new File("C:\\Users\\Thomas\\Workspace\\Algonquin Phonebook Scrape\\src\\PhoneBook HTML.txt");
			FileInputStream fis = new FileInputStream(file);
			
			data = new byte[(int) file.length()];
			
			fis.read(data);
			fis.close();
		
		} catch (IOException io){
			
			io.printStackTrace();
			
		}
		
		try {
			
			html = new String(data, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	public PhoneBook() throws IOException {
		
		professors = new ArrayList<Professor>();
		
		Document doc = Jsoup.parse(html);

		Elements links = doc.select("a[href]");
		
		for (Element link: links.subList(1, links.size() - 660)){
			
			addProfessor(link.attr("href"));
			
		}
		
	}
	
	public List<Professor> getProfessors(){
		
		return professors;
		
	}
	
	private void addProfessor(String url) throws IOException{
		
		Professor professor = new Professor(url);
		
		professors.add(professor);
		
		System.out.println(professor.getName() + " added to Phonebook");
		
	}
	
	

}

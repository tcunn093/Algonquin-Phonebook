import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;



public class main {

	public static void main(String[] args) throws IOException {
		
		PhoneBook p = new PhoneBook();
		

			//Professor pr = new Professor("http://algwww2.algonquincollege.com:80/cgi-bin/WebPh?DB=csnet-ns&ns_server=algwww2.algonquincollege.com&alias=abbass");
			
			//ProfessorJSON prj = new ProfessorJSON(pr);
		
		ProfessorsJSON phbJSON = new ProfessorsJSON(p);
		
		PrintWriter pw = new PrintWriter("C:\\Users\\Thomas\\Desktop\\test\\users.txt");
		pw.println(phbJSON.getJSON());
		pw.close();

		
	}
	
	

}

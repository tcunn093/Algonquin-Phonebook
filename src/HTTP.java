import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class HTTP {

	public HTTP() throws ParseException, IOException {
		
		HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost("http://algwww2.algonquincollege.com/cgi-bin/WebPh?DB=csnet-ns&server=algwww2.algonquincollege.com");
             
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("College job title(s).", "Professor"));
 
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
            HttpResponse response = httpClient.execute(httpPost);
 
            HttpEntity entity = response.getEntity();
            String pageHTML = EntityUtils.toString(entity);
            System.out.println(pageHTML);
            EntityUtils.consume(entity);
         
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
		
	}

}

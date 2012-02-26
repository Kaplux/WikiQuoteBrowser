package fr.wikiQuoteBrowser;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class WikiQuoteAccess {
	
	String baseUrl;
	
	public WikiQuoteAccess(String baseUrl){
		this.baseUrl =baseUrl;
		
	}
	
	public String searchQuote(String searchSring){
		String result="";
		try
		{
		HttpClient hc = new DefaultHttpClient();
		HttpGet get = new HttpGet(baseUrl+"?action=query&titles="+searchSring+"&prop=revisions&rvprop=content&format=jsonfm");

		HttpResponse rp = hc.execute(get);

		if(rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
		{
			result= EntityUtils.toString(rp.getEntity());
		}
		}catch(IOException e){

		}
		return result;
	}

}

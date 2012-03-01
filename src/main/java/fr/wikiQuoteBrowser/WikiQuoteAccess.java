package fr.wikiQuoteBrowser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class WikiQuoteAccess {

	String baseUrl;

	public WikiQuoteAccess(String baseUrl) {
		this.baseUrl = baseUrl;

	}

	public List<String> searchQuote(String searchSring) throws ClientProtocolException, IOException {
		List<String> result = new ArrayList<String>();
			HttpClient hc = new DefaultHttpClient();
			HttpGet get = new HttpGet(baseUrl + "?action=opensearch&search="
					+ searchSring + "&namespace=0&format=json");

			HttpResponse rp = hc.execute(get);

			if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String jacksonResult = EntityUtils.toString(rp.getEntity());
				ObjectMapper mapper = new ObjectMapper();
				
				Object[] o = mapper.readValue(jacksonResult,
						Object[].class);
				result = (List<String>) o[1];

			}
		
		return result;
	}

}

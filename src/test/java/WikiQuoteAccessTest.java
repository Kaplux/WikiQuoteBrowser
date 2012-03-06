import java.io.IOException;

import junit.framework.TestCase;

import org.apache.http.client.ClientProtocolException;

import fr.wikiQuoteBrowser.WikiQuoteAccess;


public class WikiQuoteAccessTest extends TestCase{

	public void testSearchQuote() throws Exception {
		WikiQuoteAccess wiki=new WikiQuoteAccess("http://en.wikiquote.org/w/api.php");
    	String searchCriteria= "cleese";
    	String[] result;
		result = wiki.searchQuote(searchCriteria);
	}

	public void testgetQuotePage() throws ClientProtocolException, IOException {
		WikiQuoteAccess wiki=new WikiQuoteAccess("http://en.wikiquote.org/w/api.php");
    	String searchCriteria= "Main%20Page";
    	String result;
		result = wiki.getQuotePage(searchCriteria);
	}


}

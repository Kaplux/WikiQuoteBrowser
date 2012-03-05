import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import fr.wikiQuoteBrowser.WikiQuoteAccess;


public class WikiQuoteAccessTest {

	@Test
	public void test() throws ClientProtocolException, IOException {
		WikiQuoteAccess wiki=new WikiQuoteAccess("http://en.wikiquote.org/w/api.php");
    	String searchCriteria= "cleese";
    	String[] result;
		result = wiki.searchQuote(searchCriteria);
	}
	
	@Test
	public void test2() throws ClientProtocolException, IOException {
		WikiQuoteAccess wiki=new WikiQuoteAccess("http://en.wikiquote.org/w/api.php");
    	String searchCriteria= "Main%20Page";
    	String result;
		result = wiki.getQuotePage(searchCriteria);
	}


}

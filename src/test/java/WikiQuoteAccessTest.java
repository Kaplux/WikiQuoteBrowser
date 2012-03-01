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
    	List<String> result;
		result = wiki.searchQuote(searchCriteria);
	}

}

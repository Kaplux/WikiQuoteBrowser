package fr.wikiQuoteBrowser;

import java.io.IOException;
import java.net.URLEncoder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import fr.kaplux.R;

public class DisplayQuoteActivity extends Activity {

    private static String TAG = "testAndroid";
    
 
    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		
        setContentView(R.layout.display_quote_layout);
        WebView quoteDisplayView=(WebView)findViewById(R.id.quoteDisplay);
        String pageName=this.getIntent().getExtras().getString("selectedPage");
        WikiQuoteAccess wiki=new WikiQuoteAccess("http://en.wikiquote.org/w/api.php");
        
       
		//	quoteDisplayView.loadData(wiki.getQuotePage(pageName), "text/html", null);
			quoteDisplayView.loadUrl("http://en.wikiquote.org/wiki/"+pageName.replaceAll(" ", "_"));
		
		
      
    }

 

}


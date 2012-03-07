package fr.wikiQuoteBrowser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import fr.wikiquotebrowser.R;

public class DisplayQuotePageActivity extends Activity {

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
     
	
		quoteDisplayView.loadUrl("http://en.wikiquote.org/w/index.php?action=render&title="+pageName.replaceAll(" ", "_"));
		
      
    }

 

}

